package org.example.tamemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonsterStorage {
    private static int id = 0;
    private HashMap<Integer, Monster> monsters = new HashMap<>();


    public MonsterStorage() {
    }

    public void addNewMonster() {
        monsters.put(id++, new Monster(id));
    }

    public List<Monster> getList() {
        return new ArrayList<Monster>(monsters.values());
    }

    public int getQty() {
        return monsters.size();
    }

    public void removeMonsterValue(int key) {
        monsters.remove(key);
    }
}
