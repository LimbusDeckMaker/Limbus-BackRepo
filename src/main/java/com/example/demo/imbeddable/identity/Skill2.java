package com.example.demo.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class Skill2 {

    @JsonProperty("skill2")
    private SkillInfo skill2Info;
}


