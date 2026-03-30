package dev.rayh.game.domain.battle;

import dev.rayh.TempBuilder;
import dev.rayh.game.domain.hero.Hero;
import lombok.Data;

import java.util.List;

@Data
public class BattleEngine {
    private BattleContext battleContext;

//todo update to receive a Battle and transform in a context
    public BattleEngine(){
    }

    public void setup(){
        Hero h1,h2;
        h1 = TempBuilder.getMeleeWithJustAutoAttack("h1");
        h2 = TempBuilder.getMeleeWithJustAutoAttack("h2");

        System.out.println("char 1: ".concat(h1.toString()));
        System.out.println("char 2: ".concat(h2.toString()));
        this.battleContext = new BattleContext(h1, h2);
    }


    public void start(){
        try {
            EventScheduler scheduler = new EventScheduler(battleContext);

            // team 1

            //team 2

            scheduler.schedule(new SpawnEvent(), 10500);
            scheduler.schedule(new AutoAttackEvent(), 1000);

            scheduler.run();
        }catch (Exception e){

        }
    }

    private List<EffectResult> execute(U)
}



interface EventoDeBatalha{
    void executar(BattleContext battleContext, EventScheduler scheduler);
}

class AutoAttackEvent implements EventoDeBatalha {
    @Override
    public void executar(BattleContext battleContext, EventScheduler scheduler) {
//        battleContext.log(System.currentTimeMillis(), "atacou causando dano e energia: " + battleContext.getEnergy());

        scheduler.schedule(new AutoAttackEvent(), attackSpeed);
    }

    final long attackSpeed = 1000;

}

class UltimateCastEvent implements EventoDeBatalha {

    @Override
    public void executar(BattleContext battleContext, EventScheduler scheduler) {
//        if (battleContext.getEnergy() >= 100){
//            battleContext.setEnergy(0);
//            battleContext.log(System.currentTimeMillis(), "::Usando ultimate!");
//
//        }
    }
}

class SpawnEvent implements EventoDeBatalha {

    @Override
    public void executar(BattleContext battleContext, EventScheduler scheduler) {
        System.out.println("Champ spawnando");
    }
}

class EventoAgendado implements Comparable<EventoAgendado>{
    long executarEm;
    EventoDeBatalha evento;
    long sequence;
    public EventoAgendado(long executarEm, EventoDeBatalha e) {
        this.executarEm = executarEm;
        this.evento = e;
    }
    @Override
    public int compareTo(EventoAgendado o) {
        int cmp = Long.compare(this.executarEm, o.executarEm);
        if (cmp == 0) {
            cmp = Long.compare(this.sequence, o.sequence);
        }
        return cmp;
    }
}


