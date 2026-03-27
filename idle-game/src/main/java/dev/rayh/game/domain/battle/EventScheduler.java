package dev.rayh.game.domain.battle;


import java.util.PriorityQueue;

public class EventScheduler {
    private final BattleContext battleContext;
    private final PriorityQueue<EventoAgendado> timeline = new PriorityQueue<>();

    public EventScheduler(BattleContext battleContext) {
        this.battleContext = battleContext;
    }

    public void schedule(EventoDeBatalha e, long delay){
        long executarEm = System.currentTimeMillis() + delay;
        timeline.add(new EventoAgendado(executarEm, e));
    }

    public void run(){
        while(battleContext.isHappening() && !timeline.isEmpty()){
            EventoAgendado evento = timeline.peek();
            long agora = System.currentTimeMillis();

            if (evento.executarEm <= agora){
                timeline.poll();
                battleContext.setTempoAtual(agora);
                evento.evento.executar(battleContext, this);
            } else {
                long sleepTime = evento.executarEm - agora;
                try {

                    Thread.sleep(Math.min(sleepTime, 50));
                } catch (InterruptedException e) {}
            }
        }
    }
}
