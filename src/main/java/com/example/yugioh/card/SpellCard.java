package com.example.yugioh.card;

import java.sql.ResultSet;

/**
 * A class representing a spell card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link Card} class.
 */
public class SpellCard extends Card{
    public SpellCard(ResultSet card)
    {
        super(card);
    }

    @Override
    public String toString() {
        return "SpellCard{}";
    }
}
