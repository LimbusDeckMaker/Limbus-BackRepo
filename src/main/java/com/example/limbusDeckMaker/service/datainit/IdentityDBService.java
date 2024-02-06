package com.example.limbusDeckMaker.service.datainit;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.domain.IdentityDefSkill;
import com.example.limbusDeckMaker.domain.IdentityPassive;
import com.example.limbusDeckMaker.domain.IdentitySkill1;
import com.example.limbusDeckMaker.domain.IdentitySkill2;
import com.example.limbusDeckMaker.domain.IdentitySkill3;
import com.example.limbusDeckMaker.dto.IdentityDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3IdentityDefSkillDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3IdentityPassiveDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySkill1Dto;
import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySkill2Dto;
import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySkill3Dto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentityDefSkillDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentityPassiveDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySkill1Dto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySkill2Dto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySkill3Dto;
import com.example.limbusDeckMaker.repository.IdentityDefSkillRepository;
import com.example.limbusDeckMaker.repository.IdentityPassiveRepository;
import com.example.limbusDeckMaker.repository.IdentityRepository;
import com.example.limbusDeckMaker.repository.IdentitySkill1Repository;
import com.example.limbusDeckMaker.repository.IdentitySkill2Repository;
import com.example.limbusDeckMaker.repository.IdentitySkill3Repository;
import com.example.limbusDeckMaker.repository.SinnerRepository;
import com.example.limbusDeckMaker.util.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class IdentityDBService {

    private final SinnerRepository sinnerRepository;
    private final IdentityRepository identityRepository;
    private final IdentityPassiveRepository identityPassiveRepository;
    private final IdentitySkill1Repository identitySkill1Repository;
    private final IdentitySkill2Repository identitySkill2Repository;
    private final IdentitySkill3Repository identitySkill3Repository;
    private final IdentityDefSkillRepository identityDefSkillRepository;
    private final JsonParser jsonParser;


    public IdentityDBService(SinnerRepository sinnerRepository,
        IdentityRepository identityRepository,
        IdentityPassiveRepository identityPassiveRepository,
        IdentitySkill1Repository identitySkill1Repository,
        IdentitySkill2Repository identitySkill2Repository,
        IdentitySkill3Repository identitySkill3Repository,
        IdentityDefSkillRepository identityDefSkillRepository, JsonParser jsonParser) {

        this.sinnerRepository = sinnerRepository;
        this.identityRepository = identityRepository;
        this.identityPassiveRepository = identityPassiveRepository;
        this.identitySkill1Repository = identitySkill1Repository;
        this.identitySkill2Repository = identitySkill2Repository;
        this.identitySkill3Repository = identitySkill3Repository;
        this.identityDefSkillRepository = identityDefSkillRepository;
        this.jsonParser = jsonParser;
    }

    @Transactional
    public void processAndSaveData(String fileKey) throws IOException {
        List<IdentityDto> identities = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync3IdentityPassiveDto> sync3IdentityPassives = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync4IdentityPassiveDto> sync4IdentityPassives = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync3IdentitySkill1Dto> sync3IdentitySkill1s = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync4IdentitySkill1Dto> sync4IdentitySkill1s = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync3IdentitySkill2Dto> sync3IdentitySkill2s = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync4IdentitySkill2Dto> sync4IdentitySkill2s = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync3IdentitySkill3Dto> sync3IdentitySkill3s = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync4IdentitySkill3Dto> sync4IdentitySkill3s = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync3IdentityDefSkillDto> sync3IdentityDefSkills = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});
        List<Sync4IdentityDefSkillDto> sync4IdentityDefSkills = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {});

        identities.forEach(identityDto -> {
            sinnerRepository.findByName(identityDto.getCharacter()).ifPresent(
                identityDto::setSinner);
            Identity identity = Identity.toEntity(identityDto);
            identityRepository.save(identity);

            processDto(sync3IdentityPassives, identity,
                passive -> passive.getIdentityName().equals(identity.getName()),
                IdentityPassive::toEntity,
                identityPassiveRepository);

            processDto(sync4IdentityPassives, identity,
                passive -> passive.getIdentityName().equals(identity.getName()),
                IdentityPassive::toEntity,
                identityPassiveRepository);

            processDto(sync3IdentitySkill1s, identity,
                skill1 -> skill1.getIdentityName().equals(identity.getName()),
                IdentitySkill1::toEntity,
                identitySkill1Repository);

            processDto(sync4IdentitySkill1s, identity,
                skill1 -> skill1.getIdentityName().equals(identity.getName()),
                IdentitySkill1::toEntity,
                identitySkill1Repository);

            processDto(sync3IdentitySkill2s, identity,
                skill2 -> skill2.getIdentityName().equals(identity.getName()),
                IdentitySkill2::toEntity,
                identitySkill2Repository);

            processDto(sync4IdentitySkill2s, identity,
                skill2 -> skill2.getIdentityName().equals(identity.getName()),
                IdentitySkill2::toEntity,
                identitySkill2Repository);

            processDto(sync3IdentitySkill3s, identity,
                skill3 -> skill3.getIdentityName().equals(identity.getName()),
                IdentitySkill3::toEntity,
                identitySkill3Repository);

            processDto(sync4IdentitySkill3s, identity,
                skill3 -> skill3.getIdentityName().equals(identity.getName()),
                IdentitySkill3::toEntity,
                identitySkill3Repository);

            processDto(sync3IdentityDefSkills, identity,
                defSkill -> defSkill.getIdentityName().equals(identity.getName()),
                IdentityDefSkill::toEntity,
                identityDefSkillRepository);

            processDto(sync4IdentityDefSkills, identity,
                defSkill -> defSkill.getIdentityName().equals(identity.getName()),
                IdentityDefSkill::toEntity,
                identityDefSkillRepository);

        });
    }

    private <T, R> void processDto(List<T> dtos, Identity identity, Predicate<T> condition,
        Function<T, R> toEntityFunction, JpaRepository<R, ?> repository) {
        dtos.stream()
            .filter(condition)
            .forEach(dto -> {
                setIdentityIfPresent(dto, identity);
                R entity = toEntityFunction.apply(dto);
                repository.save(entity);
            });
    }

    private <T> void setIdentityIfPresent(T dto, Identity identity) {
        try {
            Method setIdentityMethod = dto.getClass().getMethod("setIdentity", Identity.class);
            setIdentityMethod.invoke(dto, identity);
        } catch (NoSuchMethodException e) {
            System.out.println("No setIdentity method found for DTO: " + dto.getClass().getName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error setting identity for DTO: " + dto.getClass().getName(), e);
        }
    }

}
