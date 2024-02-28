package com.example.limbusDeckMaker.imbeddable.identity;

import com.example.limbusDeckMaker.imbeddable.CoinEffectInfo;
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

    private Integer skillSeq;

    private Integer quantity;

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

}
