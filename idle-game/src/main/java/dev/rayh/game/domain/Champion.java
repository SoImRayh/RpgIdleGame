package dev.rayh.game.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int energy;
    double attackIntervalMs;
    private List<Skill> skills;

    public Champion (String name) {
        Effect effect = new Effect(EffectType.DAMAGE, 1.0, 0, 1, StatType.ATK);

        Skill ability = new Skill("auto_atack", 0, 1000, SkillType.DAMAGE, List.of(effect));

        this.name  = name;
        this.hp = 100;
        this.skills = List.of(ability);
        this.attack = 10;
        this.defense = 5;
        this.attackIntervalMs = 1000;
        this.energy = 100;

    }


}
