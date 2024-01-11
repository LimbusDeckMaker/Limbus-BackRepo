package com.example.demo.Service;

import com.example.demo.domain.Sinner;
import com.example.demo.domain.Identity;
import com.example.demo.domain.IdentityPassive;
import com.example.demo.dto.IdentityDto;
import com.example.demo.dto.IdentityPassiveDto;
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

    public Sync4IdentityDBInitService(SinnerRepository sinnerRepository, IdentityRepository identityRepository, IdentityPassiveRepository identityPassiveRepository){
        this.sinnerRepository = sinnerRepository;
        this.identityRepository = identityRepository;
        this.identityPassiveRepository = identityPassiveRepository;
    }


    public void processAndSaveData(String jsonFilePath) throws IOException {
        String fileName = Paths.get(jsonFilePath).getFileName().toString();
        String sinnerName = SinnerNameMapping.extractSinnerFromFile(fileName);

        List<IdentityDto> identities = JsonParser.parseJsonForIdentity(jsonFilePath);
        List<IdentityPassiveDto> identityPassives = JsonParser.parseJsonForIdentityPassive(jsonFilePath);

        Optional<Sinner> sinnerOptional = sinnerRepository.findByName(sinnerName);


        if (sinnerOptional.isPresent()) {
            Sinner sinner = sinnerOptional.get();

            for (IdentityDto identityDto : identities) {
                identityDto.setSinner(sinner);
                Identity identity = Identity.toEntity(identityDto);
                identityRepository.save(identity);

                IdentityPassiveDto identityPassiveDto = findPassiveForIdentity(identityPassives, identity.getName());
                identityPassiveDto.setIdentity(identity);
                IdentityPassive identityPassive = IdentityPassive.toEntity(identityPassiveDto);
                identityPassiveRepository.save(identityPassive);

            }
        }
    }

    private IdentityPassiveDto findPassiveForIdentity(List<IdentityPassiveDto> identityPassives, String identityName) {
        return identityPassives.stream()
                .filter(identityPassive -> identityPassive.getIdentityName().equals(identityName))
                .findFirst()
                .orElse(null);
    }

}
