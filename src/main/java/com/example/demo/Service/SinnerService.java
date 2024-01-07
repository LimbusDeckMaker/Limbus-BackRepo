package com.example.demo.Service;

import com.example.demo.domain.Ego;
import com.example.demo.domain.Sinner;
import com.example.demo.repository.EgoRepository;
import com.example.demo.repository.SinnerRepository;
import com.example.demo.util.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SinnerService {

    private final SinnerRepository sinnerRepository;
    private final EgoRepository egoRepository;

    public SinnerService(SinnerRepository sinnerRepository, EgoRepository egoRepository) {
        this.sinnerRepository = sinnerRepository;
        this.egoRepository = egoRepository;
    }

    @Transactional
    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        long sinnerId = extractSinnerIdFromFileName(fileName);

        // JSON 파일에서 데이터 파싱
        List<Ego> egos = JsonParser.parseJsonFile(jsonFilePath);

        // 추출된 Sinner ID로 Sinner 찾기
        Optional<Sinner> sinnerOptional = sinnerRepository.findById(sinnerId);
        log.info("Sinner ID ->{}", sinnerOptional);

        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();
            log.info("Sinner ->{}", sinner);
            for (Ego ego : egos) {
                ego.setSinner(sinner);
                egoRepository.save(ego);
            }
        }
    }

    private long extractSinnerIdFromFileName(String fileName) {
        // 파일 이름에서 숫자만 추출하는 로직 (예: "SinclairData_10.json" -> 10)
        String idStr = fileName.replaceAll("[^0-9]", "");
        return Long.parseLong(idStr);
    }
}
