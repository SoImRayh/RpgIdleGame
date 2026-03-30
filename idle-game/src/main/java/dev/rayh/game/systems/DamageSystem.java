package dev.rayh.game.systems;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;

public class DamageSystem {
    public static void applyBasicAttackDamage(BattleContext context, BattleUnit attacker, BattleUnit target){
        double dmg = attacker.getStats().getAttack() - target.getStats().getDefense();

        if  (context.getRng().nextDouble() < attacker.getStats().getCritChance()){
            dmg *= attacker.getStats().getCritDamage();
        }

        dmg = Math.max(1, dmg);
        target.setCurrentHp(target.getCurrentHp() - dmg);

        if (!target.isAlive()){
            target.setCurrentHp(0);
            DeathSystem.handleDeath(context, target);
        }
    }

    static void applySkillDamage(BattleContext context, BattleUnit caster,BattleUnit target, double multiplier){
        double dmg = caster.getStats().getAttack() * multiplier;

        target.setCurrentHp(target.getCurrentHp() - dmg);

        if (!target.isAlive()){
            target.setCurrentHp(0);
            DeathSystem.handleDeath(context, target);
        }
    }
}
