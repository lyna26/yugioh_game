package com.example.yugioh.application;

import com.example.yugioh.player.Player;
import java.io.*;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE_TO_SAVE = "game.ser";
    private  static Game gameInstance ;
    private Player player;
    private Game() {}

    public static Game getInstance() {
        if (gameInstance == null)
        {
            synchronized (Game.class) {
                if (gameInstance == null)
                {
                    gameInstance = new Game();
                }
            }
        }
        return gameInstance;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {

        this.player = player;
    }

    /**
     * This function is used to load the game instance
     */
    public static void load() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream(FILE_TO_SAVE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            gameInstance = (Game) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
    }

    /**
     * This function is used to save the game instance
     */
    public static void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_TO_SAVE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(gameInstance);
        oos.close();
        fos.close();
    }
}
