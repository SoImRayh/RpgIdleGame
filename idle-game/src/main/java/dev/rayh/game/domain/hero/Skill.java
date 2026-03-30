package dev.rayh.game.domain.hero;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    private String name;
    private int energyCost;
    private int cooldown;
    private SkillType type;
    private List<Effect> effects;
}
