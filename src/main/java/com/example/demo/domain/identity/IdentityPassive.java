package com.example.demo.domain.identity;

import com.example.demo.domain.identity.imbeddable.Passive;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "identity_passive")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class IdentityPassive {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String identityName;

    @JsonProperty("sync3")
    @Embedded
    private Passive passive;

    // Identity - 다대일
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

}
