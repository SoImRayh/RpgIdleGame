package dev.rayh.game.domain.hero;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    private String name;
    private Stats stats;
    private List<Skill> skills;
}
