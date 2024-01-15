package com.example.demo.dto.sync3;

import com.example.demo.domain.Identity;
import com.example.demo.domain.IdentityPassive;
import com.example.demo.imbeddable.identity.Passive;
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
public class Sync3IdentityPassiveDto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @Embedded
    @JsonProperty("sync3")
    Passive passive;

    Integer level = 3;

    Identity identity;

}