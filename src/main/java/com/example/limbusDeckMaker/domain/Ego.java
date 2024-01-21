package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.imbeddable.ego.Passive;
import com.example.limbusDeckMaker.dto.EgoDto;
import com.example.limbusDeckMaker.util.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ego")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Ego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private String grade;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;

    @Embedded
    private Passive passive;

    private LocalDate releaseDate;


    private String obtainingMethod;

    @Convert(converter = StringListConverter.class)
    private List<String> keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinner_id")
    private Sinner sinner;

    @OneToMany(mappedBy = "ego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EgoSkill> egoSkills;

    @OneToMany(mappedBy = "ego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CorrosionSkill> egoCorSkills;


    public static Ego toEntity(EgoDto dto) {
        return Ego.builder()
                .name(dto.getName())
                .image(dto.getImage())
                .grade(dto.getGrade())
                .resistance(dto.getResistance())
                .passive(dto.getPassive())
                .releaseDate(dto.getReleaseDate())
                .obtainingMethod(dto.getObtainingMethod())
                .keyword(dto.getKeyword())
                .sinner(dto.getSinner())
                .build();
    }


}
