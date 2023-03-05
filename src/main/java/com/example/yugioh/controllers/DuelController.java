package com.example.yugioh.controllers;

import com.example.yugioh.application.Game;
import com.example.yugioh.card.CardFactory;
import com.example.yugioh.deck.Deck;
import com.example.yugioh.deck.DeckSet;
import com.example.yugioh.deck.DeckType;
import com.example.yugioh.duel.Duel;
import com.example.yugioh.engines.DataBaseEngine;
import com.example.yugioh.enums.PhaseEnum;
import com.example.yugioh.phase.BattlePhase;
import com.example.yugioh.phase.DrawPhase;
import com.example.yugioh.phase.EndPhase;
import com.example.yugioh.phase.MainPhase;
import com.example.yugioh.player.Player;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
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

    public Deck createDeck(String deckName) throws SQLException, IOException {
        Deck deck = new Deck(DeckType.MAIN);
        ResultSet deckCardsRes = DataBaseEngine.selectCards(deckName);
        while(deckCardsRes.next())
        {
            deck.getCardList().add(CardFactory.createCard(deckCardsRes));
        }
        return deck;
    }

    public Duel getDuel()
    {
        return duel;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Player player = new Player("Lyna");
        Player p2 = new Player("Lili");

        DeckSet p1DeckSet = new DeckSet("deck1");
        DeckSet p2DeckSet = new DeckSet("deck2");

        player.getDecks().add(p1DeckSet);
        p2.getDecks().add(p2DeckSet);

        player.setDuelDeck (player.getDecks().get(0));
        p2.setDuelDeck (p2.getDecks().get(0));

        try {
            player.getDuelDeck().setMainDeck(createDeck("kuriboh"));
            p2.getDuelDeck().setMainDeck(createDeck("kuriboh"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        duel = new Duel(player, p2);

    }

    public void main1Phase() {
        duel.getCurrentTurn().setCurrentPhase(new MainPhase(PhaseEnum.MAIN1, duel.getCurrentTurn()));
    }

    public void main2Phase() {
        duel.getCurrentTurn().setCurrentPhase(new MainPhase(PhaseEnum.MAIN2, duel.getCurrentTurn()));
    }

    public void endPhase() {
        duel.getCurrentTurn().setCurrentPhase(new BattlePhase(duel.getCurrentTurn()));
    }

    public void drawPhase() {
        duel.getCurrentTurn().setCurrentPhase(new DrawPhase(duel.getCurrentTurn()));
    }

    public void battlePhase() {
        duel.getCurrentTurn().setCurrentPhase(new EndPhase(duel.getCurrentTurn()));
    }

    public void setDuel(Duel duel) {
        this.duel = duel;
    }
}
