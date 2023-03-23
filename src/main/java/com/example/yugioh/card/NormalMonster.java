package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a normal monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class NormalMonster extends MonsterCard{
    public NormalMonster(ResultSet card) throws SQLException {
        super(card);
    }
    @Override
    public String toString() {
        return "NormalMonster{}";
    }
}
