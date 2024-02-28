package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.domain.Ego;
import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.dto.response.EgoInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityInfoDto;
import com.example.limbusDeckMaker.repository.EgoRepository;
import com.example.limbusDeckMaker.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final EgoRepository egoRepository;
    private final IdentityRepository identityRepository;

    @Autowired
    public DictionaryController(EgoRepository egoRepository, IdentityRepository identityRepository) {
        this.egoRepository = egoRepository;
        this.identityRepository = identityRepository;
    }

    @GetMapping("/ego/{id}")
    public ResponseEntity<EgoInfoDto> getSpecificEgo(@PathVariable("id") Long id){
        Optional<Ego> optionalEgo = egoRepository.findById(id);
        if (optionalEgo.isPresent()) {
            Ego ego = optionalEgo.get();
            EgoInfoDto egoInfoDto = EgoInfoDto.toDto(ego);
            return ResponseEntity.ok(egoInfoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/identity/{id}")
    public ResponseEntity<IdentityInfoDto> getSpecificIdentity(@PathVariable("id") Long id){
        Optional<Identity> optionalIdentity = identityRepository.findById(id);
        if (optionalIdentity.isPresent()){
            Identity identity = optionalIdentity.get();
            IdentityInfoDto identityInfoDto = IdentityInfoDto.toDto(identity);
            return ResponseEntity.ok(identityInfoDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}