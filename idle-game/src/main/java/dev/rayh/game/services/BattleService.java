package dev.rayh.game.services;

import dev.rayh.game.domain.battle.BattleContext;
import dev.rayh.game.domain.battle.BattleEventInternal;

public class BattleService {

    public void runBattle(BattleContext b) {
        System.out.println("iniciando a batalha");
    }

    public void processUntil(BattleContext battleContext, long now) {
        while (!battleContext.getTimeline().isEmpty() && battleContext.getTimeline().peek().getExecuteAt() <= now) {
            BattleEventInternal event = battleContext.getTimeline().poll();
            handleEvent(battleContext, event);
        }
        battleContext.setTempoAtual(now);
    }

    private void handleEvent(BattleContext b, BattleEventInternal event){

    }

}
