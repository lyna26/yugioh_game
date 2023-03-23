package com.example.yugioh.card;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a link monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class LinkMonster extends MonsterCard{
    private int likVal;
    private String linkArraws;

    public LinkMonster(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "LinkMonster{" +
                "likVal=" + likVal +
                ", linkArraws='" + linkArraws + '\'' +
                '}';
    }
}
