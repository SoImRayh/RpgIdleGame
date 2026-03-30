package dev.rayh.game.domain.battle;

import dev.rayh.game.domain.hero.Skill;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class SkillExecutor {

    private final DamageCalculator damageCalculator = new DamageCalculator();

    public List<EffectResult> execute(BattleUnit actor, List<BattleUnit> targets, Skill skill){
        List<EffectResult> results = new LinkedList<>();

        switch (skill.getType()){
            case DAMAGE:
                for (BattleUnit unit : targets){
                    int dmg = damageCalculator.calculate(actor, unit, skill);
                    results.add(new EffectResult(unit.getId(), dmg));
                }
                break;
            case BUFF:
            case HEAL:
            case DEBUFF:
        }

        return results;
    }
}
