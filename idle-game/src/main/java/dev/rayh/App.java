package dev.rayh;


import dev.rayh.game.domain.Hero;
import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.engine.BattleEngine;
import dev.rayh.game.engine.BattleInitializer;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BattleEngine engine = new BattleEngine();

        System.out.println("iniciando!");
        List<Hero> ta = TempBuilder.getTeamWithOnlyOneHero("TA");
        List<Hero> tB = TempBuilder.getTeamWithOnlyOneHero("TB");

        BattleContext context = BattleInitializer.init(ta, tB);

        engine.run(context);

    }
}
