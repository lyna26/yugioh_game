package tests;

import com.example.yugioh.card.Card;
import com.example.yugioh.card.CardFactory;
import com.example.yugioh.duel.TextParserEngine;
import com.example.yugioh.engines.DataBaseEngine;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

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
    void addTagsTo() throws SQLException {
        ResultSet res = DataBaseEngine.selectCardById("4064005");

        while(res.next()) {
            Card c = CardFactory.createCard(res);
            TextParserEngine.addTagsTo(c);
            System.out.println(c.toString());
        }
    }
}