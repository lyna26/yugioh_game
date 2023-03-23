package com.example.yugioh.cardFactories;

import com.example.yugioh.card.Card;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICardFactory {
    Card createCard(ResultSet card) throws SQLException;
}
