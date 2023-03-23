package com.example.yugioh.deck;

import com.example.yugioh.enums.DeckType;

import java.io.Serializable;

public class DeckSet implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Deck mainDeck;
    private Deck extraDeck;
    private Deck sideDeck;

    public DeckSet(String name)
    {
        this.name = name;
        mainDeck = new Deck(DeckType.MAIN);
        extraDeck = new Deck(DeckType.EXTRA);
        sideDeck = new Deck(DeckType.SIDE);
    }

    public String getName() {
        return name;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public Deck getExtraDeck() {
        return extraDeck;
    }

    public Deck getSideDeck() {
        return sideDeck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public void setExtraDeck(Deck extraDeck) {
        this.extraDeck = extraDeck;
    }

    public void setSideDeck(Deck sideDeck) {
        this.sideDeck = sideDeck;
    }
}
