package com.example.yugioh.duel;

import com.example.yugioh.enums.PhaseEnum;
import com.example.yugioh.phase.DrawPhase;
import com.example.yugioh.phase.Phase;
import com.example.yugioh.player.Player;

public class Turn {
    private Phase phase;
    private Duel duel;
    public Turn(Duel duel){
        this.duel = duel;
    }
    public Player getCurrentUser() {return duel.getCurrentUser();}
    public PhaseEnum getCurrentPhaseName() {
        return phase.getPhaseName();
    }

    public Phase getCurrentPhase() {return phase;}
    public void setCurrentPhase(Phase phase) {
        this.phase = phase;
    }

    public Duel getDuel() {
        return duel;
    }
}
