package com.deck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.card.Card;

public class Deck {
    private List<Card> cards;

    public Deck(int size) {
        cards = new ArrayList<Card>(size);
        for (int i = 0; i < size; i++) {
            cards.add(new Card());
        }
    }

    public void swap(int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int firstSwap = index1;
        int secondSwap = index2;
        if (index2 > index1) {
            firstSwap = index2;
            secondSwap = index1;
        }
        Card card1 = cards.get(firstSwap);
        Card card2 = cards.get(secondSwap);

        cards.remove(card1);
        cards.remove(card2);

        cards.add(secondSwap, card1);
        cards.add(firstSwap, card2);
    }

    private Comparator<Card> cardComparator = new Comparator<Card>() {

        @Override
        public int compare(Card c1, Card c2) {
            int id1 = c1.getId();
            int id2 = c2.getId();
            return id1 - id2;
        }

    };

    public void reorder() {
        cards.sort(cardComparator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.getId());

            if (cards.indexOf(card) != cards.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public int size() {
        return cards.size();
    }
}
