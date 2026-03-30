package dev.rayh.game.domain;

import java.util.List;

import dev.rayh.game.engine.BattleContext;
import dev.rayh.game.runtime.BattleUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Skill {
    private String id;
    private long cooldown;
    private int energyCost;
    private SkillType type;
    private List<Effect> effects;

    public abstract void execute(BattleContext context, BattleUnit caster);
}
