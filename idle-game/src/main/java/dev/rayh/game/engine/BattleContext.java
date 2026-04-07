package dev.rayh.game.engine;

import java.util.*;

import dev.rayh.game.events.BattleEvent;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.domain.Hero;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class BattleContext {

    private final long MAX_DURATION = 120000L; //max duration of the battles : 2 minutes.
    private boolean isFinished;
    private List<BattleUnit> teamA;
    private List<BattleUnit> teamB;
    private  LinkedList<BattleEvent> timeline = new LinkedList<>();
    private long now;
    private long finishAt;
    private int winner; // < 0 : team A  | == 0: Draw | > 0 : team B
    private Random rng = new Random();

    public BattleContext(){
        this.now = System.currentTimeMillis();
        this.setFinishAt(this.now + MAX_DURATION);
    }

    public BattleContext (Hero h1, Hero h2){
        this.teamA = new ArrayList<>(5);
        this.teamB = new ArrayList<>(5);
        teamA.add(new BattleUnit(h1));
        teamB.add(new BattleUnit(h2));
        this.now = System.currentTimeMillis();
    }

    public void scheduleEvent(BattleEvent e){
        //only schedule the event if the executeAt is less that MAX_DURATION.
        if (this.timeline.isEmpty()){;
            this.timeline.add(e);
            return;
        }

        //encontrar a posicao na fila:
        int posicao = 0;

        for (int i = this.timeline.size(); i > 0; i--) {
            if (this.timeline.get(i-1).getExecuteAt() <= e.getExecuteAt()){
                posicao = i;
            }
        }

        this.timeline.add(posicao, e);
    }

    public void log (String s){
        System.out.println(s);
    }

    public void setFinishAt(long now){
        this.finishAt = now + this.MAX_DURATION;
    }
}

