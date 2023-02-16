package com.example.yugioh.application;


import com.example.yugioh.player.Player;

import java.io.*;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String fileToSave = "game.ser";
    private  static Game gameInstance ;
    private Player p;
    private Game() {}
    public static Game getInstance()
    {
        if (gameInstance == null)
        {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    public Player getPlayer()
    {
        return p;
    }

    public void setPlayer(Player player)
    {
        this.p = player;
    }
    public static void Load() throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(fileToSave);
            ObjectInputStream ois = new ObjectInputStream(fis);
            gameInstance = (Game) ois.readObject();
            ois.close();
            fis.close();
    }
    public static void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(fileToSave);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(gameInstance);
        oos.close();
        fos.close();
    }
}
