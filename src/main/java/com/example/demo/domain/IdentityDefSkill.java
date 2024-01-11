package com.example.demo.domain;

import com.example.demo.dto.IdentityDefSkillDto;
import com.example.demo.imbeddable.identity.DefSkill;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentityDefSkill toEntity(IdentityDefSkillDto dto){
        return IdentityDefSkill.builder()
                .identityName(dto.getIdentityName())
                .defSkill(dto.getDefSkill())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
