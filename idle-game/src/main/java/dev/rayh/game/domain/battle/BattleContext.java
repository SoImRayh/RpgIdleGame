package dev.rayh.game.domain.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import dev.rayh.game.domain.hero.Hero;
import lombok.Data;

@Data
public class BattleContext {

    private BattleStatus status;
    private List<BattleUnit> t1;
    private List<BattleUnit> t2;
    private  PriorityQueue<BattleEvent> timeline;
    private long now;
    private Random rng;

    public BattleContext (Hero h1, Hero h2){
        this.t1 = new ArrayList<>(5);
        this.t2 = new ArrayList<>(5);
        t1.add(new BattleUnit(h1));
        t2.add(new BattleUnit(h2));
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
