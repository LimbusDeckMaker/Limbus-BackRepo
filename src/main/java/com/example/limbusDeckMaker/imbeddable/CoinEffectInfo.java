package com.example.limbusDeckMaker.imbeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Data
public class CoinEffectInfo {

    @JsonProperty("start")
    private String normalEffect;

    @JsonProperty("h1")
    private String coin1Effect;

    @JsonProperty("h2")
    private String coin2Effect;

    @JsonProperty("h3")
    private String coin3Effect;

    @JsonProperty("h4")
    private String coin4Effect;

    @JsonProperty("end")
    private String coin5Effect;



}
