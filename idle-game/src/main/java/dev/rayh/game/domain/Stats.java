package dev.rayh.game.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Stats {
    double attack;
    double defense;
    double hp;
    double speed;
    double critChance;
    double critDamage;
}
