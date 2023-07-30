package org.example.tamemon.Monsters;

import org.example.tamemon.R;

import java.util.Arrays;

public class Fordin extends Monster{

    public Fordin(int id) {
        super("Fordin", id);
        icon = R.drawable.mon2_0;
        stats = Arrays.asList(1,1,1,1); // atk, def, acc, speed
        type = "fire";
    }
}
