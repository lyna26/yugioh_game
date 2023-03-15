package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.PhaseEnum;

public class SpPhase extends Phase {
    public SpPhase(Turn turn)
    {
        super(PhaseEnum.STANDBY, turn);
    }

    @Override
    public void play()
    {
        System.out.println("Sp");
    }
}
