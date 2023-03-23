package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a ritual monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class RitualMonster extends MonsterCard{
    public RitualMonster(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "RitualMonster{}";
    }
}
