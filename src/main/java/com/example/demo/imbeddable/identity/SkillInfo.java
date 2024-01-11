package com.example.demo.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class SkillInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private String power;

    @JsonProperty("skilltype")
    private String type;

    @JsonProperty("prop")
    private String resource;

    @JsonProperty("skill")
    private String skillSeq;

    private String quantity;

    @JsonProperty("power")
    private Integer skillPower;

    @JsonProperty("coinpower")
    private Integer coinPower;

    @JsonProperty("coin")
    private Integer coinNum;

    @JsonProperty("weight")
    private Integer atkWeight;

    @JsonProperty("hit")
    private CoinEffectInfo coinEffect;

}
