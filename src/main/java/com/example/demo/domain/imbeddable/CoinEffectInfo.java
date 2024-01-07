package com.example.demo.domain.imbeddable;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CoinEffectInfo {

    @JsonProperty("h1")
    private String coinEffect;
}
