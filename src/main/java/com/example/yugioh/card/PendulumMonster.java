package com.example.yugioh.card;

import kotlin.contracts.Effect;

import java.sql.ResultSet;
import java.util.List;

public class PendulumMonster extends MonsterCard{
    int scale;
    List<Effect> monsterEffect;
    List<Effect> spellEffect;

    public PendulumMonster(ResultSet card)
    {
        super(card);
    }
}
