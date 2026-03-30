package dev.rayh.game.systems;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;

import java.util.List;

public class TargetSystem {
    public static List<BattleUnit> getSingleTarget() {

        return null;
    }

    public static List<BattleUnit> getSingleTarget(BattleContext ctx, BattleUnit attacker) {

        return null;
    }
}

enum Priority {
    MIN_HEALTH
}
