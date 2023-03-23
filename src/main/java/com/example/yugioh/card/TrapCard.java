package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a trap card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link Card} class.
 */
public class TrapCard extends Card{

    public TrapCard(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "TrapCard{}";
    }
}
