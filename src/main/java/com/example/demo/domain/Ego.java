package com.example.demo.domain;

import com.example.demo.domain.imbeddable.Sync3Info;
import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "ego")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Ego {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ego_name")
    private String name;

    private String image;

    private Byte grade;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;

    @JsonProperty("sync3")
    @Embedded
    private Sync3Info sync3Info;

    @JsonProperty("birth")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate releaseDate;

    @JsonProperty("get")
    private String obtainingMethod;

    // Sinner와의 관계 - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinner_id")
    private Sinner sinner;

    // EgoSkill과의 관계 - 일대다
    @OneToOne(mappedBy = "ego", cascade = CascadeType.ALL, orphanRemoval = true)
    private EgoSkill egoSkill;

}
