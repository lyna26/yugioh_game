package com.example.yugioh.card;

import com.example.yugioh.duel.Effect;


import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

public abstract class Card extends javafx.scene.image.ImageView implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String description;
    private String image;
    private List<String> types;
    private List<Effect> effects;

    /**
     * This constructor is used to generate a card from data exported from database
     * @param card card Info's from database
     */
    public Card(ResultSet card)
    {
        try {
            id = card.getInt("id");
            name = card.getString("name");
            //Charset def = Charset.defaultCharset();
            //byte[] bytes = card.getString("desc").getBytes("UTF-8");
            //String desc = new String(bytes , def.name());
            description = card.getString("desc");
            image = card.getString("image_url");
            makeTypes(card.getString("type"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String getName() {
        return name;
    }
    public int getCardId() {
        return id;
    }
    public String getDesc() {
        return description;
    }
    public String getCardImage() {
        return image;
    }
    @Override
    public String toString() {
        return this.name + "\n" + this.id+ "\n" + this.description;
    }
    public void makeTypes(String types)
    {
        String[] typeList = types.split(" ");
        setTypes(Arrays.asList(typeList));
    }
    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<Effect> getEffects() {
        return effects;
    }
    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }
}