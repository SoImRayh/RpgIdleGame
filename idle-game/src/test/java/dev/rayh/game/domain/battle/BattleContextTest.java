package dev.rayh.game.domain.battle;

import dev.rayh.TempBuilder;
import junit.framework.TestCase;
import org.junit.Test;
import org.openjdk.jol.vm.VM;

public class BattleContextTest extends TestCase {


    public void testingObjectSize(){
        BattleContext b = new BattleContext(TempBuilder.getMeleeWithJustAutoAttack("h1"), TempBuilder.getMeleeWithJustAutoAttack("h2"));


        System.out.println(VM.current().sizeOf(b));
    }

}