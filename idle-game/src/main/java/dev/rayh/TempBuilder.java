package dev.rayh;

import dev.rayh.game.domain.hero.*;

import java.util.List;

public class TempBuilder {
    public static Hero getMeleeWithJustAutoAttack(String name_id){
        Hero hero = new Hero();


        hero.setHp(100);
        hero.setName(name_id);
        hero.setEnergy(0);
        hero.setAttack(10);
        hero.setDefense(20);
        hero.setAttackIntervalMs(1000);
        hero.setSkills(List.of(getAutoAttack(0)));

        return hero;
    }
/**  0: melee, 1: ranged*/
    private static Skill getAutoAttack(int meleeOrRanged){

        Effect effect = new Effect(EffectType.DAMAGE, 1.0, 0, 1, StatType.ATK);

        Skill skill = new Skill("auto_atack", 0, 1000, SkillType.DAMAGE, List.of(effect));

        return skill;
    }
}