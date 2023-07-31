package org.example.tamemon.Monsters;

import org.example.tamemon.Move;
import org.example.tamemon.R;

import java.util.Arrays;

public class Fordin extends Monster{

    public Fordin(int id) {
        super("Fordin", id);
        icon = R.drawable.mon3_0;
        baseStats = Arrays.asList(19,4,1,2,2); // hp, atk, def, acc, speed
        type = "fire";
        calculateStats();
        moves.set(0,new Move((type + " punch"), 3, type, 0));
        moves.set(1, new Move("decrease attack",-1, "special", 1));
    }
}
