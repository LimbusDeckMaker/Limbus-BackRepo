package com.example.limbusDeckMaker.dto.response;

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
    private List<String> types;
    private Integer minWeight;
    private Integer maxWeight;

    public static EgoListInfoDto toDto(Ego ego, EgoContext egoContext){
        return EgoListInfoDto.builder()
            .id(ego.getId())
            .character(ego.getSinner().getName())
            .name(ego.getName())
            .season(ego.getSeason())
            .image(ego.getImage())
            .zoomImage(ego.getZoomImage())
            .grade(ego.getGrade())
            .keyword(ego.getKeyword())
            .resources(egoContext.getResources())
            .types(egoContext.getTypes())
            .minWeight(egoContext.getMinWeight())
            .maxWeight(egoContext.getMaxWeight())
            .build();
    }

}
