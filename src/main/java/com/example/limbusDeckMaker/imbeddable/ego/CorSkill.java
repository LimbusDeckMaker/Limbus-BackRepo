package com.example.limbusDeckMaker.imbeddable.ego;

import com.example.limbusDeckMaker.util.StringIntListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class CorSkill {

    @JsonProperty("skill2")
    private SkillInfo corrosionSkillInfo;

    @Convert(converter = StringIntListConverter.class)
    @JsonProperty("cost")
    private List<Integer> cost;
}
