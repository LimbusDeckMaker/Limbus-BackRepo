package com.example.demo.dto.sync3;

import com.example.demo.domain.Identity;
import com.example.demo.domain.IdentitySkill1;
import com.example.demo.imbeddable.identity.Skill1;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link IdentitySkill1}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sync3IdentitySkill1Dto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @JsonProperty("sync3")
    @Embedded
    Skill1 skill1;

    Integer level = 3;

    Identity identity;
}