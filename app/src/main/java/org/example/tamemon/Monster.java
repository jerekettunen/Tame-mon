package org.example.tamemon;

import java.sql.Array;

public class Monster {
    private String name;
    private int id;
    private Move[] moves = new Move[4];
    private int type; // Could make string
    private int experience;
    private int level;
    private Item[] items = new Item[2];
    private int[] stats = new int[4]; // atk, def, acc, speed

    public Monster(int id) {
        name = "test";
        experience = 0;
        level = 1;
        this.id = id;
        for (int i = 0; i <= 3; i++) {
            stats[i] = i;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int[] getStats() {
        return stats;
    }

    public int getID() {
        return id;
    }
}
