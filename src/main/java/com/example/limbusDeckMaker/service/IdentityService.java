package com.example.limbusDeckMaker.service;

import static com.example.limbusDeckMaker.service.mapper.IdentityListInfoMapper.*;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.dto.response.EgoContext;
import com.example.limbusDeckMaker.dto.response.EgoListInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityContext;
import com.example.limbusDeckMaker.dto.response.IdentityDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityListInfoDto;
import com.example.limbusDeckMaker.repository.IdentityRepository;
import com.example.limbusDeckMaker.repository.specification.IdentitySpecification;
import com.example.limbusDeckMaker.service.mapper.IdentityListInfoMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    private final IdentityRepository identityRepository;

    public IdentityService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public Optional<IdentityDetailInfoDto> getSpecificIdentity(Long id) {
        return identityRepository.findById(id)
            .map(IdentityDetailInfoDto::toDto);
    }

    public List<IdentityListInfoDto> getIdentityByCriteria(Long sinnerId, Integer season, Integer grade,
        String affiliation, List<String> keywords, List<String> resources, List<String> types,
        Integer minWeight, Integer maxWeight, Integer minSpeed, Integer maxSpeed) {

        Specification<Identity> spec = Specification.where(null);

        if (sinnerId != null) {
            spec = spec.and(IdentitySpecification.hasSinnerId(sinnerId));
        }
        if (season != null) {
            spec = spec.and(IdentitySpecification.hasSeason(season));
        }
        if (grade != null) {
            spec = spec.and(IdentitySpecification.hasGrade(grade));
        }
        if (affiliation != null){
            spec = spec.and(IdentitySpecification.hasAffiliation(affiliation));
        }

        List<Identity> identities = identityRepository.findAll(spec);
        List<IdentityContext> identityContexts = identities.stream()
            .map(identity -> new IdentityContext(identity,
                findUseResources(identity),
                findUseTypes(identity),
                findMinWeight(identity),
                findMaxWeight(identity),
                parseMinSpeed(identity.getStatus().getSpeed()),
                parseMaxSpeed(identity.getStatus().getSpeed())))
            .toList();

        return identityContexts.stream()
            .filter(context -> matchesKeywords(context, keywords))
            .filter(context -> matchesResources(context, resources))
            .filter(context -> matchesTypes(context, types))
            .filter(context -> matchesWeight(context, minWeight, maxWeight))
            .filter(context -> matchesSpeed(context, minSpeed, maxSpeed))
            .map(context -> IdentityListInfoDto.toDto(context.getIdentity(), context))
            .collect(Collectors.toList());
    }

    private boolean matchesKeywords(IdentityContext context, List<String> keywords) {
        if (keywords == null || keywords.isEmpty()) {
            return true;
        }
        return keywords.stream().allMatch(keyword -> context.getIdentity().getKeyword().contains(keyword));
    }

    private boolean matchesResources(IdentityContext context, List<String> resources) {
        if (resources == null || resources.isEmpty()) {
            return true;
        }
        return resources.stream().allMatch(resource -> context.getResources().contains(resource));
    }

    private boolean matchesTypes(IdentityContext context, List<String> types) {
        if (types == null || types.isEmpty()) {
            return true;
        }
        return types.stream().allMatch(type -> context.getTypes().contains(type));
    }

    private boolean matchesWeight(IdentityContext context, Integer minWeight, Integer maxWeight) {
        boolean matchesMin = minWeight == null || context.getMinWeight().equals(minWeight);
        boolean matchesMax = maxWeight == null || context.getMaxWeight().equals(maxWeight);
        return matchesMin && matchesMax;
    }

    private boolean matchesSpeed(IdentityContext context, Integer minSpeed, Integer maxSpeed) {
        boolean matchesMin = minSpeed == null || context.getMinSpeed().equals(minSpeed);
        boolean matchesMax = maxSpeed == null || context.getMaxSpeed().equals(maxSpeed);
        return matchesMin && matchesMax;
    }
}
