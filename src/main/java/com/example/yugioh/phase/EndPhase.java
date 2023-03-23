package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;

public class EndPhase extends com.example.yugioh.phase.Phase {

    public EndPhase(Turn turn) {
        super(com.example.yugioh.enums.Phase.END, turn);
    }
    @Override
    public void play(){
        System.out.println("EndPhase...");
        this.getTurn().getDuel().switchTurn();
    }
}
