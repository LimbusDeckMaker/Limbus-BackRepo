package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySkill2Dto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySkill2Dto;
import com.example.limbusDeckMaker.imbeddable.identity.Skill2;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "identity_skill2")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class IdentitySkill2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityName;

    @Embedded
    private Skill2 skill2;

    private Integer level;

    // Identity - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentitySkill2 toEntity(Sync3IdentitySkill2Dto dto) {
        return IdentitySkill2.builder()
            .identityName(dto.getIdentityName())
            .skill2(dto.getSkill2())
            .level(dto.getLevel())
            .identity(dto.getIdentity())
            .build();
    }

    public static IdentitySkill2 toEntity(Sync4IdentitySkill2Dto dto) {
        return IdentitySkill2.builder()
            .identityName(dto.getIdentityName())
            .skill2(dto.getSkill2())
            .level(dto.getLevel())
            .identity(dto.getIdentity())
            .build();
    }
}
