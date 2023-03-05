package tests;


import com.example.yugioh.card.CardFactory;
import com.example.yugioh.controllers.DuelController;
import com.example.yugioh.deck.Deck;
import com.example.yugioh.deck.DeckSet;
import com.example.yugioh.deck.DeckType;
import com.example.yugioh.duel.Duel;
import com.example.yugioh.engines.DataBaseEngine;
import com.example.yugioh.enums.PhaseEnum;
import com.example.yugioh.player.Player;
import de.saxsys.javafx.test.JfxRunner;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.util.WaitForAsyncUtils;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JfxRunner.class)
public class DuelTest {
    public Deck createDeck(String deckName) throws SQLException, IOException {
        Deck deck = new Deck(DeckType.MAIN);
        ResultSet deckCardsRes = DataBaseEngine.selectCards(deckName);
        while(deckCardsRes.next())
        {
            deck.getCardList().add(CardFactory.createCard(deckCardsRes));
        }
        return deck;
    }

    @Test
    public void DueT() throws IOException, SQLException {
        Player player = new Player("Lyna");
        Player p2 = new Player("Lili");

        DeckSet p1DeckSet = new DeckSet("deck1");
        DeckSet p2DeckSet = new DeckSet("deck2");

        player.getDecks().add(p1DeckSet);
        p2.getDecks().add(p2DeckSet);

        player.setDuelDeck (player.getDecks().get(0));
        p2.setDuelDeck (p2.getDecks().get(0));

        player.getDuelDeck().setMainDeck(createDeck("kuriboh"));
        p2.getDuelDeck().setMainDeck(createDeck("kuriboh"));


        FXMLLoader fxmlLoader = new FXMLLoader(new File("./src/main/java/com/example/yugioh/interfaces/Duel.fxml").toURI().toURL());
        Parent root  = fxmlLoader.load();
        DuelController dc = fxmlLoader.getController();
        dc.setDuel(new Duel(player,p2));

        Platform.runLater(() -> {
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root, 800, 800));
            primaryStage.show();
        });

        try {
            dc.getDuel().game();

            // Wait for the GUI to be shown
            WaitForAsyncUtils.waitForFxEvents();


            // Click on the "main1" button
            //clickOn("#main1");

            // Verify that the game has transitioned to the main phase 1
            assertEquals(PhaseEnum.MAIN1, dc.getDuel().getCurrentTurn().getCurrentPhase());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
