package com.example.yugioh.duel;

import com.example.yugioh.enums.PhaseEnum;
import com.example.yugioh.phase.DrawPhase;
import com.example.yugioh.phase.Phase;
import com.example.yugioh.player.Player;

import java.io.IOException;

import java.util.concurrent.CountDownLatch;

public class Turn {
    private Phase phase;
    private Duel duel;
    private final CountDownLatch endTurnLatch;


    public Turn(Duel duel) throws IOException {
        this.duel = duel;
        Player currentPlayer = getCurrentUser();
        this.phase = new DrawPhase(this);
        endTurnLatch = new CountDownLatch(1);
    }

    public void run() {
        // Do something
        phase.play();


        while (! (phase.getPhaseName() == PhaseEnum.END) ){

            if( ! phase.isPlayed())
            {
                phase.play();
            }
        }

        try {
            endTurnLatch.await();
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        }
    }

    public Player getCurrentUser()
    {
        if(duel.isPlayer1Turn())
        {
            return duel.getPlayer1();
        }
        else
        {
            return duel.getPlayer2();
        }
    }

    public void playPhase() {
        phase.play();
    }

    public void endTurn() {
        endTurnLatch.countDown();
    }
    public PhaseEnum getCurrentPhase() {
        return phase.getPhaseName();
    }
    public void setCurrentPhase(Phase phase) {
        this.phase = phase;
    }
}
