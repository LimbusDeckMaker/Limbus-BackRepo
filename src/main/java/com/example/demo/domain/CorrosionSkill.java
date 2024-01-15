package com.example.demo.domain;

import com.example.demo.dto.sync4.Sync4CorrosionSkillDto;
import com.example.demo.dto.sync3.Sync3CorrosionSkillDto;
import com.example.demo.imbeddable.ego.CorSkill;
import com.example.demo.util.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "corrosion_skill")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Builder
public class CorrosionSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;


    private CorSkill corSkill;

    private Integer construeLevel;

    // Ego와의 관계 - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ego_id")
    private Ego ego;

    public static CorrosionSkill toEntity(Sync3CorrosionSkillDto dto){
        return CorrosionSkill.builder()
                .name(dto.getName())
                .image(dto.getImage())
                .resistance(dto.getResistance())
                .corSkill(dto.getCorSkill())
                .construeLevel(dto.getConstrueLevel())
                .ego(dto.getEgo())
                .build();
    }

    public static CorrosionSkill toEntity(Sync4CorrosionSkillDto dto){
        return CorrosionSkill.builder()
                .name(dto.getName())
                .image(dto.getImage())
                .resistance(dto.getResistance())
                .corSkill(dto.getCorSkill())
                .construeLevel(dto.getConstrueLevel())
                .ego(dto.getEgo())
                .build();
    }

}