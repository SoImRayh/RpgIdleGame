package dev.rayh.game.systems;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;


public class DeathSystem {

        static void handleDeath(BattleContext ctx, BattleUnit unit) {
            System.out.printf("unidade: %s morreu!\n", unit.getInstanceId());



            checkBattleEnd(ctx);
        }

        static void checkBattleEnd(BattleContext ctx) {
            boolean teamADead = ctx.getTeamA().stream().noneMatch(BattleUnit::isAlive);
            boolean teamBDead = ctx.getTeamB().stream().noneMatch(BattleUnit::isAlive);
            if (teamADead){
                ctx.setWinner(1);
                ctx.setFinished(true);
            } else if (teamBDead) {
                ctx.setWinner(-1);
                ctx.setFinished(true);
            }
        }
    }

