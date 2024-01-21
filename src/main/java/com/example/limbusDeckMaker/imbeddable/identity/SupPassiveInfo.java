package com.example.limbusDeckMaker.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class SupPassiveInfo {

    @JsonProperty("name")
    private String subName;

    @JsonProperty("prop")
    private String subResource;

    @JsonProperty("poss")
    private Integer subResQuantity;

    @JsonProperty("posstype")
    private String subActiveCond;

    @JsonProperty("passdescription")
    private String subEffect;

}