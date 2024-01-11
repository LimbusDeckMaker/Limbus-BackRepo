package com.example.demo.domain;

import com.example.demo.dto.IdentitySkill3Dto;
import com.example.demo.imbeddable.identity.Skill3;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static IdentitySkill3 toEntity(IdentitySkill3Dto dto){
        return IdentitySkill3.builder()
                .identityName(dto.getIdentityName())
                .skill3(dto.getSkill3())
                .level(dto.getLevel())
                .identity(dto.getIdentity())
                .build();
    }
}
