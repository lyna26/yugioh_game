package com.example.yugioh.card;

import com.fasterxml.jackson.databind.JsonNode;

import java.sql.ResultSet;
import java.util.List;

public class MonsterCard extends Card {
    private int atk;
    private int def;
    private int level;
    private String attribute;

    /**
     * This constructor is used to generate a monster card from data exported from database
     */
    public MonsterCard(ResultSet card) {
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
}