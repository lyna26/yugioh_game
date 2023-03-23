package com.example.yugioh.card;

import kotlin.contracts.Effect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * A class representing a pendulum monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link MonsterCard} class.
 */
public class PendulumMonster extends MonsterCard{
    int scale;
    List<Effect> monsterEffect;
    List<Effect> spellEffect;

    public PendulumMonster(ResultSet card) throws SQLException {
        super(card);
    }

    @Override
    public String toString() {
        return "PendulumMonster{" +
                "scale=" + scale +
                ", monsterEffect=" + monsterEffect +
                ", spellEffect=" + spellEffect +
                '}';
    }
}
