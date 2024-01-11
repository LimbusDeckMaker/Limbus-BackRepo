package com.example.demo.domain;
import com.example.demo.domain.imbeddable.corrosionSkill.Skill;
import com.example.demo.dto.CorrosionSkillDto;
import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    @JsonProperty("name")
    private String name;

    private String image;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;


    private Skill skill;

    private Integer construeLevel;

    // Ego와의 관계 - 다대일
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ego_id")
    private Ego ego;

    public static CorrosionSkill toEntity(CorrosionSkillDto dto){
        return CorrosionSkill.builder()
                .name(dto.getName())
                .image(dto.getImage())
                .resistance(dto.getResistance())
                .skill(dto.getSkill())
                .construeLevel(dto.getConstrueLevel())
                .ego(dto.getEgo())
                .build();
    }
}