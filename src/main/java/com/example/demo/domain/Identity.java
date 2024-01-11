package com.example.demo.domain;

import com.example.demo.domain.imbeddable.identity.Status;
import com.example.demo.dto.IdentityDto;
import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    private String image;

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



    public static Identity toEntity(IdentityDto dto) {
        return Identity.builder()
                .name(dto.getName())
                .image(dto.getImage())
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
