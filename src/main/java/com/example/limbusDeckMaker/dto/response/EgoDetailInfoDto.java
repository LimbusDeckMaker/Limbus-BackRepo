package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.Ego;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EgoDetailInfoDto {

    private Long id;
    private String character;
    private String name;
    private String image;
    private String zoomImage;
    private String grade;
    private Integer season;

    private List<String> resistance;
    private List<String> keyword;

    private Passive passive;

    private LocalDate releaseDate;
    private String obtainingMethod;

    private List<EgoSkillInfo> egoskills;
    private List<EgoSkillInfo> egoCorSkills;

    public static EgoDetailInfoDto toDto(Ego ego) {
        return EgoDetailInfoDto.builder()
            .id(ego.getId())
            .character(ego.getSinner().getName())
            .name(ego.getName())
            .image(ego.getImage())
            .zoomImage(ego.getZoomImage())
            .grade(ego.getGrade())
            .season(ego.getSeason())
            .resistance(ego.getResistance())
            .keyword(ego.getKeyword())
            .passive(new Passive(ego))
            .releaseDate(ego.getReleaseDate())
            .obtainingMethod(ego.getObtainingMethod())
            .egoskills(EgoSkillInfo.fromEgoSkills(ego.getEgoSkills()))
            .egoCorSkills(EgoSkillInfo.fromCorrosionSkills(ego.getEgoCorSkills()))
            .build();
    }

    @Getter
    static class Passive {

        private String name;
        private String content;

        public Passive(Ego ego) {
            this.name = ego.getPassive().getPassiveInfo().getPassiveName();
            this.content = ego.getPassive().getPassiveInfo().getPassive();
        }
    }
}