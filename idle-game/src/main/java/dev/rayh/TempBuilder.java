package dev.rayh;

import java.util.List;

import dev.rayh.game.domain.Skill;
import dev.rayh.game.domain.Champion;
import dev.rayh.game.domain.Effect;
import dev.rayh.game.domain.EffectType;
import dev.rayh.game.domain.SkillType;
import dev.rayh.game.domain.StatType;

public enum TempBuilder {
    C1(new Champion("C1")),
    C2(new Champion("C2"));

    private Champion champion;

    private TempBuilder (Champion champion){
        this.champion = champion;
    }
}
