package com.example.yugioh.duel;

import com.example.yugioh.player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Duel {
    private Player player1;
    private Player player2;
    private List<Turn> rounds;
    private boolean isPlayer1Turn;

    private int roundNumber;
    private Turn currentRound;
    public Duel(Player duelist, Player opponent)
    {
        this.player1 = duelist;
        this.player2 = opponent;
        this.rounds = new ArrayList<Turn>();
        this.isPlayer1Turn = true;
        this.roundNumber = 1;
    }

    public Player getPlayer1() {return player1;}

    public Player getPlayer2() {return player2;}

    public List<Turn> getRounds() {return rounds;}

    public boolean isPlayer1Turn() {return isPlayer1Turn;}

    public void switchTurn() {isPlayer1Turn = !isPlayer1Turn;}

    public Turn getCurrentRound()
    {
        return currentRound;
    }
    public void game() throws IOException
    {
        System.out.println("Starting the duel between" + player1.getName() + "and" + player2.getName());

        preparePlayer();

        while (!isGameOver())
        {
            Turn turn = new Turn(this);
            currentRound = turn;
            turn.play();
            rounds.add(turn);
            switchTurn();
        }
        end();
    }

    public void preparePlayer()
    {
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
        for (int i = 0; i < 5; i++)
        {
            player1.drawCard();
            player2.drawCard();
        }
    }
    public void end() {System.out.println();}

    public boolean isGameOver() {
        return player1.getLP()<= 0 || player2.getLP() <= 0;
    }
}
