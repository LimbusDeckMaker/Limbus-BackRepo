package com.example.demo.Service;

import com.example.demo.domain.*;
import com.example.demo.dto.CorrosionSkillDto;
import com.example.demo.dto.EgoDto;
import com.example.demo.dto.EgoSkillDto;
import com.example.demo.repository.CorrosionSkillRepository;
import com.example.demo.repository.EgoRepository;
import com.example.demo.repository.EgoSkillRepository;
import com.example.demo.repository.SinnerRepository;
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
@Transactional
public class Sync4EgoDBInitService {

    private final SinnerRepository sinnerRepository;
    private final EgoRepository egoRepository;
    private final EgoSkillRepository egoSkillRepository;
    private final CorrosionSkillRepository corrosionSkillRepository;

    public Sync4EgoDBInitService(SinnerRepository sinnerRepository, EgoRepository egoRepository,
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
        List<EgoSkillDto> egoSkills = JsonParser.parseJsonForEgoSkill(jsonFilePath);
        List<CorrosionSkillDto> corSkills = JsonParser.parseJsonForEgoCorrosionSkill(jsonFilePath);

        // 추출된 Sinner ID로 Sinner 찾기
        Optional<Sinner> sinnerOptional = sinnerRepository.findByName(sinnerName);

        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();

            for (EgoDto egoDto : egos) {

                egoDto.setSinner(sinner);
                Ego ego = Ego.toEntity(egoDto);
                egoRepository.save(ego);


                EgoSkillDto egoSkillDto = findEgoSkillForEgo(egoSkills, ego.getName());
                egoSkillDto.setConstrueLevel(4);
                egoSkillDto.setEgo(ego);
                EgoSkill egoSkill = EgoSkill.toEntity(egoSkillDto);
                egoSkillRepository.save(egoSkill);

                CorrosionSkillDto egoCorSkillDto = findEgoCorSkillForEgo(corSkills, ego.getName());
                egoCorSkillDto.setConstrueLevel(4);
                egoCorSkillDto.setEgo(ego);
                CorrosionSkill egoCorSkill = CorrosionSkill.toEntity(egoCorSkillDto);
                corrosionSkillRepository.save(egoCorSkill);

            }
        }
    }

    private EgoSkillDto findEgoSkillForEgo(List<EgoSkillDto> egoSkills, String egoName) {
        return egoSkills.stream()
                .filter(egoSkill -> egoSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);
    }

    private CorrosionSkillDto findEgoCorSkillForEgo(List<CorrosionSkillDto> egoCorSkills, String egoName) {
        return egoCorSkills.stream()
                .filter(corrosionSkill -> corrosionSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);

    }
}
