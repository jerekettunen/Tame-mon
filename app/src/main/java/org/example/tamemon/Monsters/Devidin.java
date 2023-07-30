package org.example.tamemon.Monsters;

import org.example.tamemon.R;

import java.util.Arrays;

public class Devidin extends Monster{

    public Devidin(int id) {
        super("Devidin", id);
        icon = R.drawable.mon1_0;
        stats = Arrays.asList(1,1,1,1); // atk, def, acc, speed
        type = "grass";
    }
}
