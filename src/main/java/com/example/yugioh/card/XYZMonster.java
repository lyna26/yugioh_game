package com.example.yugioh.card;

import java.sql.ResultSet;

public class XYZMonster extends MonsterCard{
    int rank;
    public XYZMonster(ResultSet card)
    {
        super(card);
    }
}
