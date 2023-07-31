package org.example.tamemon.Monsters;

import org.example.tamemon.Item;
import org.example.tamemon.Move;

import java.util.Arrays;
import java.util.List;

public abstract class Monster {
    protected String name;
    protected int id;
    protected Move[] moves = new Move[2];
    protected String type; //
    protected int experience;
    protected int level;
    protected Item[] items = new Item[2];
    protected List<Integer> baseStats; // hp, atk, def, acc, speed
    protected List<Integer> stats;
    protected int icon;

    public Monster(String name, int id) {
        this.name = name;
        experience = 0;
        level = 1;
        this.id = id;
        baseStats = Arrays.asList(1,1,1,1);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<Integer> getStats() {
        return baseStats;
    }

    public int getID() {
        return id;
    }

    public int getIcon() {
        return icon;
    }

    public void calculateStats() {
        switch (type){
            case "grass":
                stats.set(0, (baseStats.get(0) + level * 10));
                stats.set(1, (baseStats.get(1) + level * 2));
                stats.set(2, (baseStats.get(2) + level * 2));
                stats.set(3, (baseStats.get(3) + level * 2));
                stats.set(4, (baseStats.get(1) + level * 3));
                break;

            case "fire":
                stats.set(0, (baseStats.get(0) + level * 8));
                stats.set(1, (baseStats.get(1) + level * 4));
                stats.set(2, (baseStats.get(2) + level));
                stats.set(3, (baseStats.get(3) + level * 2));
                stats.set(4, (baseStats.get(1) + level * 2));
                break;
            case "water":
                stats.set(0, (baseStats.get(0) + level * 12));
                stats.set(1, (baseStats.get(1) + level * 2));
                stats.set(2, (baseStats.get(2) + level * 3));
                stats.set(3, (baseStats.get(3) + level * 2));
                stats.set(4, (baseStats.get(1) + level));
                break;
        }
    }

    public void setLevel(int level) {
        this.level = level;
        calculateStats();
    }
}
