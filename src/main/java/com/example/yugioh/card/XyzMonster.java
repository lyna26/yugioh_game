package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing an XYZ monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class XyzMonster extends MonsterCard{
    int rank;
    public XyzMonster(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "XYZMonster{" +
                "rank=" + rank +
                '}';
    }
}
