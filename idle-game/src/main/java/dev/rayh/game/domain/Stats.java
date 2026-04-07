package dev.rayh.game.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Stats {
    double attack; // Define the damage caused by the hero auto attacks
    double defense; // Define how much damage will be mitigated of physics attacks
    double hp; //Define the max hp this hero has
    double agility; // chance to dodge the auto attacks and velocity of auto attacks (different scale)
    double critChance; // chance to cause a critical attack;
    int critDamage; // when critic auto attack, the multiplier of this attack
}
