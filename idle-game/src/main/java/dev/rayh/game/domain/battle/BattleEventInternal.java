package dev.rayh.game.domain.battle;

import lombok.Data;

@Data
public class BattleEventInternal {

    private long executeAt;
    private EventType type;
    private String sourceUnitId;
}
