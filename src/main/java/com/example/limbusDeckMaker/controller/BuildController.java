package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.dto.response.EgoBuildInfoDto;
import com.example.limbusDeckMaker.dto.response.IdentityBuildInfoDto;
import com.example.limbusDeckMaker.exception.NoEgoFoundException;
import com.example.limbusDeckMaker.exception.NoIdentityFoundException;
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
                .orElseThrow(() -> new NoIdentityFoundException("빌드 시 인격 정보를 출력할 수 없습니다. 해당 ID를 가진 인격이 없습니다."));
    }

    @GetMapping("ego")
    public ResponseEntity<EgoBuildInfoDto> fetchEgosByIds(
            @RequestParam("id") List<Long> ids) {
        return egoService.getEgoBuildInfo(ids)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NoEgoFoundException("빌드 시 에고 필요 자원을 출력할 수 없습니다. 입력한 에고 ID 목록에 잘못된 값이 포함되어 있습니다."));
    }

}
