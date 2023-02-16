package com.example.yugioh.application;

import com.example.yugioh.card.Card;
import com.example.yugioh.card.CardFactory;
import com.example.yugioh.deck.DeckSet;
import com.example.yugioh.duel.TextParserEngine;
import com.example.yugioh.engines.DataBaseEngine;
import com.example.yugioh.player.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException, SQLException {
        Game.Load();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/java/com/example/yugioh/interfaces/MainMenu.fxml").toURI().toURL());
        Parent root  = fxmlLoader.load();
        primaryStage.setTitle("yugioh!");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}