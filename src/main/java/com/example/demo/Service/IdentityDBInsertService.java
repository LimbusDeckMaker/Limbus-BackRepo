package com.example.demo.Service;

import com.example.demo.domain.Sinner;
import com.example.demo.domain.identity.Identity;
import com.example.demo.domain.identity.IdentityPassive;
import com.example.demo.domain.identity.IdentitySupPassive;
import com.example.demo.repository.IdentityPassiveRepository;
import com.example.demo.repository.IdentityRepository;
import com.example.demo.repository.IdentitySupPassiveRepository;
import com.example.demo.repository.SinnerRepository;
import com.example.demo.util.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class IdentityDBInsertService {

    private final SinnerRepository sinnerRepository;
    private final IdentityRepository identityRepository;
    private final IdentityPassiveRepository identityPassiveRepository;
    private final IdentitySupPassiveRepository identitySupPassiveRepository;

    public IdentityDBInsertService(SinnerRepository sinnerRepository, IdentityRepository identityRepository,
                                   IdentityPassiveRepository identityPassiveRepository, IdentitySupPassiveRepository identitySupPassiveRepository){

        this.sinnerRepository = sinnerRepository;
        this.identityRepository = identityRepository;
        this.identityPassiveRepository = identityPassiveRepository;
        this.identitySupPassiveRepository = identitySupPassiveRepository;
    }


    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        long sinnerId = extractSinnerIdFromFileName(fileName);

        // JSON 파일에서 데이터 파싱
        List<Identity> identities = JsonParser.parseJsonForIdentity(jsonFilePath);
        List<IdentityPassive> identityPassives = JsonParser.parseJsonForIdentityPassive(jsonFilePath);
        List<IdentitySupPassive> identitySupPassives = JsonParser.parseJsonForIdentitySupPassive(jsonFilePath);

        // 추출된 Sinner ID로 Sinner 찾기
        Optional<Sinner> sinnerOptional = sinnerRepository.findById(sinnerId);

        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();

            for (Identity identity : identities) {
                identity.setSinner(sinner);
                identityRepository.save(identity);

                IdentityPassive identityPassive = findPassiveForIdentity(identityPassives, identity.getName());
                IdentitySupPassive identitySupPassive = findSupPassiveForIdentity(identitySupPassives, identity.getName());

                if (identityPassive != null) {
                    identityPassive.setIdentity(identity);
                    identityPassiveRepository.save(identityPassive);
                }

                if (identitySupPassive != null) {
                    identitySupPassive.setIdentity(identity);
                    identitySupPassiveRepository.save(identitySupPassive);
                }

            }
        }
    }

    private IdentityPassive findPassiveForIdentity(List<IdentityPassive> identityPassives, String identityName) {
        return identityPassives.stream()
                .filter(identityPassive -> identityPassive.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

    private IdentitySupPassive findSupPassiveForIdentity(List<IdentitySupPassive> identitySupPassives, String identityName) {
        return identitySupPassives.stream()
                .filter(identitySupPassive -> identitySupPassive.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }


    private long extractSinnerIdFromFileName(String fileName) {

        String idStr = fileName.replaceAll("[^0-9]", "");
        return Long.parseLong(idStr);
    }

}
