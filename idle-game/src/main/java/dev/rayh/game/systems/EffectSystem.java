package dev.rayh.game.systems;

import dev.rayh.game.domain.Effect;
import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.events.EffectExpirationEvent;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.runtime.EffectInstance;

public class EffectSystem {
    static void applyEffect(BattleContext ctx, BattleUnit target, Effect effect){
        EffectInstance instance;

        instance = new EffectInstance();
        instance.setEffect(effect);
        instance.setExpireAt(ctx.getNow() + effect.getDuration());

        target.getEffects().add(instance);

        effect.onApply(ctx, target);

        ctx.scheduleEvent(new EffectExpirationEvent(instance, target));
    }
}
