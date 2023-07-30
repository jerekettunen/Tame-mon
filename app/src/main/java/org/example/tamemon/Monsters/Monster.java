package org.example.tamemon.Monsters;

import org.example.tamemon.Item;
import org.example.tamemon.Move;

import java.sql.Array;
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
    protected List<Integer> stats; // atk, def, acc, speed
    protected int icon;

    public Monster(String name, int id) {
        this.name = name;
        experience = 0;
        level = 1;
        this.id = id;
        stats = Arrays.asList(1,1,1,1);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<Integer> getStats() {
        return stats;
    }

    public int getID() {
        return id;
    }

    public int getIcon() {
        return icon;
    }
}
