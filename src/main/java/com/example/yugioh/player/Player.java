package com.example.yugioh.player;

import com.example.yugioh.deck.DeckSet;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int LP = 8000;
    private List<DeckSet> decks;
    private DeckSet deulDeck;

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
}
