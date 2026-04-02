package dev.rayh.game.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import dev.rayh.game.events.BattleEvent;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.domain.Hero;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BattleContext {

    private final long MAX_DURATION = 120000L; //max duration of the battles : 2 minutes.
    private boolean isFinished;
    private List<BattleUnit> teamA;
    private List<BattleUnit> teamB;
    private  PriorityQueue<BattleEvent> timeline = new PriorityQueue<>(10);
    private long now;
    private Random rng = new Random();

    public BattleContext (Hero h1, Hero h2){
        this.teamA = new ArrayList<>(5);
        this.teamB = new ArrayList<>(5);
        teamA.add(new BattleUnit(h1));
        teamB.add(new BattleUnit(h2));
        this.now = System.currentTimeMillis();
    }

    public void scheduleEvent(BattleEvent e){
        //only schedule the event if the executeAt is less that MAX_DURATION.
        if (e.getExecuteAt() <= MAX_DURATION)
            this.timeline.add(e);
    }
}

