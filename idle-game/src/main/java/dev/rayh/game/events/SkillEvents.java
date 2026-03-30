package dev.rayh.game.events;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.runtime.SkillInstance;

public class SkillEvents extends BattleEvent{

    private BattleUnit caster;
    private SkillInstance skillInstance;

    @Override
    public void execute(BattleContext ctx) {
        if (!caster.isAlive()) return;

        skillInstance.cast(ctx, caster);

    }
}
