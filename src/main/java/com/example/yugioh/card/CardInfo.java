package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardInfo {
    private String name;
    private String desc;
    private String race;
    private int atk;
    private int def;
    private int level;
    private int id;
    private String imageUrl;
    public CardInfo(ResultSet card) throws SQLException {
        this.name = card.getString("name");
        this.imageUrl = card.getString("image");
        this.id = card.getInt("id");
        this.desc = card.getString("desc");
        this.level = card.getInt("level");
        this.race = card.getString("race");
        this.atk = card.getInt("atk");
        this.def = card.getInt("def");
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getRace() {
        return race;
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

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.getRace() + "\n" + this.desc;
    }
}
