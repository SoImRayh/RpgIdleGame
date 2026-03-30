package dev.rayh.game.events;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.runtime.EffectInstance;

public class EffectExpirationEvent extends BattleEvent{

    private EffectInstance effectInstance;
    private BattleUnit target;

    public EffectExpirationEvent (EffectInstance instance, BattleUnit target){
        this.effectInstance = instance;
        this.target = target;
    }

    @Override
    public void execute(BattleContext ctx) {
        effectInstance.getEffect().onExpire(ctx, target);
    }
}
