package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.dto.*;
import com.example.demo.dto.sync3.*;
import com.example.demo.dto.sync4.*;
import com.example.demo.repository.*;
import com.example.demo.util.JsonParser;
import com.example.demo.util.SinnerNameMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class IdentityDBInitService {

    private final SinnerRepository sinnerRepository;
    private final IdentityRepository identityRepository;
    private final IdentityPassiveRepository identityPassiveRepository;
    private final IdentitySkill1Repository identitySkill1Repository;
    private final IdentitySkill2Repository identitySkill2Repository;
    private final IdentitySkill3Repository identitySkill3Repository;
    private final IdentityDefSkillRepository identityDefSkillRepository;

    public IdentityDBInitService(SinnerRepository sinnerRepository, IdentityRepository identityRepository,
                                 IdentityPassiveRepository identityPassiveRepository, IdentitySkill1Repository identitySkill1Repository,
                                 IdentitySkill2Repository identitySkill2Repository, IdentitySkill3Repository identitySkill3Repository,
                                 IdentityDefSkillRepository identityDefSkillRepository){

        this.sinnerRepository = sinnerRepository;
        this.identityRepository = identityRepository;
        this.identityPassiveRepository = identityPassiveRepository;
        this.identitySkill1Repository = identitySkill1Repository;
        this.identitySkill2Repository = identitySkill2Repository;
        this.identitySkill3Repository = identitySkill3Repository;
        this.identityDefSkillRepository = identityDefSkillRepository;
    }

    @Transactional
    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        String sinnerName = SinnerNameMapping.extractSinnerFromFile(fileName);

        List<IdentityDto> identities = JsonParser.parseJsonForIdentity(jsonFilePath);

        List<Sync3IdentityPassiveDto> sync3IdentityPassives = JsonParser.parseJsonForIdentitySync3Passive(jsonFilePath);
        List<Sync4IdentityPassiveDto> identityPassives = JsonParser.parseJsonForIdentityPassive(jsonFilePath);

        List<Sync3IdentitySkill1Dto> sync3IdentitySkill1s = JsonParser.parseJsonForIdentitySync3Skill1(jsonFilePath);
        List<Sync4IdentitySkill1Dto> identitySkill1s = JsonParser.parseJsonForIdentitySkill1(jsonFilePath);


        List<Sync3IdentitySkill2Dto> sync3IdentitySkill2s = JsonParser.parseJsonForIdentitySync3Skill2(jsonFilePath);
        List<Sync4IdentitySkill2Dto> identitySkill2s = JsonParser.parseJsonForIdentitySkill2(jsonFilePath);

        List<Sync3IdentitySkill3Dto> sync3IdentitySkill3s = JsonParser.parseJsonForIdentitySync3Skill3(jsonFilePath);
        List<Sync4IdentitySkill3Dto> identitySkill3s = JsonParser.parseJsonForIdentitySkill3(jsonFilePath);

        List<Sync3IdentityDefSkillDto> sync3IdentityDefSkills = JsonParser.parseJsonForIdentitySync3DefSkill(jsonFilePath);
        List<Sync4IdentityDefSkillDto> identityDefSkills = JsonParser.parseJsonForIdentityDefSkill(jsonFilePath);




        Optional<Sinner> sinnerOptional = sinnerRepository.findByName(sinnerName);


        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();

            for (IdentityDto identityDto : identities) {
                identityDto.setSinner(sinner);
                Identity identity = Identity.toEntity(identityDto);
                identityRepository.save(identity);

                Sync3IdentityPassiveDto sync3IdentityPassiveDto = findSync3PassiveForIdentity(sync3IdentityPassives, identity.getName());
                sync3IdentityPassiveDto.setIdentity(identity);
                IdentityPassive sync3IdentityPassive = IdentityPassive.toEntity(sync3IdentityPassiveDto);
                identityPassiveRepository.save(sync3IdentityPassive);

                Sync4IdentityPassiveDto sync4IdentityPassiveDto = findPassiveForIdentity(identityPassives, identity.getName());
                sync4IdentityPassiveDto.setIdentity(identity);
                IdentityPassive identityPassive = IdentityPassive.toEntity(sync4IdentityPassiveDto);
                identityPassiveRepository.save(identityPassive);

                Sync3IdentitySkill1Dto sync3IdentitySkill1Dto = findSync3Skill1ForIdentity(sync3IdentitySkill1s, identity.getName());
                sync3IdentitySkill1Dto.setIdentity(identity);
                IdentitySkill1 sync3IdentitySkill1 = IdentitySkill1.toEntity(sync3IdentitySkill1Dto);
                identitySkill1Repository.save(sync3IdentitySkill1);

                Sync4IdentitySkill1Dto identitySkill1Dto = findSkill1ForIdentity(identitySkill1s, identity.getName());
                identitySkill1Dto.setIdentity(identity);
                IdentitySkill1 identitySkill1 = IdentitySkill1.toEntity(identitySkill1Dto);
                identitySkill1Repository.save(identitySkill1);

                Sync3IdentitySkill2Dto sync3IdentitySkill2Dto = findSync3Skill2ForIdentity(sync3IdentitySkill2s, identity.getName());
                sync3IdentitySkill2Dto.setIdentity(identity);
                IdentitySkill2 sync3IdentitySkill2 = IdentitySkill2.toEntity(sync3IdentitySkill2Dto);
                identitySkill2Repository.save(sync3IdentitySkill2);

                Sync4IdentitySkill2Dto sync4IdentitySkill2Dto = findSkill2ForIdentity(identitySkill2s, identity.getName());
                sync4IdentitySkill2Dto.setIdentity(identity);
                IdentitySkill2 identitySkill2 = IdentitySkill2.toEntity(sync4IdentitySkill2Dto);
                identitySkill2Repository.save(identitySkill2);

                Sync3IdentitySkill3Dto sync3IdentitySkill3Dto = findSync3Skill3ForIdentity(sync3IdentitySkill3s, identity.getName());
                sync3IdentitySkill3Dto.setIdentity(identity);
                IdentitySkill3 sync3IdentitySkill3 = IdentitySkill3.toEntity(sync3IdentitySkill3Dto);
                identitySkill3Repository.save(sync3IdentitySkill3);

                Sync4IdentitySkill3Dto sync4IdentitySkill3Dto = findSkill3ForIdentity(identitySkill3s, identity.getName());
                sync4IdentitySkill3Dto.setIdentity(identity);
                IdentitySkill3 identitySkill3 = IdentitySkill3.toEntity(sync4IdentitySkill3Dto);
                identitySkill3Repository.save(identitySkill3);


                Sync3IdentityDefSkillDto sync3IdentityDefSkillDto = findSync3DefSkillForIdentity(sync3IdentityDefSkills, identity.getName());
                sync3IdentityDefSkillDto.setIdentity(identity);
                IdentityDefSkill sync3IdentityDefSkill = IdentityDefSkill.toEntity(sync3IdentityDefSkillDto);
                identityDefSkillRepository.save(sync3IdentityDefSkill);

                Sync4IdentityDefSkillDto sync4IdentityDefSkillDto = findDefSkillForIdentity(identityDefSkills, identity.getName());
                sync4IdentityDefSkillDto.setIdentity(identity);
                IdentityDefSkill identityDefSkill = IdentityDefSkill.toEntity(sync4IdentityDefSkillDto);
                identityDefSkillRepository.save(identityDefSkill);
            }
        }
    }

    private Sync3IdentityPassiveDto findSync3PassiveForIdentity(List<Sync3IdentityPassiveDto> identityPassives, String identityName) {
        return identityPassives.stream()
                .filter(identityPassive -> identityPassive.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync4IdentityPassiveDto findPassiveForIdentity(List<Sync4IdentityPassiveDto> identityPassives, String identityName) {
        return identityPassives.stream()
                .filter(identityPassive -> identityPassive.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync3IdentitySkill1Dto findSync3Skill1ForIdentity(List<Sync3IdentitySkill1Dto> identitySkill1s, String identityName) {
        return identitySkill1s.stream()
                .filter(identitySkill1 -> identitySkill1.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync4IdentitySkill1Dto findSkill1ForIdentity(List<Sync4IdentitySkill1Dto> identitySkill1s, String identityName) {
        return identitySkill1s.stream()
                .filter(identitySkill1 -> identitySkill1.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync3IdentitySkill2Dto findSync3Skill2ForIdentity(List<Sync3IdentitySkill2Dto> identitySkill2s, String identityName) {
        return identitySkill2s.stream()
                .filter(identitySkill2 -> identitySkill2.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync4IdentitySkill2Dto findSkill2ForIdentity(List<Sync4IdentitySkill2Dto> identitySkill2s, String identityName) {
        return identitySkill2s.stream()
                .filter(identitySkill2 -> identitySkill2.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync3IdentitySkill3Dto findSync3Skill3ForIdentity(List<Sync3IdentitySkill3Dto> identitySkill3s, String identityName) {
        return identitySkill3s.stream()
                .filter(identitySkill3 -> identitySkill3.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync4IdentitySkill3Dto findSkill3ForIdentity(List<Sync4IdentitySkill3Dto> identitySkill3s, String identityName) {
        return identitySkill3s.stream()
                .filter(identitySkill3 -> identitySkill3.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync3IdentityDefSkillDto findSync3DefSkillForIdentity(List<Sync3IdentityDefSkillDto> identityDefSkills, String identityName) {
        return identityDefSkills.stream()
                .filter(identityDefSkill -> identityDefSkill.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private Sync4IdentityDefSkillDto findDefSkillForIdentity(List<Sync4IdentityDefSkillDto> identityDefSkills, String identityName) {
        return identityDefSkills.stream()
                .filter(identityDefSkill -> identityDefSkill.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }


}
