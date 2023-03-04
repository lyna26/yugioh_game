package com.example.yugioh.controllers;

import com.example.yugioh.application.Game;
import com.example.yugioh.card.CardFactory;
import com.example.yugioh.deck.Deck;
import com.example.yugioh.deck.DeckType;
import com.example.yugioh.duel.Duel;
import com.example.yugioh.engines.DataBaseEngine;
import com.example.yugioh.enums.PhaseEnum;
import com.example.yugioh.phase.MainPhase;
import com.example.yugioh.player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DuelController implements Initializable
{
    @FXML
    private Button draw;
    @FXML
    private Button sp;
    @FXML
    private Button main1;
    @FXML
    private Button battle;
    @FXML
    private Button main2;
    @FXML
    private Button end;

    private Duel duel;

    public Duel getDuel()
    {
        return duel;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Player player = Game.getInstance().getPlayer();
        player.setLP(8000);
        player.setDuelDeck (player.getDecks().get(0));
        Deck d = new Deck(DeckType.MAIN);
        try {
            ResultSet res = DataBaseEngine.selectCards("Magician");

            while (res.next()) {
                System.out.println("a result");
                d.getCardList().add(CardFactory.createCard(res));
            }
        }
        catch(SQLException error)
        {
            System.out.println("error");
        }
        player.getDuelDeck().setMainDeck(d);

        Player player2 = new Player("Lili");
        player2.setLP(8000);
        duel = new Duel(player, player2 );
    }

    public void main1Phase() {
        duel.getCurrentRound().setCurrentPhase(new MainPhase(PhaseEnum.MAIN1));
        turn.play();
    }

    public void main2Phase() {
        turn.setCurrentPhase(PhaseEnum.MAIN2);
        turn.play();
    }

    public void endPhase() {
        turn.setCurrentPhase(PhaseEnum.END);
        turn.play();
    }

    public void drawPhase() {
        turn.setCurrentPhase(PhaseEnum.DRAW);
        turn.play();
    }

    public void battlePhase() {
        turn.setCurrentPhase(PhaseEnum.BATTLE);
        turn.play();
    }
}
