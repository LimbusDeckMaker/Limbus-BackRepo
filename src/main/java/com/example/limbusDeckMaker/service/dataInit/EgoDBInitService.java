package com.example.limbusDeckMaker.service.dataInit;

import com.example.limbusDeckMaker.domain.*;
import com.example.limbusDeckMaker.dto.sync3.Sync3CorrosionSkillDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3EgoSkillDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4CorrosionSkillDto;
import com.example.limbusDeckMaker.dto.EgoDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4EgoSkillDto;
import com.example.limbusDeckMaker.repository.CorrosionSkillRepository;
import com.example.limbusDeckMaker.repository.EgoRepository;
import com.example.limbusDeckMaker.repository.EgoSkillRepository;
import com.example.limbusDeckMaker.repository.SinnerRepository;
import com.example.limbusDeckMaker.util.JsonParser;
import com.example.limbusDeckMaker.util.SinnerNameMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EgoDBInitService {

    private final SinnerRepository sinnerRepository;
    private final EgoRepository egoRepository;
    private final EgoSkillRepository egoSkillRepository;
    private final CorrosionSkillRepository corrosionSkillRepository;

    public EgoDBInitService(SinnerRepository sinnerRepository, EgoRepository egoRepository,
                            EgoSkillRepository egoSkillRepository, CorrosionSkillRepository corrosionSkillRepository) {
        this.sinnerRepository = sinnerRepository;
        this.egoRepository = egoRepository;
        this.egoSkillRepository = egoSkillRepository;
        this.corrosionSkillRepository = corrosionSkillRepository;
    }

    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        String sinnerName = SinnerNameMapping.extractSinnerFromFile(fileName);

        // JSON 파일에서 데이터 파싱
        List<EgoDto> egos = JsonParser.parseJsonForEgo(jsonFilePath);
        List<Sync3EgoSkillDto> sync3EgoSkills = JsonParser.parseJsonForSync3EgoSkill(jsonFilePath);
        List<Sync4EgoSkillDto> egoSkills = JsonParser.parseJsonForEgoSkill(jsonFilePath);
        List<Sync3CorrosionSkillDto> sync3CorSkills = JsonParser.parseJsonForEgoSync3CorSkill(jsonFilePath);
        List<Sync4CorrosionSkillDto> corSkills = JsonParser.parseJsonForEgoCorSkill(jsonFilePath);

        // 추출된 Sinner ID로 Sinner 찾기
        Optional<Sinner> sinnerOptional = sinnerRepository.findByName(sinnerName);

        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();

            for (EgoDto egoDto : egos) {

                egoDto.setSinner(sinner);
                Ego ego = Ego.toEntity(egoDto);
                egoRepository.save(ego);

                Sync3EgoSkillDto sync3EgoSkillDto = findEgoSync3SkillForEgo(sync3EgoSkills, ego.getName());
                sync3EgoSkillDto.setEgo(ego);
                EgoSkill sync3egoSkill = EgoSkill.toEntity(sync3EgoSkillDto);
                egoSkillRepository.save(sync3egoSkill);

                Sync4EgoSkillDto sync4EgoSkillDto = findEgoSkillForEgo(egoSkills, ego.getName());
                sync4EgoSkillDto.setEgo(ego);
                EgoSkill egoSkill = EgoSkill.toEntity(sync4EgoSkillDto);
                egoSkillRepository.save(egoSkill);

                Sync3CorrosionSkillDto sync3EgoCorSkillDto = findEgoSync3CorSkillForEgo(sync3CorSkills, ego.getName());
                sync3EgoCorSkillDto.setEgo(ego);
                CorrosionSkill sync3egoCorSkill = CorrosionSkill.toEntity(sync3EgoCorSkillDto);
                corrosionSkillRepository.save(sync3egoCorSkill);

                Sync4CorrosionSkillDto egoCorSkillDto = findEgoCorSkillForEgo(corSkills, ego.getName());
                egoCorSkillDto.setEgo(ego);
                CorrosionSkill egoCorSkill = CorrosionSkill.toEntity(egoCorSkillDto);
                corrosionSkillRepository.save(egoCorSkill);

            }
        }
    }
    private Sync3EgoSkillDto findEgoSync3SkillForEgo(List<Sync3EgoSkillDto> egoSkills, String egoName) {
        return egoSkills.stream()
                .filter(egoSkill -> egoSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);
    }


    private Sync4EgoSkillDto findEgoSkillForEgo(List<Sync4EgoSkillDto> egoSkills, String egoName) {
        return egoSkills.stream()
                .filter(egoSkill -> egoSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);
    }

    private Sync3CorrosionSkillDto findEgoSync3CorSkillForEgo(List<Sync3CorrosionSkillDto> egoCorSkills, String egoName) {
        return egoCorSkills.stream()
                .filter(corrosionSkill -> corrosionSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);

    }

    private Sync4CorrosionSkillDto findEgoCorSkillForEgo(List<Sync4CorrosionSkillDto> egoCorSkills, String egoName) {
        return egoCorSkills.stream()
                .filter(corrosionSkill -> corrosionSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);

    }
}
