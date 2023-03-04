package com.example.yugioh.duel;

import com.example.yugioh.enums.PhaseEnum;
import com.example.yugioh.phase.DrawPhase;
import com.example.yugioh.phase.IPhase;
import com.example.yugioh.player.Player;

import java.io.IOException;

public class Turn {
    private IPhase phase;

    private Duel duel;

    public Turn(Duel duel) throws IOException {
        System.out.println("round !");
        this.duel = duel;
        this.phase = new DrawPhase(PhaseEnum.DRAW);
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

    public void play() {
        System.out.println("play round");

        Player currentPlayer = getCurrentUser();

        switch (phase)
        {
            case DRAW:
                drawPhase();
                break;
            case STANDBY:
                break;
            case MAIN1:
                break;
            case BATTLE:
                break;
            case MAIN2:
                break;
            case END:
                break;
        }

    }

    public void drawPhase()
    {
        this.getCurrentUser().drawCard();
        System.out.println("is draw phase");
    }

    public void mainPhase()
    {
        System.out.println("is main phase");
    }

    public void battlePhase()
    {
        System.out.println("is battle phase");
    }

    public void endPhase()
    {
        System.out.println("end phase");
    }

    public void setCurrentPhase(IPhase phase) {
        this.phase = phase;
    }
}
