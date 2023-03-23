package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;

public abstract class Phase implements IPhase{
    private com.example.yugioh.enums.Phase phaseName;
    private Turn turn;

    public Phase(com.example.yugioh.enums.Phase phaseName, Turn turn) {
        this.phaseName = phaseName;
        this.turn = turn;
    }

    public Turn getTurn()
    {
        return turn;
    }

    public com.example.yugioh.enums.Phase getPhaseName()
    {
        return phaseName;
    }
}
