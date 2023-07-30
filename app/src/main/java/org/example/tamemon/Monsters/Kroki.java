package org.example.tamemon.Monsters;

import org.example.tamemon.R;

import java.util.Arrays;

public class Kroki extends Monster {

    public Kroki(int id) {
        super("Kroki", id);
        icon = R.drawable.mon2_0;
        stats = Arrays.asList(1,1,1,1); // atk, def, acc, speed
        type = "water";
    }
}
