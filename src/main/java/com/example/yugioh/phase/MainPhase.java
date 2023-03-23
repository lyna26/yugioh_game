package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;

public class MainPhase extends com.example.yugioh.phase.Phase {
    public MainPhase(com.example.yugioh.enums.Phase phaseName, Turn turn) {
        super(phaseName, turn);
    }

    @Override
    public void play() {
        System.out.println(this.getPhaseName().toString());
    }
}
