package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a fusion monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class FusionMonster extends MonsterCard{
    private String fusionMaterial;


    public FusionMonster(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "FusionMonster{" +
                "fusionMaterial='" + fusionMaterial + '\'' +
                '}';
    }
}
