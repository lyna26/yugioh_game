package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.PhaseEnum;

public class EndPhase extends Phase {

    public EndPhase(Turn turn) {
        super(PhaseEnum.END, turn);
    }
    @Override
    public void play(){
        System.out.println("EndPhase...");
        this.getTurn().getDuel().switchTurn();
    }
}
