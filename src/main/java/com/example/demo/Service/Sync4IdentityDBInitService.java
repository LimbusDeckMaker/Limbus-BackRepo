package com.example.demo.Service;

import com.example.demo.domain.*;
import com.example.demo.dto.*;
import com.example.demo.repository.*;
import com.example.demo.util.JsonParser;
import com.example.demo.util.SinnerNameMapping;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class Sync4IdentityDBInitService {

    private final SinnerRepository sinnerRepository;
    private final IdentityRepository identityRepository;
    private final IdentityPassiveRepository identityPassiveRepository;
    private final IdentitySkill1Repository identitySkill1Repository;
    private final IdentitySkill2Repository identitySkill2Repository;
    private final IdentitySkill3Repository identitySkill3Repository;
    private final IdentityDefSkillRepository identityDefSkillRepository;

    public Sync4IdentityDBInitService(SinnerRepository sinnerRepository, IdentityRepository identityRepository,
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


    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        String sinnerName = SinnerNameMapping.extractSinnerFromFile(fileName);

        List<IdentityDto> identities = JsonParser.parseJsonForIdentity(jsonFilePath);
        List<IdentityPassiveDto> identityPassives = JsonParser.parseJsonForIdentityPassive(jsonFilePath);
        List<IdentitySkill1Dto> identitySkill1s = JsonParser.parseJsonForIdentitySkill1(jsonFilePath);
        List<IdentitySkill2Dto> identitySkill2s = JsonParser.parseJsonForIdentitySkill2(jsonFilePath);
        List<IdentitySkill3Dto> identitySkill3s = JsonParser.parseJsonForIdentitySkill3(jsonFilePath);
        List<IdentityDefSkillDto> identityDefSkills = JsonParser.parseJsonForIdentityDefSkill(jsonFilePath);




        Optional<Sinner> sinnerOptional = sinnerRepository.findByName(sinnerName);


        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();

            for (IdentityDto identityDto : identities) {
                identityDto.setSinner(sinner);
                Identity identity = Identity.toEntity(identityDto);
                identityRepository.save(identity);

                IdentityPassiveDto identityPassiveDto = findPassiveForIdentity(identityPassives, identity.getName());
                identityPassiveDto.setLevel(4);
                identityPassiveDto.setIdentity(identity);
                IdentityPassive identityPassive = IdentityPassive.toEntity(identityPassiveDto);
                identityPassiveRepository.save(identityPassive);

                IdentitySkill1Dto identitySkill1Dto = findSkill1ForIdentity(identitySkill1s, identity.getName());
                identitySkill1Dto.setLevel(4);
                identitySkill1Dto.setIdentity(identity);
                IdentitySkill1 identitySkill1 = IdentitySkill1.toEntity(identitySkill1Dto);
                identitySkill1Repository.save(identitySkill1);

                IdentitySkill2Dto identitySkill2Dto = findSkill2ForIdentity(identitySkill2s, identity.getName());
                identitySkill2Dto.setLevel(4);
                identitySkill2Dto.setIdentity(identity);
                IdentitySkill2 identitySkill2 = IdentitySkill2.toEntity(identitySkill2Dto);
                identitySkill2Repository.save(identitySkill2);

                IdentitySkill3Dto identitySkill3Dto = findSkill3ForIdentity(identitySkill3s, identity.getName());
                identitySkill3Dto.setLevel(4);
                identitySkill3Dto.setIdentity(identity);
                IdentitySkill3 identitySkill3 = IdentitySkill3.toEntity(identitySkill3Dto);
                identitySkill3Repository.save(identitySkill3);

                IdentityDefSkillDto identityDefSkillDto = findDefSkillForIdentity(identityDefSkills, identity.getName());
                identityDefSkillDto.setLevel(4);
                identityDefSkillDto.setIdentity(identity);
                IdentityDefSkill identityDefSkill = IdentityDefSkill.toEntity(identityDefSkillDto);
                identityDefSkillRepository.save(identityDefSkill);
            }
        }
    }

    private IdentityPassiveDto findPassiveForIdentity(List<IdentityPassiveDto> identityPassives, String identityName) {
        return identityPassives.stream()
                .filter(identityPassive -> identityPassive.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private IdentitySkill1Dto findSkill1ForIdentity(List<IdentitySkill1Dto> identitySkill1s, String identityName) {
        return identitySkill1s.stream()
                .filter(identitySkill1 -> identitySkill1.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private IdentitySkill2Dto findSkill2ForIdentity(List<IdentitySkill2Dto> identitySkill2s, String identityName) {
        return identitySkill2s.stream()
                .filter(identitySkill2 -> identitySkill2.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private IdentitySkill3Dto findSkill3ForIdentity(List<IdentitySkill3Dto> identitySkill3s, String identityName) {
        return identitySkill3s.stream()
                .filter(identitySkill3 -> identitySkill3.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private IdentityDefSkillDto findDefSkillForIdentity(List<IdentityDefSkillDto> identityDefSkills, String identityName) {
        return identityDefSkills.stream()
                .filter(identityDefSkill -> identityDefSkill.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }


}
