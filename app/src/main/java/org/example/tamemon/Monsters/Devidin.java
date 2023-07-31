package org.example.tamemon.Monsters;

import org.example.tamemon.Move;
import org.example.tamemon.R;

import java.util.Arrays;

public class Devidin extends Monster{

    public Devidin(int id) {
        super("Devidin", id);
        icon = R.drawable.mon1_0;
        baseStats = Arrays.asList(22,2,2,2,3); // hp, atk, def, acc, speed
        type = "grass";
        calculateStats();
        moves.set(0,new Move((type + " punch"), 3, type, 0));
        moves.set(1, new Move("decrease speed",-1, "special", 4));
    }
}
