package org.example.tamemon;

public class Move {
    private String title;
    private int power;
    private int accuracy;
    private String type;
    private int kind;
    private int moveId;

    public Move(String title, int power, String type, int kind) {
        this.title = title;
        this.power = power;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public int getKind() {
        return kind;
    }
}
