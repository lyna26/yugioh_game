package com.example.yugioh.card;

import java.sql.ResultSet;

public class FusionMonster extends MonsterCard{
    private String fusionMaterial;

    public FusionMonster(ResultSet card)
    {
        super(card);
    }
}
