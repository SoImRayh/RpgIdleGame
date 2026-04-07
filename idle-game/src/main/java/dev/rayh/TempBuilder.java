package dev.rayh;

import dev.rayh.game.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TempBuilder {
    static Random random = new Random();
    public static Hero getMeleeWithJustAutoAttack(String name_id){
        Random r = new Random();

        Hero hero = new Hero();
        hero.setBaseStats(new Stats((r.nextInt( 100) + 100),100,100,r.nextInt(1500),0.1,2));
        hero.setName(name_id);
        hero.setId(name_id.concat(String.valueOf(random.nextInt())));
        return hero;
    }


    public static List<Hero> getTeam(String teamName){
        List<Hero> l = new ArrayList<>(5);
        String name;
        for (int i = 0; i < 5; i++) {
            name = String.format("%s-h%s", teamName, i+1);
            l.add(getMeleeWithJustAutoAttack(name));
        }
        l.get(0).setName("Tank team "+ teamName);

        return l;
    }

    public static List<Hero> getTeamWithOnlyOneHero(String teamName){
        List<Hero> l = new ArrayList<>(5);
        l.add(getMeleeWithJustAutoAttack(teamName));

        return l;
    }
}