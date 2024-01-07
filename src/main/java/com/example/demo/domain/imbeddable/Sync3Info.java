package com.example.demo.domain.imbeddable;

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
public class Sync3Info {

    @JsonProperty("pass1")
    private PassiveInfo passiveInfo;

    @JsonProperty("skill1")
    private SkillInfo skillInfo;
}
