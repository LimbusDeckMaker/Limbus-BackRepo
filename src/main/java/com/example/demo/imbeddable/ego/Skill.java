package com.example.demo.imbeddable.ego;

import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class Skill {

    @JsonProperty("skill1")
    private SkillInfo skillInfo;

    @Convert(converter = StringListConverter.class)
    @JsonProperty("cost")
    private List<String> cost;
}
