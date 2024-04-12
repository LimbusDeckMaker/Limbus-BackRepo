package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.sync3.Sync3IdentityPassiveListDto;
import com.example.limbusDeckMaker.dto.sync3.Sync3IdentitySupPassiveListDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentityPassiveListDto;
import com.example.limbusDeckMaker.dto.sync4.Sync4IdentitySupPassiveListDto;
import com.example.limbusDeckMaker.imbeddable.identity.Passive;
import com.example.limbusDeckMaker.imbeddable.identity.PassiveInfo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    private Boolean isMain;

    private Integer level;

    // Identity - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_id")
    private Identity identity;

    public static List<IdentityPassive> toEntity(Sync3IdentityPassiveListDto dto){
        List<PassiveInfo> passiveInfoList = dto.getPassiveList().getPassiveInfo();
        List<IdentityPassive> identityPassiveList = new ArrayList<>();
        for (PassiveInfo passiveInfo : passiveInfoList) {
            IdentityPassive identityPassive = IdentityPassive.builder()
                    .identityName(dto.getIdentityName())
                    .passive(new Passive(passiveInfo))
                    .level(dto.getLevel())
                    .isMain(dto.getIsMain())
                    .identity(dto.getIdentity())
                    .build();
            identityPassiveList.add(identityPassive);
        }
        return identityPassiveList;
    }

    public static List<IdentityPassive> toEntity(Sync4IdentityPassiveListDto dto){
        List<PassiveInfo> passiveInfoList = dto.getPassiveList().getPassiveInfo();
        List<IdentityPassive> identityPassiveList = new ArrayList<>();
        for (PassiveInfo passiveInfo : passiveInfoList) {
            IdentityPassive identityPassive = IdentityPassive.builder()
                    .identityName(dto.getIdentityName())
                    .passive(new Passive(passiveInfo))
                    .level(dto.getLevel())
                    .isMain(dto.getIsMain())
                    .identity(dto.getIdentity())
                    .build();
            identityPassiveList.add(identityPassive);
        }
        return identityPassiveList;
    }

    public static List<IdentityPassive> toEntity(Sync3IdentitySupPassiveListDto dto){
        List<PassiveInfo> passiveInfoList = dto.getPassiveList().getPassiveInfo();
        List<IdentityPassive> identityPassiveList = new ArrayList<>();
        for (PassiveInfo passiveInfo : passiveInfoList) {
            IdentityPassive identityPassive = IdentityPassive.builder()
                    .identityName(dto.getIdentityName())
                    .passive(new Passive(passiveInfo))
                    .level(dto.getLevel())
                    .isMain(dto.getIsMain())
                    .identity(dto.getIdentity())
                    .build();
            identityPassiveList.add(identityPassive);
        }
        return identityPassiveList;
    }

    public static List<IdentityPassive> toEntity(Sync4IdentitySupPassiveListDto dto){
        List<PassiveInfo> passiveInfoList = dto.getPassiveList().getPassiveInfo();
        List<IdentityPassive> identityPassiveList = new ArrayList<>();
        for (PassiveInfo passiveInfo : passiveInfoList) {
            IdentityPassive identityPassive = IdentityPassive.builder()
                    .identityName(dto.getIdentityName())
                    .passive(new Passive(passiveInfo))
                    .level(dto.getLevel())
                    .isMain(dto.getIsMain())
                    .identity(dto.getIdentity())
                    .build();
            identityPassiveList.add(identityPassive);
        }
        return identityPassiveList;
    }
}
