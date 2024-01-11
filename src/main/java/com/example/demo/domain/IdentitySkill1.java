package com.example.demo.domain;

import com.example.demo.dto.IdentitySkill1Dto;
import com.example.demo.imbeddable.identity.Skill1;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentitySkill1 toEntity(IdentitySkill1Dto dto){
        return IdentitySkill1.builder()
                .identityName(dto.getIdentityName())
                .skill1(dto.getSkill1())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
