package dev.rayh.game.runtime;

import dev.rayh.game.domain.Effect;
import lombok.Data;

@Data
public class EffectInstance {
    private Effect effect;
    private long expireAt;

}
