package org.example.tamemon;

import org.example.tamemon.Monsters.Monster;
import org.example.tamemon.Monsters.MonsterStorage;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
    private String name;
    private int wins, losses;
    private MonsterStorage monsters = new MonsterStorage();
    // private ItemStorage items = new ItemStorage();
    private int level;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        wins = 0;
        losses = 0;

    }

    public String getName() {
        return name;
    }

    public MonsterStorage getMonsters() {
        return monsters;
    }


    public void addMonster() {
        monsters.addNewMonster();
    }

    public List<Monster> getMonstersList() {
        return monsters.getList();
    }

    public int getMonsterQty() {
        return monsters.getQty();
    }

    public void addLoss() { losses++;
    }

    public void addWin() { wins++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
