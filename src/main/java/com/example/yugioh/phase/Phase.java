package com.example.yugioh.phase;

import com.example.yugioh.enums.PhaseEnum;

public abstract class Phase implements IPhase{
    private PhaseEnum phaseName;
    public PhaseEnum getPhaseName()
    {
        return phaseName;
    }

    public void Phase(PhaseEnum phaseName)
    {
        this.phaseName = phaseName;
    }
}
