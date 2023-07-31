package org.example.tamemon;

public class Move {
    private String title;
    private int power;
    private int accuracy;
    private String type;
    private int moveId;

    public Move(String title, int power, int accuracy, String type) {
        this.title = title;
        this.power = power;
        this.accuracy = accuracy;
        this.type = type;
    }
}
