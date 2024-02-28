package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.IdentityDto;
import com.example.limbusDeckMaker.imbeddable.identity.Status;
import com.example.limbusDeckMaker.util.StringListConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private Integer season;

    private String beforeImage;

    private String beforeZoomImage;

    private String afterImage;

    private String afterZoomImage;

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
    private List<IdentitySkill2> identitySkill2;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentitySkill3> identitySkill3;

    @OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentityDefSkill> identityDefSkill;


    public static Identity toEntity(IdentityDto dto) {
        return Identity.builder()
            .name(dto.getName())
            .season(dto.getSeason())
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

    public void updateBeforeImage(String newImage) {
        this.beforeImage = newImage;
    }

    public void updateBeforeZoomImage(String newImage) {
        this.beforeZoomImage = newImage;
    }

    public void updateAfterImage(String newImage) {
        this.afterImage = newImage;
    }

    public void updateAfterZoomImage(String newImage) {
        this.afterZoomImage = newImage;
    }

}
