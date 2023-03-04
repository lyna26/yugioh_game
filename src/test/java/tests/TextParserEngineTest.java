package tests;

import com.example.yugioh.card.Card;
import com.example.yugioh.card.CardFactory;
import com.example.yugioh.duel.TextParserEngine;
import com.example.yugioh.engines.DataBaseEngine;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;


class TextParserEngineTest {

    @Test
    void isChainEffect() {
    }

    @Test
    void analyseResolution() {
    }

    @Test
    void analyseActivation() {
    }

    @Test
    void analyseCondition() {
    }

    @Test
    void analyseSimpleText() {
    }

    @Test
    void analyseSentence() {
    }

    @Test
    void addTagsTo() throws SQLException, UnsupportedEncodingException {
        ResultSet res = DataBaseEngine.selectCardById("64591429");

        while(res.next()) {
            Card c = CardFactory.createCard(res);
            TextParserEngine.addTagsTo(c);

        }
    }
}