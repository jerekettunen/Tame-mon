package org.example.tamemon.Monsters;

import org.example.tamemon.R;

import java.util.Arrays;

public class Kroki extends Monster {

    public Kroki(int id) {
        super("Kroki", id);
        icon = R.drawable.mon2_0;
        baseStats = Arrays.asList(25,2,3,2,1); // hp, atk, def, acc, speed
        type = "water";
        calculateStats();
    }
}
