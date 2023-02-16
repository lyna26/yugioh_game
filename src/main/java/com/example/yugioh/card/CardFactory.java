package com.example.yugioh.card;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardFactory {
    public static Card createCard(ResultSet card) throws SQLException {

        String type = card.getString("type").split(" ")[0];

        Card cardR = switch( type.toLowerCase() ) {
            case "spell" -> new SpellCard(card);
            case "trap" -> new TrapCard(card);
            default -> new  MonsterCard(card);
        };
        return cardR;
    }

}
