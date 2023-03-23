package com.example.yugioh.cardFactories;

import com.example.yugioh.card.Card;
import com.example.yugioh.card.TrapCard;
import com.example.yugioh.cardFactories.ICardFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A factory class for creating TrapCard objects.
 */
public class TrapCardFactory implements ICardFactory {

    /**
     * Creates a new TrapCard object using the provided ResultSet.
     *
     * @param card the ResultSet containing the card data
     * @return a new MonsterCard object
     * @throws SQLException if there is an error retrieving the data from the ResultSet
     */
    @Override
    public Card createCard(ResultSet card) throws SQLException {
        return new TrapCard(card);
    }
}
