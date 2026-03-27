package dev.rayh.game.domain.battle;

import java.util.PriorityQueue;

import dev.rayh.game.domain.Champion;
import lombok.Data;

@Data
public class BattleContext {
    private int id;
    private boolean isHappening = true;
    private long tempoAtual;
    private BattleUnit c1;
    private BattleUnit c2;
    private int energy = 0;

    private  PriorityQueue<BattleEventInternal> timeline;


    void add(Champion c, int team){
        BattleUnit unit = new BattleUnit(c);
    }

    void setToTeam(BattleUnit u, int team){
        switch (team) {
            case 0: //c1
                c1 = u;
                break;
            case 1: // c2
                c2 = u;
                break;
        
            default:
                break;
        }
    }

    public void log(long time, String message){
        System.out.println( time + "::"+message);
    }
}
