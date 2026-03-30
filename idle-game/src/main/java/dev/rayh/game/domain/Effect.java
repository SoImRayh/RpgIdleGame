package dev.rayh.game.domain;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Effect {
    private long duration;

    public abstract void onApply(BattleContext ctx, BattleUnit target);
    public abstract void onExpire(BattleContext ctx, BattleUnit target);
}
