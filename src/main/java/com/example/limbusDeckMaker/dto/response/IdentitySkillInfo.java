package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.IdentityDefSkill;
import com.example.limbusDeckMaker.domain.IdentitySkill1;
import com.example.limbusDeckMaker.domain.IdentitySkill2;
import com.example.limbusDeckMaker.domain.IdentitySkill3;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IdentitySkillInfo {

    private String name;
    private String power;
    private String type;
    private String resource;
    private Integer skillSeq;
    private Integer quantity;
    private Integer skillPower;
    private Integer coinPower;
    private Integer coinNum;
    private Integer atkWeight;
    private Integer level;

    private String normalEffect;
    private String coin1Effect;
    private String coin2Effect;
    private String coin3Effect;
    private String coin4Effect;
    private String coin5Effect;

    public IdentitySkillInfo(IdentitySkill1 skill1){
        this.name = skill1.getSkill1().getSkill1Info().getName();
        this.power = skill1.getSkill1().getSkill1Info().getPower();
        this.type = skill1.getSkill1().getSkill1Info().getType();
        this.resource = skill1.getSkill1().getSkill1Info().getResource();
        this.skillSeq = skill1.getSkill1().getSkill1Info().getSkillSeq();
        this.quantity = skill1.getSkill1().getSkill1Info().getQuantity();
        this.skillPower = skill1.getSkill1().getSkill1Info().getSkillPower();
        this.coinPower = skill1.getSkill1().getSkill1Info().getCoinPower();
        this.coinNum = skill1.getSkill1().getSkill1Info().getCoinNum();
        this.atkWeight = skill1.getSkill1().getSkill1Info().getAtkWeight();
        this.level = skill1.getLevel();

        this.normalEffect = skill1.getSkill1().getSkill1Info().getCoinEffect().getNormalEffect();
        this.coin1Effect = skill1.getSkill1().getSkill1Info().getCoinEffect().getCoin1Effect();
        this.coin2Effect = skill1.getSkill1().getSkill1Info().getCoinEffect().getCoin2Effect();
        this.coin3Effect = skill1.getSkill1().getSkill1Info().getCoinEffect().getCoin3Effect();
        this.coin4Effect = skill1.getSkill1().getSkill1Info().getCoinEffect().getCoin4Effect();
        this.coin5Effect = skill1.getSkill1().getSkill1Info().getCoinEffect().getCoin5Effect();
    }

    public IdentitySkillInfo(IdentitySkill2 skill2){
        this.name = skill2.getSkill2().getSkill2Info().getName();
        this.power = skill2.getSkill2().getSkill2Info().getPower();
        this.type = skill2.getSkill2().getSkill2Info().getType();
        this.resource = skill2.getSkill2().getSkill2Info().getResource();
        this.skillSeq = skill2.getSkill2().getSkill2Info().getSkillSeq();
        this.quantity = skill2.getSkill2().getSkill2Info().getQuantity();
        this.skillPower = skill2.getSkill2().getSkill2Info().getSkillPower();
        this.coinPower = skill2.getSkill2().getSkill2Info().getCoinPower();
        this.coinNum = skill2.getSkill2().getSkill2Info().getCoinNum();
        this.atkWeight = skill2.getSkill2().getSkill2Info().getAtkWeight();
        this.level = skill2.getLevel();

        this.normalEffect = skill2.getSkill2().getSkill2Info().getCoinEffect().getNormalEffect();
        this.coin1Effect = skill2.getSkill2().getSkill2Info().getCoinEffect().getCoin1Effect();
        this.coin2Effect = skill2.getSkill2().getSkill2Info().getCoinEffect().getCoin2Effect();
        this.coin3Effect = skill2.getSkill2().getSkill2Info().getCoinEffect().getCoin3Effect();
        this.coin4Effect = skill2.getSkill2().getSkill2Info().getCoinEffect().getCoin4Effect();
        this.coin5Effect = skill2.getSkill2().getSkill2Info().getCoinEffect().getCoin5Effect();
    }
//
    public IdentitySkillInfo(IdentitySkill3 skill3){
        this.name = skill3.getSkill3().getSkill3Info().getName();
        this.power = skill3.getSkill3().getSkill3Info().getPower();
        this.type = skill3.getSkill3().getSkill3Info().getType();
        this.resource = skill3.getSkill3().getSkill3Info().getResource();
        this.skillSeq = skill3.getSkill3().getSkill3Info().getSkillSeq();
        this.quantity = skill3.getSkill3().getSkill3Info().getQuantity();
        this.skillPower = skill3.getSkill3().getSkill3Info().getSkillPower();
        this.coinPower = skill3.getSkill3().getSkill3Info().getCoinPower();
        this.coinNum = skill3.getSkill3().getSkill3Info().getCoinNum();
        this.atkWeight = skill3.getSkill3().getSkill3Info().getAtkWeight();
        this.level = skill3.getLevel();

        this.normalEffect = skill3.getSkill3().getSkill3Info().getCoinEffect().getNormalEffect();
        this.coin1Effect = skill3.getSkill3().getSkill3Info().getCoinEffect().getCoin1Effect();
        this.coin2Effect = skill3.getSkill3().getSkill3Info().getCoinEffect().getCoin2Effect();
        this.coin3Effect = skill3.getSkill3().getSkill3Info().getCoinEffect().getCoin3Effect();
        this.coin4Effect = skill3.getSkill3().getSkill3Info().getCoinEffect().getCoin4Effect();
        this.coin5Effect = skill3.getSkill3().getSkill3Info().getCoinEffect().getCoin5Effect();
    }
//
    public IdentitySkillInfo(IdentityDefSkill defSkill){
        this.name = defSkill.getDefSkill().getDefSkillInfo().getName();
        this.power = defSkill.getDefSkill().getDefSkillInfo().getPower();
        this.type = defSkill.getDefSkill().getDefSkillInfo().getType();
        this.resource = defSkill.getDefSkill().getDefSkillInfo().getResource();
        this.skillSeq = defSkill.getDefSkill().getDefSkillInfo().getSkillSeq();
        this.quantity = defSkill.getDefSkill().getDefSkillInfo().getQuantity();
        this.skillPower = defSkill.getDefSkill().getDefSkillInfo().getSkillPower();
        this.coinPower = defSkill.getDefSkill().getDefSkillInfo().getCoinPower();
        this.coinNum = defSkill.getDefSkill().getDefSkillInfo().getCoinNum();
        this.atkWeight = defSkill.getDefSkill().getDefSkillInfo().getAtkWeight();
        this.level = defSkill.getLevel();

        this.normalEffect = defSkill.getDefSkill().getDefSkillInfo().getCoinEffect().getNormalEffect();
        this.coin1Effect = defSkill.getDefSkill().getDefSkillInfo().getCoinEffect().getCoin1Effect();
        this.coin2Effect = defSkill.getDefSkill().getDefSkillInfo().getCoinEffect().getCoin2Effect();
        this.coin3Effect = defSkill.getDefSkill().getDefSkillInfo().getCoinEffect().getCoin3Effect();
        this.coin4Effect = defSkill.getDefSkill().getDefSkillInfo().getCoinEffect().getCoin4Effect();
        this.coin5Effect = defSkill.getDefSkill().getDefSkillInfo().getCoinEffect().getCoin5Effect();
    }

    public static List<IdentitySkillInfo> fromSkill1(List<IdentitySkill1> identitySkill1s){
        List<IdentitySkillInfo> infoList = new ArrayList<>();
        for(IdentitySkill1 skill1 : identitySkill1s){
            infoList.add(new IdentitySkillInfo(skill1));
        }
        return infoList;
    }

    public static List<IdentitySkillInfo> fromSkill2(List<IdentitySkill2> identitySkill2s){
        List<IdentitySkillInfo> infoList = new ArrayList<>();
        for(IdentitySkill2 skill2 : identitySkill2s){
            infoList.add(new IdentitySkillInfo(skill2));
        }
        return infoList;
    }

    public static List<IdentitySkillInfo> fromSkill3(List<IdentitySkill3> identitySkill3s){
        List<IdentitySkillInfo> infoList = new ArrayList<>();
        for(IdentitySkill3 skill3 : identitySkill3s){
            infoList.add(new IdentitySkillInfo(skill3));
        }
        return infoList;
    }

    public static List<IdentitySkillInfo> fromDefSkill(List<IdentityDefSkill> identityDefSkills){
        List<IdentitySkillInfo> infoList = new ArrayList<>();
        for(IdentityDefSkill defSkill : identityDefSkills){
            infoList.add(new IdentitySkillInfo(defSkill));
        }
        return infoList;
    }
}
