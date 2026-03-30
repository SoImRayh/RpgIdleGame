package dev.rayh.game.engine;

import dev.rayh.game.events.BattleEvent;

public class BattleEngine {
    public void run(BattleContext context){
        while( !context.getTimeline().isEmpty() && !context.isFinished()){
            BattleEvent event = context.getTimeline().poll();
            context.setNow(event.getExecuteAt());

            event.execute(context);
        }
    }
}
