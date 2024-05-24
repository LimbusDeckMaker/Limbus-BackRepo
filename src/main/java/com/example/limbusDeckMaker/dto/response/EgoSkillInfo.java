package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.CorrosionSkill;
import com.example.limbusDeckMaker.domain.EgoSkill;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EgoSkillInfo {

    private String name;
    private String power;
    private Integer mentalConsume;
    private String atkType;
    private String resource;
    private Integer skillPower;
    private Integer coinPower;
    private Integer coinNum;
    private Integer atkWeight;
    private Integer construeLevel;
    private String normalEffect;
    private String coin1Effect;
    private String coin2Effect;
    private String coin3Effect;
    private String coin4Effect;
    private String coin5Effect;


    public EgoSkillInfo(EgoSkill egoSkill){
        this.name = egoSkill.getName();
        this.power = egoSkill.getSkill().getSkillInfo().getPower();
        this.mentalConsume = egoSkill.getSkill().getSkillInfo().getMentalConsume();
        this.atkType = egoSkill.getSkill().getSkillInfo().getAtkType();
        this.resource = egoSkill.getSkill().getSkillInfo().getResource();
        this.skillPower = egoSkill.getSkill().getSkillInfo().getSkillPower();
        this.coinPower = egoSkill.getSkill().getSkillInfo().getCoinPower();
        this.coinNum = egoSkill.getSkill().getSkillInfo().getCoinNum();
        this.atkWeight = egoSkill.getSkill().getSkillInfo().getAtkWeight();
        this.construeLevel = egoSkill.getConstrueLevel();
        this.normalEffect = egoSkill.getSkill().getSkillInfo().getCoinHitInfo().getNormalEffect();
        this.coin1Effect = egoSkill.getSkill().getSkillInfo().getCoinHitInfo().getCoin1Effect();
        this.coin2Effect = egoSkill.getSkill().getSkillInfo().getCoinHitInfo().getCoin2Effect();
        this.coin3Effect = egoSkill.getSkill().getSkillInfo().getCoinHitInfo().getCoin3Effect();
        this.coin4Effect = egoSkill.getSkill().getSkillInfo().getCoinHitInfo().getCoin4Effect();
        this.coin5Effect = egoSkill.getSkill().getSkillInfo().getCoinHitInfo().getCoin5Effect();
    }

    public EgoSkillInfo(CorrosionSkill corSkill){
        this.name = corSkill.getName();
        this.power = corSkill.getCorSkill().getCorrosionSkillInfo().getPower();
        this.mentalConsume = corSkill.getCorSkill().getCorrosionSkillInfo().getMentalConsume();
        this.atkType = corSkill.getCorSkill().getCorrosionSkillInfo().getAtkType();
        this.resource = corSkill.getCorSkill().getCorrosionSkillInfo().getResource();
        this.skillPower = corSkill.getCorSkill().getCorrosionSkillInfo().getSkillPower();
        this.coinPower = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinPower();
        this.coinNum = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinNum();
        this.atkWeight = corSkill.getCorSkill().getCorrosionSkillInfo().getAtkWeight();
        this.construeLevel = corSkill.getConstrueLevel();
        this.normalEffect = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinHitInfo().getNormalEffect();
        this.coin1Effect = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinHitInfo().getCoin1Effect();
        this.coin2Effect = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinHitInfo().getCoin2Effect();
        this.coin3Effect = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinHitInfo().getCoin3Effect();
        this.coin4Effect = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinHitInfo().getCoin4Effect();
        this.coin5Effect = corSkill.getCorSkill().getCorrosionSkillInfo().getCoinHitInfo().getCoin5Effect();
    }

    public static List<EgoSkillInfo> fromEgoSkills(List<EgoSkill> egoSkills) {
        List<EgoSkillInfo> egoSkillInfos = new ArrayList<>();
        for (EgoSkill egoSkill : egoSkills) {
            egoSkillInfos.add(new EgoSkillInfo(egoSkill));
        }
        return egoSkillInfos;
    }

    public static List<EgoSkillInfo> fromCorrosionSkills(List<CorrosionSkill> corSkills) {
        List<EgoSkillInfo> egoSkillInfos = new ArrayList<>();
        for (CorrosionSkill corSkill : corSkills) {
            egoSkillInfos.add(new EgoSkillInfo(corSkill));
        }
        return egoSkillInfos;
    }
}
