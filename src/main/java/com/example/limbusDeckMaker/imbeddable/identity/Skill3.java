package com.example.limbusDeckMaker.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class Skill3 {

    @JsonProperty("skill3")
    private SkillInfo skill3Info;
}


