package com.example.yugioh.duel;

import com.example.yugioh.enums.Phase;
import com.example.yugioh.player.Player;

public class Turn {
    private com.example.yugioh.phase.Phase phase;
    private Duel duel;
    public Turn(Duel duel){
        this.duel = duel;
    }
    public Player getCurrentUser() {return duel.getCurrentUser();}
    public Phase getCurrentPhaseName() {
        return phase.getPhaseName();
    }

    public com.example.yugioh.phase.Phase getCurrentPhase() {return phase;}
    public void setCurrentPhase(com.example.yugioh.phase.Phase phase) {
        this.phase = phase;
    }

    public Duel getDuel() {
        return duel;
    }
}
