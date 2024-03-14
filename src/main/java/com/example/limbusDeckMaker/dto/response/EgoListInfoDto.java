package com.example.limbusDeckMaker.dto.response;

import static com.example.limbusDeckMaker.service.mapper.EgoListInfoMapper.findUseResources;
import static com.example.limbusDeckMaker.service.mapper.EgoListInfoMapper.findCorType;
import static com.example.limbusDeckMaker.service.mapper.EgoListInfoMapper.findMaxWeight;
import static com.example.limbusDeckMaker.service.mapper.EgoListInfoMapper.findMinWeight;
import static com.example.limbusDeckMaker.service.mapper.EgoListInfoMapper.findSkillType;

import com.example.limbusDeckMaker.domain.Ego;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EgoListInfoDto {

    private Long id;
    private String name;
    private String character;
    private Integer season;
    private String grade;
    private String image;
    private String zoomImage;

    private List<String> keyword;

    private List<String> resources;
    private String skillType;
    private String corType;
    private Integer minWeight;
    private Integer maxWeight;

    public static EgoListInfoDto toDto(Ego ego){
        return EgoListInfoDto.builder()
            .id(ego.getId())
            .character(ego.getSinner().getName())
            .name(ego.getName())
            .season(ego.getSeason())
            .image(ego.getImage())
            .zoomImage(ego.getZoomImage())
            .grade(ego.getGrade())
            .keyword(ego.getKeyword())
            .resources(findUseResources(ego))
            .skillType(findSkillType(ego))
            .corType(findCorType(ego))
            .minWeight(findMinWeight(ego))
            .maxWeight(findMaxWeight(ego))
            .build();
    }

}
