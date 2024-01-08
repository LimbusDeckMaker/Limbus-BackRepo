package com.example.demo.domain.ego.imbeddable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class Sync3Info {

    @JsonProperty("pass1")
    private PassiveInfo passiveInfo;

}
