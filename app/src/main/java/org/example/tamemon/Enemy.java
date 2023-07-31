package org.example.tamemon;

import org.example.tamemon.Monsters.Monster;
import org.example.tamemon.Monsters.MonsterStorage;

import java.util.List;

public class Enemy {
    private int level;
    private MonsterStorage monsters;

    public Enemy(int level, int teamSize) {
        this.level = level;
        for (int i=0; i<=teamSize; i++){
            monsters.addNewMonster(level);
        }
    }
}
