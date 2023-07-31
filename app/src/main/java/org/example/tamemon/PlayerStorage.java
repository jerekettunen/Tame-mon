package org.example.tamemon;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PlayerStorage {
    private static final String FILENAME = "player_data";
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

    public void savePlayers(Context context){
        try{
            ObjectOutputStream dataWriter = new ObjectOutputStream(context.openFileOutput(FILENAME,context.MODE_PRIVATE));
            dataWriter.writeObject(players);
            dataWriter.close();

        } catch(IOException e){
            System.out.println("Virhe tallennuksessa");
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream dataReader = new ObjectInputStream(context.openFileInput(FILENAME));
            players = (ArrayList<Player>) dataReader.readObject();
            dataReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei ole vielä olemassa");
        } catch (IOException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
        } catch (ClassNotFoundException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
        }
    }
}
