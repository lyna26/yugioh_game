package com.example.yugioh.cardFactories;

import com.example.yugioh.card.Card;
import com.example.yugioh.card.SpellCard;
import com.example.yugioh.cardFactories.ICardFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A factory class for creating SpellCard objects.
 */
public class SpellCardFactory implements ICardFactory {

    /**
     * Creates a new SpellCard object using the provided ResultSet.
     *
     * @param card the ResultSet containing the card data
     * @return a new MonsterCard object
     * @throws SQLException if there is an error retrieving the data from the ResultSet
     */
    @Override
    public Card createCard(ResultSet card) throws SQLException {
        return new SpellCard(card);
    }
}
