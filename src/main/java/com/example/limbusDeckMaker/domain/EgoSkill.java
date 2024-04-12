package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.sync3.Sync3EgoSkillDto;
import com.example.limbusDeckMaker.imbeddable.ego.Skill;
import com.example.limbusDeckMaker.dto.sync4.Sync4EgoSkillDto;
import com.example.limbusDeckMaker.util.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ego_skill")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class EgoSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;

    @Embedded
    private Skill skill;

    // Ego와의 관계 - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ego_id")
    private Ego ego;

    private Integer construeLevel;

    public static EgoSkill toEntity(Sync3EgoSkillDto dto){
        return EgoSkill.builder()
                .name(dto.getName())
                .image(dto.getImage())
                .resistance(dto.getResistance())
                .skill(dto.getSkill())
                .construeLevel(dto.getConstrueLevel())
                .ego(dto.getEgo())
                .build();
    }

    public static EgoSkill toEntity(Sync4EgoSkillDto dto){
        return EgoSkill.builder()
                .name(dto.getName())
                .image(dto.getImage())
                .resistance(dto.getResistance())
                .skill(dto.getSkill())
                .construeLevel(dto.getConstrueLevel())
                .ego(dto.getEgo())
                .build();
    }


}