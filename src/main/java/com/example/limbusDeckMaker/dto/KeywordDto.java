package com.example.limbusDeckMaker.dto;

import com.example.limbusDeckMaker.domain.Keyword;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link Keyword}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeywordDto implements Serializable {

    @JsonProperty("name")
    String name;

    @JsonProperty("content")
    String content;
}