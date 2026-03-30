package dev.rayh.game.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    private String id;
    private String name;
    private Stats baseStats;
    private List<Skill> skills;
}
