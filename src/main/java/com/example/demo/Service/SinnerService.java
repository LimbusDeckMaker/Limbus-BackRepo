package com.example.demo.Service;

import com.example.demo.domain.Ego.Ego;
import com.example.demo.domain.EgoSkill.EgoSkill;
import com.example.demo.domain.Sinner;
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

    public SinnerService(SinnerRepository sinnerRepository, EgoRepository egoRepository, EgoSkillRepository egoSkillRepository) {
        this.sinnerRepository = sinnerRepository;
        this.egoRepository = egoRepository;
        this.egoSkillRepository = egoSkillRepository;
    }

    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        long sinnerId = extractSinnerIdFromFileName(fileName);

        // JSON 파일에서 데이터 파싱
        List<Ego> egos = JsonParser.parseJsonForEgo(jsonFilePath);
        List<EgoSkill> egoSkills = JsonParser.parseJsonForEgoSkill(jsonFilePath);

        // 추출된 Sinner ID로 Sinner 찾기
        Optional<Sinner> sinnerOptional = sinnerRepository.findById(sinnerId);

        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();
            for (Ego ego : egos) {
                ego.setSinner(sinner);
                egoRepository.save(ego);

                EgoSkill egoSkill = findEgoSkillForEgo(egoSkills, ego.getName());
                if(egoSkill != null){
                    egoSkill.setEgo(ego);
                    egoSkillRepository.save(egoSkill);
                }
            }
        }
    }

    private EgoSkill findEgoSkillForEgo(List<EgoSkill> egoSkills, String egoName) {
        return egoSkills.stream()
                .filter(egoSkill -> egoSkill.getName().equals(egoName)) // Example condition
                .findFirst()
                .orElse(null);
    }

    private long extractSinnerIdFromFileName(String fileName) {
        // 파일 이름에서 숫자만 추출하는 로직 (예: "SinclairData_10.json" -> 10)
        String idStr = fileName.replaceAll("[^0-9]", "");
        return Long.parseLong(idStr);
    }
}
