package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.IdentityPassive;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IdentityPassiveInfo {

    private String name;
    private Boolean isMain;
    private String resource;
    private Integer resQuantity;
    private String activeCond;
    private String effect;
    private Integer level;

    public IdentityPassiveInfo(IdentityPassive passive){
        this.name = passive.getPassive().getPassiveInfo().getName();
        this.isMain = passive.getIsMain();
        this.resource = passive.getPassive().getPassiveInfo().getResource();
        this.resQuantity = passive.getPassive().getPassiveInfo().getResQuantity();
        this.activeCond = passive.getPassive().getPassiveInfo().getActiveCond();
        this.effect = passive.getPassive().getPassiveInfo().getEffect();
        this.level = passive.getLevel();
    }

    public static List<IdentityPassiveInfo> fromPassives(List<IdentityPassive> passives){
        List<IdentityPassiveInfo> passiveInfos = new ArrayList<>();
        passives.forEach(passive -> {
            passiveInfos.add(new IdentityPassiveInfo(passive));
        });
        return passiveInfos;
    }
}
