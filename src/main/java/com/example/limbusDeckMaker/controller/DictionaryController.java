package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.dto.response.EgoDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.EgoListInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityDetailInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityListInfoDto;
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
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "season", required = false) Integer season,
        @RequestParam(value = "grade", required = false) String grade,
        @RequestParam(value = "keyword", required = false) List<String> keywords,
        @RequestParam(value = "resources", required = false) List<String> resources,
        @RequestParam(value = "types", required = false) List<String> types,
        @RequestParam(value = "minWeight", required = false) Integer minWeight,
        @RequestParam(value = "maxWeight", required = false) Integer maxWeight) {

        List<EgoListInfoDto> results = egoService.getEgoByCriteria(id, season, grade, keywords, resources, types, minWeight, maxWeight);
        if(results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/identity")
    public ResponseEntity<List<IdentityListInfoDto>> searchIdentitiesByCriteria(
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "season", required = false) Integer season,
        @RequestParam(value = "grade", required = false) Integer grade
        ) {

        List<IdentityListInfoDto> results = identityService.getIdentityByCriteria(id, season, grade);
        if(results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }

}