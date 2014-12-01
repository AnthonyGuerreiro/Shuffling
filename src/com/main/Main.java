package com.main;

import com.deck.Deck;
import com.shuffling.BadShuffle;
import com.shuffling.statistics.Statistics;

public class Main {
    public static void main(String[] args) {
        int numberShuffles = 1_000_000;
        int deckSize = 3;
        Statistics stats = new Statistics();
        Deck deck = new Deck(deckSize);
        for (int i = 0; i < numberShuffles; i++) {
            deck.reorder();
            BadShuffle.shuffle(deck);
            // FisherYatesShuffle.shuffle(deck);

            stats.add(deck);
        }

        System.out.println(stats);
    }
}
