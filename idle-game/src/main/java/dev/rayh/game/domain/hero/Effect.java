package dev.rayh.game.domain.hero;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Effect {
    EffectType type; // DAMAGE, HEAL, APPLY_BUFF

    double multiplier; // ex: 1.2x ATK

    int duration; // para buffs/debuffs

    double chance; // % de aplicar

    StatType scalingStat; // ATK, DEF, HP
}
