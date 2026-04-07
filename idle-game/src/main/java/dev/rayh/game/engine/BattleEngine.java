package dev.rayh.game.engine;

import dev.rayh.game.events.BattleEvent;

public class BattleEngine{


    public void run(BattleContext battle){
        BattleEvent event;
        while( !battle.getTimeline().isEmpty() && !battle.isFinished()){
            event = battle.getTimeline().removeFirst();
            battle.setNow(event.getExecuteAt());

            event.execute(battle);
        }
        if (battle.isFinished()){

            battle.getTeamA().stream().forEach( u -> {
                System.out.printf("\n%s, HP: %s", u.getBaseHero().getName(), u.getCurrentHp());
            });
            battle.getTeamB().stream().forEach( u -> {
                System.out.printf("\n%s, HP: %s", u.getBaseHero().getName(), u.getCurrentHp());
            });
           finalizar();
        }
    }

    void finalizar(){

        System.out.println("aaaaaaaaaa");
    }
}
