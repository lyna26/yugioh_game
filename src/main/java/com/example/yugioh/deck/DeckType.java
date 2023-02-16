package com.example.yugioh.deck;

public enum DeckType {
    MAIN(40,60),
    EXTRA(0,15),
    SIDE(0,15);

    private int minCard;
    private int maxCard;

    DeckType(int minCard, int maxCard)
    {
        this.minCard = minCard;
        this.maxCard = maxCard;
    }

    public int getMinCard()
    {
        return minCard;
    }

    public int getMaxCard()
    {
        return maxCard;
    }
}
