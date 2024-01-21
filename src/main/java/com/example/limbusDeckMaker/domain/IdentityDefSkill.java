package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.sync3.Sync3IdentityDefSkillDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentityDefSkillDto;
import com.example.limbusDeckMaker.imbeddable.identity.DefSkill;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "identity_def_skill")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class IdentityDefSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityName;


    @Embedded
    private DefSkill defSkill;

    private Integer level;

    // Identity - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentityDefSkill toEntity(Sync3IdentityDefSkillDto dto){
        return IdentityDefSkill.builder()
                .identityName(dto.getIdentityName())
                .defSkill(dto.getDefSkill())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }

    public static IdentityDefSkill toEntity(Sync4IdentityDefSkillDto dto){
        return IdentityDefSkill.builder()
                .identityName(dto.getIdentityName())
                .defSkill(dto.getDefSkill())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
