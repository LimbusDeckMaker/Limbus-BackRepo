package com.example.demo.domain.Ego.imbeddable;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PassiveInfo {

    @JsonProperty("passdescription")
    private String passive;

    @JsonProperty("passive_name")
    private String passiveName;

}
