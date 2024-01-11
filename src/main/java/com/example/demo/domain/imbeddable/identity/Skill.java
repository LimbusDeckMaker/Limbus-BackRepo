package com.example.demo.domain.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class Skill {

    @JsonProperty("skill1")
    private SkillInfo skill1Info;

    @JsonProperty("skill2")
    private Skill2Info skill2Info;

    @JsonProperty("skill3")
    private Skill3Info skill3Info;

    @JsonProperty("def")
    private DefSkillInfo defSkillInfo;

}


