package com.example.limbusDeckMaker.dto.sync4;

import com.example.limbusDeckMaker.domain.Identity;
import com.example.limbusDeckMaker.domain.IdentityPassive;
import com.example.limbusDeckMaker.imbeddable.identity.PassiveList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link IdentityPassive}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Sync4IdentityPassiveListDto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @Embedded
    @JsonProperty("sync4")
    PassiveList passiveList;

    Boolean isMain = true;

    Integer level = 4;

    Identity identity;

}