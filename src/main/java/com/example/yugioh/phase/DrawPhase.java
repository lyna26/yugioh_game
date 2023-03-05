package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.PhaseEnum;

public class DrawPhase extends Phase {
    public DrawPhase(Turn turn) {
        super(PhaseEnum.DRAW, turn);
    }

    @Override
    public void play() {
        System.out.println("DRAW PHASE");
        this.getTurn().getCurrentUser().drawCard();
    }
}
