package com.example.yugioh.controllers;

import com.example.yugioh.card.CardFactory;
import com.example.yugioh.deck.Deck;
import com.example.yugioh.deck.DeckSet;
import com.example.yugioh.deck.DeckType;
import com.example.yugioh.duel.Duel;
import com.example.yugioh.duel.Turn;
import com.example.yugioh.engines.DataBaseEngine;
import com.example.yugioh.player.Player;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ResourceBundle;

public class DuelController implements Initializable
{
    private Duel duel;
    @FXML
    private AnchorPane turn;

    @FXML TurnController turnController;


    private Deck createDeck(String deckName) throws SQLException, IOException
    {
        Deck deck = new Deck(DeckType.MAIN);
        ResultSet deckCardsRes = DataBaseEngine.selectCards(deckName);
        while(deckCardsRes.next()) {deck.getCardList().add(CardFactory.createCard(deckCardsRes));}
        return deck;
    }
    private Duel simulateGame()
    {
        Player player = new Player("Lyna");
        Player opponent = new Player("Lili");

        DeckSet pDeckSet = new DeckSet("deck1");
        DeckSet opponentDeckSet = new DeckSet("deck2");

        player.getDecks().add(pDeckSet);
        opponent.getDecks().add(opponentDeckSet);

        player.setDuelDeck (player.getDecks().get(0));
        opponent.setDuelDeck (opponent.getDecks().get(0));

        try
        {
            player.getDuelDeck().setMainDeck(createDeck("kuriboh"));
            opponent.getDuelDeck().setMainDeck(createDeck("kuriboh"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Duel(player, opponent);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        duel = simulateGame();
        duel.play();
        startTurn();
    }
    public void startTurn()
    {
        Turn newTurn = new Turn(duel);
        duel.setCurrentTurn(newTurn);
        setTurn();
        turnController.getDraw().fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, null));
        turnController.getSp().fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, null));
        turnController.getMain1().fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, null));
    }
    public Duel getDuel() {return duel;}

    public void setTurn()
    {
        turnController.resetButtons();
        turnController.setTurn(duel.getCurrentTurn());
    }
}