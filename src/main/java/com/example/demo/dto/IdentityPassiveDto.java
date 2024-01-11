package com.example.demo.dto;

import com.example.demo.domain.Identity;
import com.example.demo.domain.IdentityPassive;
import com.example.demo.domain.imbeddable.identity.Passive;
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
public class IdentityPassiveDto implements Serializable {

    @JsonProperty("name")
    String identityName;

    @Embedded
    @JsonProperty("sync4")
    Passive passive;

    Identity identity;


}