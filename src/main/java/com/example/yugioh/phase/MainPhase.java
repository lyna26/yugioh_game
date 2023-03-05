package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.PhaseEnum;

public class MainPhase extends Phase{
    public MainPhase(PhaseEnum phaseName, Turn turn) {
        super(phaseName, turn);
    }

    @Override
    public void play() {
        System.out.println(this.getPhaseName().toString());
        this.setIsPlayed(true);
    }
}
