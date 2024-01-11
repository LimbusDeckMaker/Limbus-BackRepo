package com.example.demo.dto;

import com.example.demo.domain.Ego;
import com.example.demo.domain.Sinner;
import com.example.demo.domain.imbeddable.ego.Passive;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Ego}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EgoDto implements Serializable {

    @JsonProperty("name")
    String name;

    String image;

    List<String> resistance;

    @JsonProperty("egorank")
    String grade;

    @JsonProperty("sync4")
    @Embedded
    Passive passive;

    @JsonProperty("birth")
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate releaseDate;

    @JsonProperty("get")
    String obtainingMethod;

    @JsonProperty("keyword")
    List<String> keyword;

    Sinner sinner;

}