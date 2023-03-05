package com.example.yugioh.player;

import com.example.yugioh.card.Card;
import com.example.yugioh.deck.Deck;
import com.example.yugioh.deck.DeckSet;
import com.example.yugioh.duel.Hand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<DeckSet> decks;
    private DeckSet duelDeck;
    private transient boolean isYourTurn;
    transient private int LP;
    transient private Hand hand;
    public DeckSet getDuelDeck() {return this.duelDeck;}
    public void setDuelDeck(DeckSet duelDeck) {
            this.duelDeck = duelDeck;
        }
    public Player(String name)
    {
        this.name = name;
        this.decks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLP() {
        return LP;
    }
    public List<DeckSet> getDecks() {
        return decks;
    }
    public void setLP(int LP) {
        this.LP = LP;
    }
    public void drawCard() {
        Deck main  = duelDeck.getMainDeck();
        if (main.getCardList().size() > 0)
        {
            Card card = main.removeFirstCard();
            hand.addCard(card);
        }
    }
    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
