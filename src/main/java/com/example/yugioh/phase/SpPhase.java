package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.Phase;

public class SpPhase extends com.example.yugioh.phase.Phase {
    public SpPhase(Turn turn)
    {
        super(Phase.STANDBY, turn);
    }

    @Override
    public void play()
    {
        System.out.println("Sp");
    }
}
