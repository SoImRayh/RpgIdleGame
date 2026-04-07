package dev.rayh.game.systems;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;

import java.util.ArrayList;
import java.util.List;

public class TargetSystem {
    public static List<BattleUnit> getSingleTarget() {

        return null;
    }

    public static BattleUnit getNextTarget(BattleContext ctx, BattleUnit attacker) {
        BattleUnit target;

        if (ctx.getTeamA().contains(attacker)){
            //search target in teamB
            target = (ctx.getTeamB().stream().filter(BattleUnit::isAlive).findFirst().get());
        }else {
            target = (ctx.getTeamA().stream().filter(BattleUnit::isAlive).findFirst().get());
        }
        return target;
    }
}

enum Priority {
    MIN_HEALTH
}
