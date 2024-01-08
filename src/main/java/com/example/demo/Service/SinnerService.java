package com.example.demo.Service;

import com.example.demo.domain.corrosionSkill.CorrosionSkill;
import com.example.demo.domain.ego.Ego;
import com.example.demo.domain.egoSkill.EgoSkill;
import com.example.demo.domain.Sinner;
import com.example.demo.repository.CorrosionSkillRepository;
import com.example.demo.repository.EgoRepository;
import com.example.demo.repository.EgoSkillRepository;
import com.example.demo.repository.SinnerRepository;
import com.example.demo.util.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SinnerService {

    private final SinnerRepository sinnerRepository;
    private final EgoRepository egoRepository;
    private final EgoSkillRepository egoSkillRepository;
    private final CorrosionSkillRepository corrosionSkillRepository;

    public SinnerService(SinnerRepository sinnerRepository, EgoRepository egoRepository,
                         EgoSkillRepository egoSkillRepository, CorrosionSkillRepository corrosionSkillRepository) {
        this.sinnerRepository = sinnerRepository;
        this.egoRepository = egoRepository;
        this.egoSkillRepository = egoSkillRepository;
        this.corrosionSkillRepository = corrosionSkillRepository;
    }

    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        long sinnerId = extractSinnerIdFromFileName(fileName);

        // JSON 파일에서 데이터 파싱
        List<Ego> egos = JsonParser.parseJsonForEgo(jsonFilePath);
        List<EgoSkill> egoSkills = JsonParser.parseJsonForEgoSkill(jsonFilePath);
        List<CorrosionSkill> corSkills = JsonParser.parseJsonForEgoCorrosionSkill(jsonFilePath);
        for (CorrosionSkill corrosionSkill : corSkills) {
            log.info("CorSkill info ->{}", corrosionSkill.getSync3Info());
        }

        // 추출된 Sinner ID로 Sinner 찾기
        Optional<Sinner> sinnerOptional = sinnerRepository.findById(sinnerId);

        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();
            for (Ego ego : egos) {
                ego.setSinner(sinner);
                egoRepository.save(ego);

                EgoSkill egoSkill = findEgoSkillForEgo(egoSkills, ego.getName());
                CorrosionSkill egoCorSkill = findEgoCorSkillForEgo(corSkills, ego.getName());

                if(egoSkill != null){
                    egoSkill.setEgo(ego);
                    egoSkillRepository.save(egoSkill);
                }

                if (egoCorSkill != null) {
                    egoCorSkill.setEgo(ego);
                    corrosionSkillRepository.save(egoCorSkill);
                }
            }
        }
    }

    private EgoSkill findEgoSkillForEgo(List<EgoSkill> egoSkills, String egoName) {
        return egoSkills.stream()
                .filter(egoSkill -> egoSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);
    }

    private CorrosionSkill findEgoCorSkillForEgo(List<CorrosionSkill> egoCorSkills, String egoName) {
        return egoCorSkills.stream()
                .filter(corrosionSkill -> corrosionSkill.getName().equals(egoName))
                .findFirst()
                .orElse(null);
    }


    private long extractSinnerIdFromFileName(String fileName) {
        // 파일 이름에서 숫자만 추출하는 로직 (예: "SinclairData_10.json" -> 10)
        String idStr = fileName.replaceAll("[^0-9]", "");
        return Long.parseLong(idStr);
    }
}
