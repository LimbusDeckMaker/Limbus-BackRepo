package com.example.limbusDeckMaker.imbeddable.ego;

import com.example.limbusDeckMaker.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class CorSkill {

    @JsonProperty("skill2")
    private SkillInfo corrosionSkillInfo;

    @Convert(converter = StringListConverter.class)
    @JsonProperty("cost")
    private List<String> cost;
}