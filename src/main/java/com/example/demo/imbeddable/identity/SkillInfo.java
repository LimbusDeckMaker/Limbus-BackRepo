package com.example.demo.imbeddable.identity;

import com.example.demo.imbeddable.CoinEffectInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
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

    @Transient
    @JsonProperty("skill")
    private String skillNumber;

    private Integer skillSeq;

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


    private Integer extractSkillSeqNumber(String skillNumber) {
        if (skillNumber == null || skillNumber.isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(skillNumber.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void setSkillNumber(String skillNumber) {
        this.skillNumber = skillNumber;
        this.skillSeq = extractSkillSeqNumber(skillNumber);
    }

}
