package com.example.limbusDeckMaker.dto.sync3;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.domain.IdentityPassive;
import com.example.limbusDeckMaker.imbeddable.identity.PassiveList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link IdentityPassive}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Sync3IdentityPassiveListDto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @Embedded
    @JsonProperty("sync3")
    PassiveList passiveList;

    Boolean isMain = true;

    Integer level = 3;

    Identity identity;

}