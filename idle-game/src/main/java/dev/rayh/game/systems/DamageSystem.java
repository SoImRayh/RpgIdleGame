package dev.rayh.game.systems;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class DamageSystem {
    public static void applyBasicAttackDamage(BattleContext battle, BattleUnit attacker, BattleUnit target){
        double dmg = attacker.getStats().getAttack() - target.getStats().getDefense();

        if  (battle.getRng().nextDouble() < attacker.getStats().getCritChance()){
            dmg *= attacker.getStats().getCritDamage();
        }

        dmg = Math.max(1, dmg);
        target.setCurrentHp(target.getCurrentHp() - dmg);

        battle.log(
                String.format("[%s] = %s attack %s and cause: %s damage",
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(battle.getNow()), ZoneId.of("UTC")),
                        attacker.getBaseHero().getName(),
                        target.getBaseHero().getName(),
                        dmg)
        );

        if (!target.isAlive()){
            target.setCurrentHp(0);
            DeathSystem.handleDeath(battle, target);
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
