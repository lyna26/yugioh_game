package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.Phase;

public class BattlePhase extends com.example.yugioh.phase.Phase {

    public BattlePhase(Turn turn) {

        super(Phase.BATTLE, turn);
    }
    @Override
    public void play() {
        System.out.println("BATTLE PHASE...");
    }
}
