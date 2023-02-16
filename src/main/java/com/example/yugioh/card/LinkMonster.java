package com.example.yugioh.card;


import java.sql.ResultSet;

public class LinkMonster extends MonsterCard{
    private int likVal;
    private String linkArraws;

    public LinkMonster(ResultSet card)
    {
        super(card);
    }

}
