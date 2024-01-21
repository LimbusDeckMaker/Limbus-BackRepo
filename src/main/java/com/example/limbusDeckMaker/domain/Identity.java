package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.IdentityDto;
import com.example.limbusDeckMaker.imbeddable.identity.Status;
import com.example.limbusDeckMaker.util.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "identity")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String beforeImage;

    private String afterImage;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;

    @Embedded
    private Status status;

    private String affiliation;

    private Integer grade;

    private LocalDate releaseDate;

    private String obtainingMethod;

    @Convert(converter = StringListConverter.class)
    private List<String> keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinner_id")
    private Sinner sinner;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentityPassive> identityPassive;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentitySkill1> identitySkill1;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentitySkill2> identitySkill;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentitySkill3> identitySkill3;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentityDefSkill> identityDefSkill;


    public static Identity toEntity(IdentityDto dto) {
        return Identity.builder()
                .name(dto.getName())
                .beforeImage(dto.getBeforeImage())
                .afterImage(dto.getAfterImage())
                .resistance(dto.getResistance())
                .status(dto.getStatus())
                .affiliation(dto.getAffiliation())
                .grade(dto.getGrade())
                .releaseDate(dto.getReleaseDate())
                .obtainingMethod(dto.getObtainingMethod())
                .keyword(dto.getKeyword())
                .sinner(dto.getSinner())
                .build();
    }
}
