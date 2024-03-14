package com.example.limbusDeckMaker.service;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.dto.response.IdentityDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityListInfoDto;
import com.example.limbusDeckMaker.repository.IdentityRepository;
import com.example.limbusDeckMaker.repository.specification.IdentitySpecification;
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

    public List<IdentityListInfoDto> getIdentityByCriteria(Long sinnerId, Integer season, Integer grade) {
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

        List<Identity> identities = identityRepository.findAll(spec);

        return identities.stream()
            .map(IdentityListInfoDto::toDto)
            .collect(Collectors.toList());
    }
}
