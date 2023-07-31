package org.example.tamemon;

import org.example.tamemon.Monsters.Monster;
import org.example.tamemon.Monsters.MonsterStorage;

import java.util.List;

public class Enemy {
    private int level;
    private MonsterStorage monsters;
    private List<Monster> monsterList;

    public Enemy(int level, int teamSize) {
        this.level = level;
        monsters = new MonsterStorage();
        for (int i=0; i<=teamSize; i++){
            monsters.addNewMonsterWithLvl(level);
        }
        monsterList = monsters.getList();
    }

    public int getLevel() {
        return level;
    }
}
