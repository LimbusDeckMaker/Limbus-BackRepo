package com.example.demo.domain;

import com.example.demo.domain.imbeddable.identity.Passive;
import com.example.demo.dto.IdentityPassiveDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "identity_passive")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class IdentityPassive {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityName;

    @Embedded
    private Passive passive;

    // Identity - 다대일
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentityPassive toEntity(IdentityPassiveDto dto){
        return IdentityPassive.builder()
                .identityName(dto.getIdentityName())
                .passive(dto.getPassive())
                .identity(dto.getIdentity())
                .build();
    }
}
