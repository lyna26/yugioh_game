package com.example.yugioh.card;

import com.example.yugioh.duel.Effect;
import com.example.yugioh.duel.TextParserEngine;
import
        org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This abstract class represents a Yu-Gi-Oh card.
 * It contains common attributes and methods that are shared by all types of cards.
 */
public abstract class Card extends javafx.scene.image.ImageView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Card.class.getName());
    private int id;
    private String name;
    private String description;
    private String image;
    private List<String> types;
    private List<Effect> effects;

    /**
     * Constructor used to generate a card from data exported from a database.
     * @param card  ResultSet containing card information.
     * @param types
     * @throws SQLException if there's an error retrieving data from the ResultSet.
     */
    public Card(ResultSet card)
    {
        try {
            this.id = card.getInt("id");
            this.name = card.getString("name");
            this.description = card.getString("desc");
            this.image = card.getString("image_url");
            this.types = parseTypeList(card.getString("type"));
        } catch (SQLException exception)
        {
            logger.log(Level.SEVERE, "Failed to create card from ResultSet", exception);
        }
    }

    public String getName() {
        return name;
    }

    public int getCardId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCardImage() {
        return image;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {

        return this.name + "\n" + this.id+ "\n" + this.description;
    }

    /**
     * Parses a string of types and sets the types of this card accordingly.
     * The types are expected to be separated by a space character.
     *
     * @param types a string of types to be parsed and set for this card
     * @throws NullPointerException if the input string is null
     */
    public List<String> parseTypeList(@NotNull String types)
    {
        String[] separator = {" "};
        String[] typeList = types.split(Arrays.toString(separator));
        return Arrays.asList(typeList);
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }
/*
    public void makeEffects(String effects) throws UnsupportedEncodingException {
        setEffects(TextParserEngine.addTagsTo(this));
    }*/
}