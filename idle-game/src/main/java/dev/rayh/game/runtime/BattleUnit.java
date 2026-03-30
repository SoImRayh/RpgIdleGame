package dev.rayh.game.runtime;

import dev.rayh.game.domain.Hero;
import dev.rayh.game.domain.Stats;
import lombok.Data;

import java.util.List;

@Data
public class BattleUnit {
    private String instanceId;
    private Hero baseHero;
    private int lvl;
    private Stats stats;
    private List<SkillInstance> skills;
    private List<EffectInstance> effects;

    private double maxHp;
    private double currentHp;
    double energy = 0;
    double maxEnergy = 100;
    double energyRegenPerSec = 10;

    public BattleUnit (Hero h){
        this.instanceId = h.getName();
        this.baseHero = h;
        this.stats = h.getBaseStats();
        this.maxHp = h.getBaseStats().getHp();
        this.currentHp = getStats().getHp();

    }

    public boolean isAlive (){
        return currentHp > 0;
    };
}
