package com.example.limbusDeckMaker.dto.sync4;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.domain.IdentityDefSkill;
import com.example.limbusDeckMaker.imbeddable.identity.DefSkill;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link IdentityDefSkill}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sync4IdentityDefSkillDto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @JsonProperty("sync4")
    @Embedded
    DefSkill defSkill;

    Integer level = 4;

    Integer skillSeq = 4;

    Identity identity;
}