package org.example.tamemon;

import java.util.ArrayList;

public class PlayerStorage {
    private static PlayerStorage singleton;
    private int activePlayer;
    private ArrayList<Player> players = new ArrayList<>();
    public static PlayerStorage getInstance() {
        if (singleton == null) {
            singleton = new PlayerStorage();
        }
        return singleton;
    }

    public PlayerStorage() {
    }

    public void addPlayer(Player player) {
        players.add(player);
        activePlayer = getPosition(player);
    }

    public int getPosition(Player player) {
        return players.indexOf(player);
    }

    public Player getActivePlayer() {
        return players.get(activePlayer);
    }
}
