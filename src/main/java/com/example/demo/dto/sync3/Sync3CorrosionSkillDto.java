package com.example.demo.dto.sync3;

import com.example.demo.domain.CorrosionSkill;
import com.example.demo.domain.Ego;
import com.example.demo.imbeddable.ego.CorSkill;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link CorrosionSkill}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sync3CorrosionSkillDto implements Serializable {

    @JsonProperty("name")
    String name;

    String image;

    @JsonProperty("resistance")
    List<String> resistance;

    @Embedded
    @JsonProperty("sync3")
    CorSkill corSkill;

    Integer construeLevel = 3;

    Ego ego;
}