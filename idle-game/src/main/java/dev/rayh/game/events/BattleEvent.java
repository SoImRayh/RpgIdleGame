package dev.rayh.game.events;

import dev.rayh.game.engine.BattleContext;
import lombok.Data;

@Data
public abstract class BattleEvent implements Comparable<BattleEvent>{
    private int sequence;
    private long executeAt;
    public abstract void execute(BattleContext ctx);

    @Override
    public int compareTo(BattleEvent battleEvent) {
        int cmp = Long.compare(this.executeAt, battleEvent.getExecuteAt());
        if  (cmp == 0){
            cmp = Long.compare(this.sequence, battleEvent.getSequence());
        }
        return cmp;
    }
}
