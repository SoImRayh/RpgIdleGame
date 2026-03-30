package dev.rayh.game.events;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.systems.DamageSystem;
import lombok.Data;

import java.util.List;

@Data
public class AutoAttackEvent extends BattleEvent {

    private BattleUnit attacker;
    private List<BattleUnit> target;

    public AutoAttackEvent (BattleUnit attacker, List<BattleUnit> targets, long executeAt){
        this.attacker = attacker;
        this.target = targets;
        super.setExecuteAt(executeAt);
    }

    @Override
    public void execute(BattleContext ctx) {

        for (BattleUnit u : this.target){
            if (!attacker.isAlive() || !u.isAlive())
                return;
            DamageSystem.applyBasicAttackDamage(ctx, attacker, u);
            //todo implementar uma alteração de target quando o alvo morre, quando morre remover eventos futuros que realacionam esse heroi
            //if (!u.isAlive())
        }
        //schedule next aa todo, implements next aa using speed as variable
        long nextAA = System.currentTimeMillis() + 1000;
        ctx.scheduleEvent(new AutoAttackEvent(attacker, target, nextAA ));

    }
}
