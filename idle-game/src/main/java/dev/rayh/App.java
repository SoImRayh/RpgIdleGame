package dev.rayh;

import dev.rayh.game.domain.battle.Battle;
import dev.rayh.game.services.BattleService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Battle battle = new Battle();
        battle.setC1(TempBuilder.C1);
        BattleService bs = new BattleService();

        bs.runBlattle(Battle b)
    }
}
