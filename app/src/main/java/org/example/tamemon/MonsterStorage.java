package org.example.tamemon;

import java.util.HashMap;

public class MonsterStorage {
    private static int id = 0;
    private HashMap<Integer, Monster> monsters = new HashMap<>();


    public MonsterStorage() {
    }

    public void addNewMonster() {
        monsters.put(id, new Monster());
    }
}
