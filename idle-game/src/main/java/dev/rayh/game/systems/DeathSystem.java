package dev.rayh.game.systems;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;

public class DeathSystem {

        static void handleDeath(BattleContext ctx, BattleUnit unit) {
            unit.setCurrentHp(0);
            System.out.printf("unidade: %s morreu!", unit.getInstanceId());

            ctx.setFinished(true);

            // remover eventos futuros? (opcional)
            // disparar triggers (passivas, etc)

            checkBattleEnd(ctx);
        }

        static void checkBattleEnd(BattleContext ctx) {
            boolean teamADead = ctx.getTeamA().stream().noneMatch(BattleUnit::isAlive);
            boolean teamBDead = ctx.getTeamB().stream().noneMatch(BattleUnit::isAlive);

            if (teamADead || teamBDead) {
                ctx.setFinished(true);
            }
        }
    }

