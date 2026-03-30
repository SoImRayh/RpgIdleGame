package dev.rayh.game.engine;

import dev.rayh.game.domain.Hero;
import dev.rayh.game.events.AutoAttackEvent;
import dev.rayh.game.runtime.BattleUnit;

import java.util.List;
import java.util.stream.Collectors;

public class BattleInitializer {
    public static BattleContext init(List<Hero> teamA, List<Hero> teamB) {

        BattleContext ctx = new BattleContext();

        ctx.setTA(createUnits(teamA));
        ctx.setTB(createUnits(teamB));

        // agendar ataques iniciais
        for (BattleUnit unit : ctx.getTA()) {
            ctx.scheduleEvent(new AutoAttackEvent(unit, pickTargets(ctx, unit), 0));
        }

        for (BattleUnit unit : ctx.getTB()) {
            ctx.scheduleEvent(new AutoAttackEvent(unit, pickTargets(ctx, unit), 0));
        }

        return ctx;
    }

    private static List<BattleUnit> pickTargets(BattleContext ctx, BattleUnit unit) {
        if (ctx.getTA().contains(unit)){
            return List.of(ctx.getTB().get(0));
        }else {
            return List.of(ctx.getTA().get(0));
        }
    }

    private static List<BattleUnit> createUnits(List<Hero> teamA) {
        List<BattleUnit> units = teamA.stream().map(BattleUnit::new).collect(Collectors.toList());
        return units;
    }
}
