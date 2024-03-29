package com.example.yugioh.controllers;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.Phase;
import com.example.yugioh.phase.*;

import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class TurnController  {
    @FXML
    private Button draw;
    @FXML
    private Button sp;
    @FXML
    private Button main1;
    @FXML
    private Button battle;
    @FXML
    private Button main2;
    @FXML
    private Button end;
    @FXML
    VBox buttons;
    private Turn turn ;
    DuelController duelControl;

    public void setDuelControl(DuelController duelControl) {

        this.duelControl = duelControl;
    }

    public void handleDrawPhase(MouseEvent event) {
        System.out.println("draw phase handler");
        Button button = (Button) event.getSource();
        button.setDisable(true);
        turn.setCurrentPhase(new DrawPhase(turn.getDuel().getCurrentTurn()));
        turn.getCurrentPhase().play();
    }
    public void handleSpPhase(MouseEvent event) {
        System.out.println("Sp phase handler");
        Button button = (Button) event.getSource();
        button.setDisable(true);
        turn.setCurrentPhase(new SpPhase(turn.getDuel().getCurrentTurn()));
        turn.getCurrentPhase().play();
    }
    public void handleMain1Phase(MouseEvent event) {
        System.out.println("Main1 phase handler");
        turn.setCurrentPhase(new MainPhase(Phase.MAIN1, turn));
        turn.getCurrentPhase().play();
    }
    public void handleBattlePhase(Event event) {
        System.out.println("battle phase handler");
        Button button = (Button) event.getSource();
        disbaleButtonsBefore(button);
        turn.setCurrentPhase(new BattlePhase(turn));
        turn.getCurrentPhase().play();
    }
    public void handleMain2Phase(Event event) {
        System.out.println("main2 phase handler");
        Button button = (Button) event.getSource();
        disbaleButtonsBefore(button);
        turn.setCurrentPhase(new MainPhase(Phase.MAIN2, turn));
        turn.getCurrentPhase().play();
    }
    public void handleEndPhase(Event event) {
        System.out.println("end phase handler");
        Button button = (Button) event.getSource();
        button.setDisable(true);
        disbaleButtonsBefore(button);
        turn.setCurrentPhase(new EndPhase(turn));
        duelControl.startTurn();
    }
    public void disbaleButtonsBefore(Button button) {
        int currentIndex = buttons.getChildren().indexOf(button);
        int beforeIndex = currentIndex--;
        button = (Button) buttons.getChildren().get(beforeIndex);
        while (!button.isDisable())
        {
            button.setDisable(true);
            beforeIndex--;
            button = (Button) buttons.getChildren().get(beforeIndex);
        }
    }

    public void resetButtons()
    {
        for (Node button : buttons.getChildren())
        {
            button.setDisable(false);
        }
    }

    public Button getDraw() {
        return draw;
    }
    public Button getSp() {
        return sp;
    }
    public Button getMain1() {
        return main1;
    }
    public void setMain1(Button main1) {
        this.main1 = main1;
    }
    public Button getBattle() {
        return battle;
    }
    public Button getMain2() {
        return main2;
    }
    public Button getEnd() {
        return end;
    }
    public Turn getTurn() {
        return turn;
    }
    public void setTurn(Turn currentTurn) {
        this.turn = currentTurn;
    }

}