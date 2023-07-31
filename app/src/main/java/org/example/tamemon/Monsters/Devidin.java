package org.example.tamemon.Monsters;

import org.example.tamemon.R;

import java.util.Arrays;

public class Devidin extends Monster{

    public Devidin(int id) {
        super("Devidin", id);
        icon = R.drawable.mon1_0;
        baseStats = Arrays.asList(22,2,2,2,3); // hp, atk, def, acc, speed
        type = "grass";
        calculateStats();
    }
}
