package com.example.demo.dto;

import com.example.demo.domain.Identity;
import com.example.demo.domain.Sinner;
import com.example.demo.imbeddable.identity.Status;
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
 * DTO for {@link Identity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IdentityDto implements Serializable {

    @JsonProperty("name")
    String name;

    String beforeImage;

    String afterImage;

    List<String> resistance;

    @Embedded
    @JsonProperty("sync4")
    Status status;

    @JsonProperty("position")
    String affiliation;

    @JsonProperty("rank")
    Integer grade;

    @JsonProperty("birth")
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate releaseDate;

    @JsonProperty("get")
    String obtainingMethod;

    @JsonProperty("keyword")
    List<String> keyword;

    Sinner sinner;
}