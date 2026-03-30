package dev.rayh.game.runtime;

import dev.rayh.game.domain.Skill;
import dev.rayh.game.engine.BattleContext;

import java.util.List;

public class SkillInstance {
    private Skill skill;
    private long cooldown;

    public void cast(BattleContext ctx, BattleUnit caster){
        skill.execute(ctx, caster);
    }
}
