package org.example.tamemon;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private MonsterStorage monsters = new MonsterStorage();
    private ArrayList<ItemStorage> items = new ArrayList<ItemStorage>();
    private int level;

    public Player(String name) {
        this.name = name;
        this.level = 1;
    }
}
