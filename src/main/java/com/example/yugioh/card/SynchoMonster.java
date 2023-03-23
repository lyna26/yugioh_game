package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a synchro monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class SynchoMonster extends MonsterCard{
    public SynchoMonster(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "SynchoMonster{}";
    }
}
