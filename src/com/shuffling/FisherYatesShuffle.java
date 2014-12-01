package com.shuffling;

import com.deck.Deck;

public class FisherYatesShuffle {

    public static void shuffle(Deck deck) {
        int deckSize = deck.size();
        for (int i = 0; i < deckSize; i++) {
            int randomIndex = (int) (Math.random() * (deckSize - i))
                    + i;
            deck.swap(i, randomIndex);
        }
    }
}
