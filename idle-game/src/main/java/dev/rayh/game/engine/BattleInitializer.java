package dev.rayh.game.engine;

import dev.rayh.game.domain.Hero;
import dev.rayh.game.events.AutoAttackEvent;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.systems.TargetSystem;

import java.util.List;
import java.util.stream.Collectors;

public class BattleInitializer {
    public static BattleContext init(List<Hero> teamA, List<Hero> teamB) {

        BattleContext ctx = new BattleContext();

        ctx.setTeamA(createUnits(teamA));
        ctx.setTeamB(createUnits(teamB));


        BattleUnit unit;

        int sizeTA = ctx.getTeamA().size();
        int sizeTB = ctx.getTeamB().size();

        for (int i = 0; i <= 5 ; i++){
            if (i < sizeTA){
                unit = ctx.getTeamA().get(i);
                if (unit != null){
                    ctx.scheduleEvent(new AutoAttackEvent(unit, TargetSystem.getNextTarget(ctx, unit), ctx.getNow(), i));
                }
            }
            if (i < sizeTB) {
                unit = ctx.getTeamB().get(i);
                if (unit != null){
                    ctx.scheduleEvent(new AutoAttackEvent(unit, TargetSystem.getNextTarget(ctx, unit), ctx.getNow(), i));
                }
            }
        }

        return ctx;
    }

    private static List<BattleUnit> pickTargets(BattleContext ctx, BattleUnit unit) {
        if (ctx.getTeamA().contains(unit)){
            return List.of(ctx.getTeamB().get(0));
        }else {
            return List.of(ctx.getTeamA().get(0));
        }
    }

    private static List<BattleUnit> createUnits(List<Hero> teamA) {
        List<BattleUnit> units = teamA.stream().map(BattleUnit::new).collect(Collectors.toList());
        return units;
    }
}
