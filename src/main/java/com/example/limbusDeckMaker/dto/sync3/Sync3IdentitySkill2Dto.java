package com.example.limbusDeckMaker.dto.sync3;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.domain.IdentitySkill2;
import com.example.limbusDeckMaker.imbeddable.identity.Skill2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link IdentitySkill2}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sync3IdentitySkill2Dto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @JsonProperty("sync3")
    @Embedded
    Skill2 skill2;

    Integer level = 3;

    Integer skillSeq = 2;

    Integer quantity = 2;

    Identity identity;
}