package com.example.limbusDeckMaker.imbeddable.ego;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PassiveInfo {

    @JsonProperty("passdescription")
    private String passive;

    @JsonProperty("name")
    private String passiveName;

}
