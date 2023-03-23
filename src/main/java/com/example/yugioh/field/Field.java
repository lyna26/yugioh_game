package com.example.yugioh.field;

import com.example.yugioh.card.Card;

public class Field {
    private Card fieldZone;
    private MonsterZone monsterZone;
    private SpellTrapZone spellTrapZone;
    private ExtraDeckZone extraMonsterZone;
    private MainDeckZone mainMonsterZone;
    private GraveyardZone graveyardZone;
    private BannishZone bannishZone;
    private HandZone handZone;

    public Field() {
        fieldZone = null;
        monsterZone = new MonsterZone();
        spellTrapZone = new SpellTrapZone();
        extraMonsterZone = new ExtraDeckZone();
        mainMonsterZone = new MainDeckZone();
        graveyardZone = new GraveyardZone();
        bannishZone = new BannishZone();
        handZone = new HandZone();
    }

    public Card getFieldZone() {
        return fieldZone;
    }

    public MonsterZone getMonsterZone() {
        return monsterZone;
    }

    public SpellTrapZone getSpellTrapZone() {
        return spellTrapZone;
    }

    public ExtraDeckZone getExtraMonsterZone() {
        return extraMonsterZone;
    }

    public MainDeckZone getMainMonsterZone() {
        return mainMonsterZone;
    }

    public GraveyardZone getGraveyardZone() {
        return graveyardZone;
    }

    public BannishZone getBannishZone() {
        return bannishZone;
    }

    public HandZone getHandZone() {
        return handZone;
    }
}
