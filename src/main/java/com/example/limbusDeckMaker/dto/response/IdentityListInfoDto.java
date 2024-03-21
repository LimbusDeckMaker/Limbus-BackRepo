package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.Identity;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IdentityListInfoDto {

    private Long id;
    private String name;
    private String character;
    private Integer season;
    private Integer grade;
    private String affiliation;
    private String beforeImage;
    private String afterImage;

    private List<String> keyword;
    private List<String> resources;
    private List<String> types;

    private Integer minSpeed;
    private Integer maxSpeed;
    private Integer minWeight;
    private Integer maxWeight;

    public static IdentityListInfoDto toDto(Identity identity, IdentityContext context) {
        return IdentityListInfoDto.builder()
            .id(identity.getId())
            .character(identity.getSinner().getName())
            .name(identity.getName())
            .season(identity.getSeason())
            .grade(identity.getGrade())
            .affiliation(identity.getAffiliation())
            .beforeImage(identity.getBeforeImage())
            .afterImage(identity.getAfterImage())
            .keyword(identity.getKeyword())
            .resources(context.getResources())
            .types(context.getTypes())
            .minSpeed(context.getMinSpeed())
            .maxSpeed(context.getMaxSpeed())
            .minWeight(context.getMinWeight())
            .maxWeight(context.getMaxWeight())
            .build();
    }

}
