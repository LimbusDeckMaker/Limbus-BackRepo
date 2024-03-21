package com.example.limbusDeckMaker.service;

import static com.example.limbusDeckMaker.service.mapper.EgoListInfoMapper.*;

import com.example.limbusDeckMaker.domain.Ego;
import com.example.limbusDeckMaker.dto.response.EgoContext;
import com.example.limbusDeckMaker.dto.response.EgoDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.EgoListInfoDto;
import com.example.limbusDeckMaker.repository.EgoRepository;
import com.example.limbusDeckMaker.repository.specification.EgoSpecification;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EgoService {

    private final EgoRepository egoRepository;

    public EgoService(EgoRepository egoRepository) {
        this.egoRepository = egoRepository;
    }

    public Optional<EgoDetailInfoDto> getSpecificEgo(Long id) {
        return egoRepository.findById(id)
            .map(EgoDetailInfoDto::toDto);
    }

    public List<EgoListInfoDto> getEgoByCriteria(Long sinnerId, Integer season, String grade,
        List<String> keywords, List<String> resources, List<String> types, Integer minWeight,
        Integer maxWeight) {

        Specification<Ego> spec = Specification.where(null);
        if (sinnerId != null) {
            spec = spec.and(EgoSpecification.hasSinnerId(sinnerId));
        }
        if (season != null) {
            spec = spec.and(EgoSpecification.hasSeason(season));
        }
        if (grade != null) {
            spec = spec.and(EgoSpecification.hasGrade(grade));
        }

        List<Ego> egos = egoRepository.findAll(spec);
        List<EgoContext> egoContexts = egos.stream()
            .map(ego -> new EgoContext(ego,
                findUseResources(ego),
                findUseTypes(ego),
                findMinWeight(ego),
                findMaxWeight(ego)))
            .toList();

        return egoContexts.stream()
            .filter(context -> matchesKeywords(context, keywords))
            .filter(context -> matchesResources(context, resources))
            .filter(context -> matchesTypes(context, types))
            .filter(context -> matchesWeight(context, minWeight, maxWeight))
            .map(context -> EgoListInfoDto.toDto(context.getEgo(), context))
            .collect(Collectors.toList());

    }

    private boolean matchesKeywords(EgoContext context, List<String> keywords) {
        if (keywords == null || keywords.isEmpty()) {
            return true;
        }
        return keywords.stream().allMatch(keyword -> context.getEgo().getKeyword().contains(keyword));
    }

    private boolean matchesResources(EgoContext context, List<String> resources) {
        if (resources == null || resources.isEmpty()) {
            return true;
        }
        return resources.stream().allMatch(resource -> context.getResources().contains(resource));
    }

    private boolean matchesTypes(EgoContext context, List<String> types) {
        if (types == null || types.isEmpty()) {
            return true;
        }
        return types.stream().allMatch(type -> context.getTypes().contains(type));
    }

    private boolean matchesWeight(EgoContext context, Integer minWeight, Integer maxWeight) {
        boolean matchesMin = minWeight == null || context.getMinWeight().equals(minWeight);
        boolean matchesMax = maxWeight == null || context.getMaxWeight().equals(maxWeight);
        return matchesMin && matchesMax;
    }

}
