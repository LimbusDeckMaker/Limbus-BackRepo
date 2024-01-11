package com.example.demo.imbeddable.egoSkill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Data
public class CoinEffectInfo {

    @JsonProperty("start")
    private String coinDefEffect;

    @JsonProperty("h1")
    private String coinHitEffect;

}
