package com.example.yugioh.deck;

import com.example.yugioh.card.Card;
import com.example.yugioh.enums.DeckType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Card> cardList ;
    private final  int minCard ;
    private final int maxCard;

    public Deck(DeckType deckType)
    {
        this.cardList = new ArrayList<>();
        this.minCard = deckType.getMinCard();
        this.maxCard = deckType.getMaxCard();
    }

    public boolean isValidSize()
    {
        int size = cardList.size() ;
        return (size >= minCard || size <= maxCard);
    }

    /*public boolean isValidCardList()
    {
        TODO correct this function when the game handles card limits
        Map<String,Long> occurrenceMap = cardList.stream().collect(Collectors.groupingBy(card -> card.getName(),
                Collectors.counting()));
        return (cardList.stream().filter(card -> card.getLIMIT().getNbCopies()< occurrenceMap.get(card.getName()))
                .count() == 0);
    }*/

    public boolean isValid()
    {
        return isValidSize();
    }

    public void addCard(Card card) {cardList.add(card);}

    public void removeCard(Card c){cardList.remove(c);}

    public Card removeFirstCard(){return cardList.remove(0);}

    public void shuffle() {Collections.shuffle(cardList);}

    public List<Card> getCardList() {
        return cardList;
    }

    public int getMinCard() {
        return minCard;
    }

    public int getMaxCard() {
        return maxCard;
    }
}
