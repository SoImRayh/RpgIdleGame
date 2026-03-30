package dev.rayh.game.domain.battle;

import dev.rayh.game.domain.hero.Hero;
import dev.rayh.game.domain.hero.Skill;
import lombok.Data;

@Data
public class BattleUnit {
    String id;
    int hp;
    int maxHp;
    int attack;
    int defense;
    double attackIntervalMs; // tempo entre ataques 
    double nextAttackTime; //timestamp absoluto;
    double energy;
    double maxEnergy = 100;
    double energyRegenPerSec;
    Skill ultimateSkill;
    boolean dead;

    public BattleUnit(Hero c){
        this.id = c.getName();
        this.maxHp = c.getHp();
        this.hp = c.getHp();
        this.attack = c.getAttack();
        this.defense = c.getDefense();
        this.energy = 0;
        this.maxEnergy = c.getEnergy();
        this.energyRegenPerSec = 10;
        this.ultimateSkill = null;
        this.dead = false;
        this.attackIntervalMs = c.getAttackIntervalMs();
    }
}
