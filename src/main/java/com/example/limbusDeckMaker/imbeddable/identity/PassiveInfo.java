package com.example.limbusDeckMaker.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class PassiveInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("prop")
    private String resource;

    @JsonProperty("poss")
    private Integer resQuantity;

    @JsonProperty("posstype")
    private String activeCond;

    @JsonProperty("passdescription")
    private String effect;

}
