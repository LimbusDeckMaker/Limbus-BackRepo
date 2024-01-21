package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySkill1Dto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySkill1Dto;
import com.example.limbusDeckMaker.imbeddable.identity.Skill1;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "identity_skill1")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class IdentitySkill1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityName;

    @Embedded
    private Skill1 skill1;

    private Integer level;

    // Identity - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentitySkill1 toEntity(Sync3IdentitySkill1Dto dto){
        return IdentitySkill1.builder()
                .identityName(dto.getIdentityName())
                .skill1(dto.getSkill1())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }

    public static IdentitySkill1 toEntity(Sync4IdentitySkill1Dto dto){
        return IdentitySkill1.builder()
                .identityName(dto.getIdentityName())
                .skill1(dto.getSkill1())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}