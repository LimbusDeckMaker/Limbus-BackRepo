package com.example.demo.domain;

import com.example.demo.dto.IdentitySkill2Dto;
import com.example.demo.imbeddable.identity.Skill2;
import jakarta.persistence.*;
import lombok.*;



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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentitySkill2 toEntity(IdentitySkill2Dto dto){
        return IdentitySkill2.builder()
                .identityName(dto.getIdentityName())
                .skill2(dto.getSkill2())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
