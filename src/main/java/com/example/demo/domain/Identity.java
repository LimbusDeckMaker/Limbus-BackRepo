package com.example.demo.domain;

import com.example.demo.imbeddable.identity.Status;
import com.example.demo.dto.IdentityDto;
import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentityPassive identityPassive;

    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentitySkill1 identitySkill1;

    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentitySkill2 identitySkill2;

    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentitySkill3 identitySkill3;

    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentityDefSkill identityDefSkill;


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
