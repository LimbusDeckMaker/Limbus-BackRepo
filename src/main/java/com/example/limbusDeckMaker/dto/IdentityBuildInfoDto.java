package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.Identity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.example.limbusDeckMaker.service.mapper.IdentityBuildInfoMapper.countIdentityResources;
import static com.example.limbusDeckMaker.service.mapper.IdentityBuildInfoMapper.countIdentityTypes;

@Getter
@Setter
@Builder
public class IdentityBuildInfoDto {

    private String character;
    private List<Integer> resourceNum;
    private List<Integer> typeNum;

    public static IdentityBuildInfoDto toDto(Identity identity){
        return IdentityBuildInfoDto.builder()
                .character(identity.getSinner().getName())
                .resourceNum(countIdentityResources(identity))
                .typeNum(countIdentityTypes(identity))
                .build();
    }

}
