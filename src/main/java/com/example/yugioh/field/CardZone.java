package com.example.yugioh.field;

import com.example.yugioh.card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CardZone{
    private List<Card> cards;

    public CardZone() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card)
    {
        cards.add(card);
    }
    public void removeCard(Card card)
    {
        cards.remove(card);
    }
    public List<Card> getCards()
    {
        return cards;
    }
}
