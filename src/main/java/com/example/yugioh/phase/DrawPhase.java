package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.Phase;

public class DrawPhase extends com.example.yugioh.phase.Phase {
    public DrawPhase(Turn turn) {
        super(Phase.DRAW, turn);
    }

    @Override
    public void play() {
        System.out.println("DRAW PHASE");
        this.getTurn().getCurrentUser().drawCard();
    }
}
