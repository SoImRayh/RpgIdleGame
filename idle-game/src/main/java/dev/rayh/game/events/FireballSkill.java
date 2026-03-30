package dev.rayh.game.events;

import dev.rayh.game.domain.Skill;
import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.systems.TargetSystem;

import java.util.List;

public class FireballSkill extends Skill {
    @Override
    public void execute(BattleContext context, BattleUnit caster) {
        List<BattleUnit> targets = TargetSystem.getSingleTarget();
    }
}
