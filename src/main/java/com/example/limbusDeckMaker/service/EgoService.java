package com.example.limbusDeckMaker.service;

import com.example.limbusDeckMaker.domain.Ego;
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

    public List<EgoListInfoDto> getEgoByCriteria(Long sinnerId, Integer season, String grade) {
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

        return egos.stream()
            .map(EgoListInfoDto::toDto)
            .collect(Collectors.toList());
    }

}
