package dev.rayh.game.domain.battle;

import dev.rayh.game.domain.Champion;
import dev.rayh.game.domain.Skill;

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

    public BattleUnit(Champion c){
        this.id = c.getName();
        this.maxHp = c.getHp();
        this.attack = c.getAttack();
    }
}
