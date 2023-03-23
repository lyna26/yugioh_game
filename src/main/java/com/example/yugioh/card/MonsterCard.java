package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class representing a monster card in the Yu-Gi-Oh! trading card game.
 * Extends the {@link Card} class.
 */
public class MonsterCard extends Card {
    private int atk;
    private int def;
    private int level;
    private String attribute;

    /**
     * Constructs a new MonsterCard object with the given data from a database ResultSet.
     *
     * @param card a ResultSet object containing the card data
     */
    public MonsterCard(ResultSet card) throws SQLException {
        super(card);
        try {
            this.atk = card.getInt("atk");
            this.def = card.getInt("def");
            this.level = card.getInt("level");
            this.attribute = card.getString("attribute");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getLevel() {
        return level;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "MonsterCard{" +
                "atk=" + atk +
                ", def=" + def +
                ", level=" + level +
                ", attribute='" + attribute + '\'' +
                '}';
    }
}