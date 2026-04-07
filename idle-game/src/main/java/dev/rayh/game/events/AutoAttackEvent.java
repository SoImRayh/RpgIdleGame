package dev.rayh.game.events;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import dev.rayh.game.systems.DamageSystem;
import dev.rayh.game.systems.TargetSystem;
import lombok.Data;

import javax.swing.text.TabExpander;
import java.util.List;

@Data
public class AutoAttackEvent extends BattleEvent {

    private BattleUnit attacker;
    private BattleUnit target;

    public AutoAttackEvent (BattleUnit attacker, BattleUnit target, long executeAt, int sequence){
        this.attacker = attacker;
        this.target = target;
        super.setSequence(sequence);
        super.setExecuteAt(executeAt);
    }

    public AutoAttackEvent (BattleUnit attacker, BattleUnit target, long executeAt){
        this.attacker = attacker;
        this.target = target;
        super.setExecuteAt(executeAt);
    }

    @Override
    public void execute(BattleContext ctx) {


            if (!this.attacker.isAlive()){
                return;
            }

            if (!this.target.isAlive() && ctx.isFinished()){
                ctx.scheduleEvent(
                        new AutoAttackEvent(
                                this.attacker,
                                TargetSystem.getNextTarget(ctx, this.attacker), ctx.getNow()
                                )
                );
                return;
            } else {
                DamageSystem.applyBasicAttackDamage(ctx, attacker, target);
            }

            if (!target.isAlive() && !ctx.isFinished())
                this.target = TargetSystem.getNextTarget(ctx, attacker);
            // Next auto attack will be 1600 (1.6 seg) - 10% of the agility
            long nextAA = (ctx.getNow() + (long) (1600 - (attacker.getStats().getAgility() * 0.1)));

            //todo implementar uma alteração de target quando o alvo morre, quando morre remover eventos futuros que realacionam esse heroi
            //if (!u.isAlive())



        ctx.scheduleEvent(new AutoAttackEvent(attacker, target, nextAA ));
    }
}
