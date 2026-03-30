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

    private boolean isFinished;
    private List<BattleUnit> tA;
    private List<BattleUnit> tB;
    private  PriorityQueue<BattleEvent> timeline = new PriorityQueue<>(10);
    private long now;
    private Random rng = new Random();

    public BattleContext (Hero h1, Hero h2){
        this.tA = new ArrayList<>(5);
        this.tB = new ArrayList<>(5);
        tA.add(new BattleUnit(h1));
        tB.add(new BattleUnit(h2));
        this.now = System.currentTimeMillis();
    }

    public void scheduleEvent(BattleEvent e){
        this.timeline.add(e);
    }

    public void log(long time, String message){
        System.out.println( time + "::"+message);
    }
}

enum BattleStatus {
    ONGOING,
    FINISHED
}
