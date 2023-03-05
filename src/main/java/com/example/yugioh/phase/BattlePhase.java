package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.PhaseEnum;

public class BattlePhase extends Phase{

    public BattlePhase(Turn turn) {

        super(PhaseEnum.BATTLE.BATTLE, turn);
    }
    @Override
    public void play() {
        System.out.println("BATTLE PHASE...");

        this.setIsPlayed(true);

    }
}
