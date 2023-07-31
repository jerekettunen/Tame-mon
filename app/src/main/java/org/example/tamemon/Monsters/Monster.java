package org.example.tamemon.Monsters;

import android.widget.TextView;

import org.example.tamemon.Item;
import org.example.tamemon.Move;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Monster implements Serializable {
    protected String name;
    protected int id;
    protected List<Move> moves;
    protected String type; //
    protected int experience;
    protected int level;
    protected Item[] items = new Item[2];
    protected List<Integer> baseStats; // hp, atk, def, acc, speed
    protected List<Integer> stats;
    protected List<Integer> battleModifiers;
    protected int icon;

    public Monster(String name, int id) {
        this.name = name;
        experience = 0;
        level = 1;
        this.id = id;
        stats = Arrays.asList(1,1,1,1,1);
        battleModifiers = Arrays.asList(0,0,0,0,0);
        moves = new ArrayList<>();
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


    public Move getMove(int i) {
        return moves.get(i);
    }

    public void moveAction(List<Integer> stats, Move move) {
        int kind = move.getKind();
        System.out.println("in MoveAct");
        System.out.println(kind);
        // attack first
        if (kind == 0){
            int damage;
            if (this.type == "grass" && move.getType() == "fire"){
                damage = move.getPower() + stats.get(1) * 2;
            } else if (this.type == "fire" && move.getType() == "water") {
                damage = move.getPower() + stats.get(1) * 2;
            } else if (this.type == "water" && move.getType() == "grass") {
                damage = move.getPower() + stats.get(1) * 2;
            } else {
                damage = move.getPower() + stats.get(1);
            }
            damage = damage - (getModifiedStats().get(2)/2);
            battleModifiers.set(0, battleModifiers.get(0)+damage);
        } else { //rest are modifiers
            battleModifiers.set(kind, battleModifiers.get(kind) - move.getPower());
            System.out.print("modified");
        }
    }

    public List<Integer> getModifiedStats() {
        List<Integer> modifiedStats = new ArrayList<>(5);
        for (int i = 0 ; i < stats.size(); i++){
            modifiedStats.add(stats.get(i)-battleModifiers.get(i));
        }
        return modifiedStats;
    }
}
