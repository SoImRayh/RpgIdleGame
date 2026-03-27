package dev.rayh;

import dev.rayh.game.domain.battle.BattleEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("iniciando!");
        BattleEngine engine = new BattleEngine();
        engine.start();
    }
}
