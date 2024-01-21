package com.example.limbusDeckMaker.imbeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Data
public class CoinEffectInfo {

    @JsonProperty("start")
    private String normalEffect;

    @JsonProperty("h1")
    @Column(name = "coin1_effect")
    private String coin1_Effect;

    @JsonProperty("h2")
    @Column(name = "coin2_effect")
    private String coin2Effect;

    @JsonProperty("h3")
    @Column(name = "coin3_effect")
    private String coin3Effect;

    @JsonProperty("h4")
    @Column(name = "coin4_effect")
    private String coin4Effect;

    @JsonProperty("end")
    @Column(name = "coin5_effect")
    private String coin5Effect;



}
