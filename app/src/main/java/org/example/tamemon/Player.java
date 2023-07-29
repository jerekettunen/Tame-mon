package org.example.tamemon;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private MonsterStorage monsters = new MonsterStorage();
    private ItemStorage items = new ItemStorage();
    private int level;

    public Player(String name) {
        this.name = name;
        this.level = 1;

    }

    public String getName() {
        return name;
    }

    public MonsterStorage getMonsters() {
        return monsters;
    }

    public ItemStorage getItems() {
        return items;
    }

    public void addMonster() {
        monsters.addNewMonster();
    }
}
