package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.imbeddable.identity.Status;
import jakarta.persistence.Embedded;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IdentityDetailInfoDto {

    private Long id;
    private String character;
    private String name;
    private String beforeImage;
    private String beforeZoomImage;
    private String afterImage;
    private String afterZoomImage;
    private String afterProfileImage;
    private String affiliation;
    private Integer grade;
    private Integer season;
    private LocalDate releaseDate;
    private String obtainingMethod;

    private List<String> resistance;
    private List<String> keyword;

    @Embedded
    private Status status;

    private List<IdentitySkillInfo> identitySkill1s;
    private List<IdentitySkillInfo> identitySkill2s;
    private List<IdentitySkillInfo> identitySkill3s;
    private List<IdentitySkillInfo> identityDefSkills;
    private List<IdentityPassiveInfo> identityPassives;


    public static IdentityDetailInfoDto toDto(Identity identity) {
        return IdentityDetailInfoDto.builder()
            .id(identity.getId())
            .character(identity.getSinner().getName())
            .name(identity.getName())
            .beforeImage(identity.getBeforeImage())
            .beforeZoomImage(identity.getBeforeZoomImage())
            .afterImage(identity.getAfterImage())
            .afterZoomImage(identity.getAfterZoomImage())
            .afterProfileImage(identity.getAfterProfileImage())
            .affiliation(identity.getAffiliation())
            .grade(identity.getGrade())
            .season(identity.getSeason())
            .releaseDate(identity.getReleaseDate())
            .obtainingMethod(identity.getObtainingMethod())
            .resistance(identity.getResistance())
            .keyword(identity.getKeyword())
            .status(identity.getStatus())
            .identitySkill1s(IdentitySkillInfo.fromSkill1(identity.getIdentitySkill1()))
            .identitySkill2s(IdentitySkillInfo.fromSkill2(identity.getIdentitySkill2()))
            .identitySkill3s(IdentitySkillInfo.fromSkill3(identity.getIdentitySkill3()))
            .identityDefSkills(IdentitySkillInfo.fromDefSkill(identity.getIdentityDefSkill()))
            .identityPassives(IdentityPassiveInfo.fromPassives(identity.getIdentityPassive()))
            .build();
    }

}
