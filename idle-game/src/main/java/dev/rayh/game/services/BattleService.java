package dev.rayh.game.services;

import java.time.LocalDateTime;

import dev.rayh.game.domain.battle.Battle;
import dev.rayh.game.domain.battle.BattleEventInternal;

public class BattleService {

    public void runBattle(Battle b) {
        System.out.println("iniciando a batalha");
        processUntil(b, LocalDateTime.now());
    }

    public void processUntil(Battle battle, long now) {
        while (!battle.getTimeline().isEmpty() && battle.getTimeline().peek().getExecuteAt() <= now) {
            BattleEventInternal event = battle.getTimeline().poll();
            handleEvent(battle, event);
        }
        battle.setLastProcessedTime(now);
    }

    private void handleEvent(Battle b, BattleEventInternal event){

    }

}
