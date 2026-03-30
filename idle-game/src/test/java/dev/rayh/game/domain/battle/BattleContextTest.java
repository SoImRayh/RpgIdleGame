package dev.rayh.game.domain.battle;

import dev.rayh.TempBuilder;
import dev.rayh.game.engine.BattleContext;
import junit.framework.TestCase;
import org.openjdk.jol.vm.VM;

public class BattleContextTest extends TestCase {


    public void testingObjectSize(){
        BattleContext b = new BattleContext(TempBuilder.getMeleeWithJustAutoAttack("h1"), TempBuilder.getMeleeWithJustAutoAttack("h2"));


        System.out.println(VM.current().sizeOf(b));
    }

}