package com.example.yugioh.duel;

import com.example.yugioh.player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Duel {
    private Player player1;
    private Player player2;
    private List<Turn> turns;
    private boolean isPlayer1Turn;
    private Turn currentTurn;

    public Duel(Player duelist, Player opponent)
    {
        this.player1 = duelist;
        this.player2 = opponent;
        this.turns = new ArrayList<Turn>();
        isPlayer1Turn = true;
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public List<Turn> getTurns() {
        return turns;
    }
    public Turn getCurrentTurn() {
        return currentTurn;
    }
    public boolean isPlayer1Turn() {
        return isPlayer1Turn;
    }
    public void setCurrentTurn(Turn currentTurn) {
        if (this.currentTurn != null)
        {
            turns.add(this.currentTurn);
        }
        this.currentTurn = currentTurn;
    }
    public void play()
    {
        System.out.println("Starting the duel between" + player1.getName() + "and" + player2.getName());
        preparePlayer();
    }
    public void switchTurn() {isPlayer1Turn = !isPlayer1Turn;}
    public void preparePlayer()
    {
        setPlayerLP();
        shufflePlayersDeck();
        fillPlayerHands();
    }
    public void shufflePlayersDeck()
    {
        player1.getDuelDeck().getMainDeck().shuffle();
        player2.getDuelDeck().getMainDeck().shuffle();
    }
    public void fillPlayerHands()
    {
        player1.setHand(new Hand());
        player2.setHand(new Hand());

        for (int i = 0; i < 5; i++)
        {
            player1.drawCard();
            player2.drawCard();
        }
    }
    public void setPlayerLP()
    {
        player1.setLP(8000);
        player2.setLP(8000);
    }
    public void end() {
        System.out.println("END OF DUEL");
    }
    public boolean isDuelOver()
    {
        return player1.getLP()<= 0 || player2.getLP() <= 0;
    }
    public Player getCurrentUser()
    {
        if(isPlayer1Turn())
        {
            return player1;
        }
        return player2;
    }
}
