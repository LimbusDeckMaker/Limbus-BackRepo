package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySkill3Dto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySkill3Dto;
import com.example.limbusDeckMaker.imbeddable.identity.Skill3;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "identity_skill3")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class IdentitySkill3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityName;

    @JsonProperty("sync4")
    @Embedded
    private Skill3 skill3;

    private Integer level;

    // Identity - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentitySkill3 toEntity(Sync3IdentitySkill3Dto dto){
        return IdentitySkill3.builder()
                .identityName(dto.getIdentityName())
                .skill3(dto.getSkill3())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }

    public static IdentitySkill3 toEntity(Sync4IdentitySkill3Dto dto){
        return IdentitySkill3.builder()
                .identityName(dto.getIdentityName())
                .skill3(dto.getSkill3())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
