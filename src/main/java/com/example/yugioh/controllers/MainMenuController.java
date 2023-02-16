package com.example.yugioh.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainMenuController {
    public Parent getInterface (String interfacename) throws IOException
    {
        String interfacePath = "./src/main/java/com/example/yugioh/interfaces/" + interfacename;
        FXMLLoader fxmlLoader = new FXMLLoader(new File(interfacePath).toURI().toURL());
        Parent root  = fxmlLoader.load();
        return root;
    }

    @FXML
    private void goToDeckBuilder(ActionEvent event) throws IOException {

        Parent view = getInterface("DeckMenu.fxml");
        Scene sc = new Scene(view,1280,720);
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void goToDuel(ActionEvent event) throws IOException {

        Parent view = getInterface("DuelInterface.fxml");
        Scene sc = new Scene(view,1280,720);
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setScene(sc);
        s.show();
    }
}
