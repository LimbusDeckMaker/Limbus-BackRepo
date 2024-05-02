package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.dto.response.EgoBuildInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityBuildInfoDto;
import com.example.limbusDeckMaker.service.EgoService;
import com.example.limbusDeckMaker.service.IdentityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/build")
public class BuildController {

    private final EgoService egoService;
    private final IdentityService identityService;


    public BuildController(EgoService egoService, IdentityService identityService) {
        this.egoService = egoService;
        this.identityService = identityService;
    }

    @GetMapping("/identity/{id}")
    public ResponseEntity<IdentityBuildInfoDto> getBuildIdentityInfo(@PathVariable("id") Long id){
        return identityService.getIdentityBuildInfo(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("ego")
    public ResponseEntity<EgoBuildInfoDto> fetchEgosByIds(
            @RequestParam("id") List<Long> ids) {
        return egoService.getEgoBuildInfo(ids)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
