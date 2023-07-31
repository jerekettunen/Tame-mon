package org.example.tamemon.Monsters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonsterStorage {
    private static int id = 0;
    private HashMap<Integer, Monster> monsters = new HashMap<>();


    public MonsterStorage() {
    }

    public void addNewMonster() {
        Monster monster = getRandomMonster();
        monsters.put(id++, monster);
    }

    public void addNewMonster(int level) {
        Monster monster = getRandomMonster();
        monster.setLevel(level);
    }

    private Monster getRandomMonster() {
        Monster monster = null;
        int range = 3; // amount of unique monsters available to 'tame'
        int result = (int)(Math.random() * range)+1;

        switch(result) {
            case 1:
                monster = new Devidin(id);
                break;
            case 2:
                monster = new Kroki(id);
                break;
            case 3:
                monster = new Fordin(id);
                break;

        }
        return monster;
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
