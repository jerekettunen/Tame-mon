package org.example.tamemon;

import org.example.tamemon.Monsters.Monster;

import java.util.List;

public class Helper {

    private static Helper singleton;
    private List<Monster> battleMonsters;

    public static Helper getInstance() {
        if (singleton == null) {
            singleton = new Helper();
        }
        return singleton;
    }

    private Enemy enemy;

    public Helper() {
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setBattleMonsters(List<Monster> battleMonsters) {
        this.battleMonsters = battleMonsters;
    }

    public List<Monster> getBattleMonsters() {
        return battleMonsters;
    }
}
