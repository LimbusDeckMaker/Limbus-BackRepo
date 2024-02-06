package com.example.limbusDeckMaker.service.datainit;

import com.example.limbusDeckMaker.domain.CorrosionSkill;
import com.example.limbusDeckMaker.domain.Ego;
import com.example.limbusDeckMaker.domain.EgoSkill;
import com.example.limbusDeckMaker.dto.EgoDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3CorrosionSkillDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3EgoSkillDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4CorrosionSkillDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4EgoSkillDto;
import com.example.limbusDeckMaker.repository.CorrosionSkillRepository;
import com.example.limbusDeckMaker.repository.EgoRepository;
import com.example.limbusDeckMaker.repository.EgoSkillRepository;
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
@Transactional
public class EgoDBService {

    private final SinnerRepository sinnerRepository;
    private final EgoRepository egoRepository;
    private final EgoSkillRepository egoSkillRepository;
    private final CorrosionSkillRepository corrosionSkillRepository;
    private final JsonParser jsonParser;

    public EgoDBService(SinnerRepository sinnerRepository, EgoRepository egoRepository,
        EgoSkillRepository egoSkillRepository, CorrosionSkillRepository corrosionSkillRepository,
        JsonParser jsonParser) {
        this.sinnerRepository = sinnerRepository;
        this.egoRepository = egoRepository;
        this.egoSkillRepository = egoSkillRepository;
        this.corrosionSkillRepository = corrosionSkillRepository;
        this.jsonParser = jsonParser;
    }

    @Transactional
    public void processAndSaveData(String fileKey) throws IOException {
        List<EgoDto> egos = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {
            });
        List<Sync3EgoSkillDto> sync3EgoSkills = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {
            });
        List<Sync4EgoSkillDto> sync4EgoSkills = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {
            });
        List<Sync3CorrosionSkillDto> sync3CorSkills = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {
            });
        List<Sync4CorrosionSkillDto> sync4CorSkills = jsonParser.parseJsonFromS3(fileKey,
            new TypeReference<>() {
            });

        egos.forEach(egoDto -> {
            sinnerRepository.findByName(egoDto.getName()).ifPresent(
                egoDto::setSinner);
            Ego ego = Ego.toEntity(egoDto);
            egoRepository.save(ego);

            processDto(sync3EgoSkills, ego,
                egoSKill -> egoSKill.getName().equals(ego.getName()),
                EgoSkill::toEntity,
                egoSkillRepository);

            processDto(sync4EgoSkills, ego,
                egoSKill -> egoSKill.getName().equals(ego.getName()),
                EgoSkill::toEntity,
                egoSkillRepository);

            processDto(sync3CorSkills, ego,
                corSKill -> corSKill.getName().equals(ego.getName()),
                CorrosionSkill::toEntity,
                corrosionSkillRepository);

            processDto(sync4CorSkills, ego,
                corSKill -> corSKill.getName().equals(ego.getName()),
                CorrosionSkill::toEntity,
                corrosionSkillRepository);

        });

    }


    private <T, R> void processDto(List<T> dtos, Ego ego, Predicate<T> condition,
        Function<T, R> toEntityFunction, JpaRepository<R, ?> repository) {
        dtos.stream()
            .filter(condition)
            .forEach(dto -> {
                setEgoIfPresent(dto, ego);
                R entity = toEntityFunction.apply(dto);
                repository.save(entity);
            });
    }

    private <T> void setEgoIfPresent(T dto, Ego ego) {
        try {
            Method setEgoMethod = dto.getClass().getMethod("setIdentity", Ego.class);
            setEgoMethod.invoke(dto, ego);
        } catch (NoSuchMethodException e) {
            System.out.println("No setIdentity method found for DTO: " + dto.getClass().getName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error setting identity for DTO: " + dto.getClass().getName(), e);
        }
    }

}
