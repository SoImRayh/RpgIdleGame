package dev.rayh.game.domain.battle;

import lombok.Data;

@Data
public class EffectResult {

    private String unit_id;
    private int damage;

    public EffectResult(String id, int dmg) {
        this.unit_id = id;
        this.damage = dmg;
    }
}
