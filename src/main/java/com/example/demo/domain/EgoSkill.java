package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "ego_skill")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class EgoSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ego_name")
    private String name;

    private String image;


    private String power;
    private Integer mentalConsume;
    private Integer cost;
    private String resistance;
    private String atkType;
    private String resource;
    private Integer skillPower;
    private Integer coinPower;
    private Integer atkWeight;
    private String coinEffect;
    private Byte construeLevel;

    // Ego와의 관계 - 다대일
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ego_id")
    private Ego ego;

}