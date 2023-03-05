package com.example.yugioh.phase;

import com.example.yugioh.duel.Turn;
import com.example.yugioh.enums.PhaseEnum;

public abstract class Phase implements IPhase{
    private PhaseEnum phaseName;
    private Turn turn;

    private boolean played = false;

    public PhaseEnum getPhaseName()
    {
        return phaseName;
    }

    public Phase(PhaseEnum phaseName, Turn turn)
    {
        this.phaseName = phaseName;
        this.turn = turn;
    }
    public Turn getTurn() {
        return turn;
    }
    public void setIsPlayed(boolean played) {
        this.played = played;
    }
    public boolean isPlayed() {
        return played;
    }
}
