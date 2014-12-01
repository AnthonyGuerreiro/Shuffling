package com.shuffling;

import com.deck.Deck;

public class BadShuffle {

    public static void shuffle(Deck deck) {
        int deckSize = deck.size();
        for (int i = 0; i < deckSize; i++) {
            int randomIndex = (int) (Math.random() * deckSize);
            deck.swap(i, randomIndex);
        }
    }
}
