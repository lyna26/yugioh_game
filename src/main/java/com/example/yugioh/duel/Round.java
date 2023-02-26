package com.example.yugioh.duel;

import com.example.yugioh.enums.Phase;
import com.example.yugioh.player.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Round {
    Player player1;
    Player player2;
    private Phase phase;

    boolean isPlayer1Turn;

    public Round(Player player1, Player player2, boolean isPlayer1Turn) throws IOException {
        System.out.println("round !");
        this.player1 = player1;
        this.player2 = player2;
        this.phase = Phase.DRAW;
        this.isPlayer1Turn = isPlayer1Turn;

        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/java/com/example/yugioh/interfaces/Duel.fxml").toURI().toURL());
        Parent root  = fxmlLoader.load();
    }

    public Player getCurrentUser()
    {
        if(isPlayer1Turn == true)
        {
            return player1;
        }
        else
        {
            return player2;
        }
    }

    public void play() {
        System.out.println("play");
        Player currentPlayer = getCurrentUser();

        switch (phase)
        {
            case DRAW:
                break;
            case STANDBY:
                break;
            case MAIN1:
                break;
            case BATTLE:
                break;
            case MAIN2:
                break;
            case END:
                break;
        }
    }

    public void drawPhase()
    {
        System.out.println("is draw phase");
    }

    public void mainPhase()
    {
        System.out.println("is main phase");
    }

    public void battlePhase()
    {
        System.out.println("is battle phase");
    }

    public void endPhase()
    {
        System.out.println("end phase");
    }
}
