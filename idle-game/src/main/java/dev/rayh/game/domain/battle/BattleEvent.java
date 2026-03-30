package dev.rayh.game.domain.battle;

import lombok.Data;

@Data
public abstract class BattleEvent implements Comparable<BattleEvent>{
    private int sequence;
    private long executeAt;
    public abstract void execute(BattleContext ctx);
}
