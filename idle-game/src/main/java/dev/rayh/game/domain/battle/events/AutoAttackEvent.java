package dev.rayh.game.domain.battle.events;

import dev.rayh.game.domain.battle.BattleContext;
import dev.rayh.game.domain.battle.BattleEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class AutoAttackEvent extends BattleEvent {

    @Override
    public void execute(BattleContext ctx) {
        System.out.println("estou atacando");
    }

    @Override
    public int compareTo(BattleEvent battleEvent) {
        int cmp = Long.compare(super.getExecuteAt(), battleEvent.getExecuteAt());
        if  (cmp == 0){
            cmp = Long.compare(super.getSequence(), battleEvent.getSequence());
        }
        return cmp;
    }
}
