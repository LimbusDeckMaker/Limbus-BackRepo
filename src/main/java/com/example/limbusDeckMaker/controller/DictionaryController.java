package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.dto.response.EgoDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.EgoListInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityListInfoDto;
import com.example.limbusDeckMaker.exception.NoEgoFoundException;
import com.example.limbusDeckMaker.exception.NoIdentityFoundException;
import com.example.limbusDeckMaker.service.EgoService;
import com.example.limbusDeckMaker.service.IdentityService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final EgoService egoService;
    private final IdentityService identityService;

    public DictionaryController(EgoService egoService, IdentityService identityService) {
        this.egoService = egoService;
        this.identityService = identityService;
    }

    @GetMapping("/ego/{id}")
    public ResponseEntity<EgoDetailInfoDto> searchEgoById(@PathVariable("id") Long id) {
        return egoService.getSpecificEgo(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/identity/{id}")
    public ResponseEntity<IdentityDetailInfoDto> searchIdentityById(@PathVariable("id") Long id) {
        return identityService.getSpecificIdentity(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ego")
    public ResponseEntity<List<EgoListInfoDto>> searchEgosByCriteria(
        @RequestParam(value = "sinner", required = false) List<String> names,
        @RequestParam(value = "season", required = false) List<Integer> seasons,
        @RequestParam(value = "grade", required = false) List<String> grades,
        @RequestParam(value = "keyword", required = false) List<String> keywords,
        @RequestParam(value = "resources", required = false) List<String> resources,
        @RequestParam(value = "types", required = false) List<String> types,
        @RequestParam(value = "minWeight", required = false) Integer minWeight,
        @RequestParam(value = "maxWeight", required = false) Integer maxWeight) {

        List<EgoListInfoDto> results = egoService.getEgoByCriteria(names, seasons, grades, keywords,
            resources, types, minWeight, maxWeight);

        if (results.isEmpty()) {
            throw new NoEgoFoundException("해당하는 에고가 없습니다.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/identity")
    public ResponseEntity<List<IdentityListInfoDto>> searchIdentitiesByCriteria(
        @RequestParam(value = "sinner", required = false) List<String> names,
        @RequestParam(value = "season", required = false) List<Integer> seasons,
        @RequestParam(value = "grade", required = false) List<Integer> grades,
        @RequestParam(value = "affiliation", required = false) List<String> affiliations,
        @RequestParam(value = "keyword", required = false) List<String> keywords,
        @RequestParam(value = "resources", required = false) List<String> resources,
        @RequestParam(value = "types", required = false) List<String> types,
        @RequestParam(value = "minWeight", required = false) Integer minWeight,
        @RequestParam(value = "maxWeight", required = false) Integer maxWeight,
        @RequestParam(value = "minSpeed", required = false) Integer minSpeed,
        @RequestParam(value = "maxSpeed", required = false) Integer maxSpeed
    ) {

        List<IdentityListInfoDto> results = identityService.getIdentityByCriteria(names, seasons, grades,
            affiliations, keywords, resources, types, minWeight, maxWeight, minSpeed, maxSpeed);

        if (results.isEmpty()) {
            throw new NoIdentityFoundException("해당하는 인격이 없습니다.");
        }
        return ResponseEntity.ok(results);
    }

}