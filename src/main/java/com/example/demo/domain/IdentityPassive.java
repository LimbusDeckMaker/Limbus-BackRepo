package com.example.demo.domain;

import com.example.demo.dto.sync3.Sync3IdentityPassiveDto;
import com.example.demo.dto.sync4.Sync4IdentityPassiveDto;
import com.example.demo.imbeddable.identity.Passive;
import jakarta.persistence.*;
import lombok.*;

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

    private Integer level;

    // Identity - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentityPassive toEntity(Sync3IdentityPassiveDto dto){
        return IdentityPassive.builder()
                .identityName(dto.getIdentityName())
                .passive(dto.getPassive())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }

    public static IdentityPassive toEntity(Sync4IdentityPassiveDto dto){
        return IdentityPassive.builder()
                .identityName(dto.getIdentityName())
                .passive(dto.getPassive())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
