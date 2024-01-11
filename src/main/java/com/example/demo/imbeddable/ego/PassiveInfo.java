package com.example.demo.imbeddable.ego;

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
