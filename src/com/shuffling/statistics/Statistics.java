package com.shuffling.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.deck.Deck;

public class Statistics {
    private Map<String, Integer> shuffleMap = new HashMap<String, Integer>();

    public void add(Deck shuffledDeck) {
        String order = shuffledDeck.toString();
        Integer count = shuffleMap.get(order);
        if (count == null) {
            count = 0;
        }
        shuffleMap.put(order, count + 1);
    }

    public int maximum() {
        int maximum = Integer.MIN_VALUE;
        for (Entry<String, Integer> entry : shuffleMap.entrySet()) {
            int current = entry.getValue();
            if (current > maximum) {
                maximum = current;
            }
        }
        return maximum;
    }

    public int minimum() {
        int minimum = Integer.MAX_VALUE;
        for (Entry<String, Integer> entry : shuffleMap.entrySet()) {
            int current = entry.getValue();
            if (current < minimum) {
                minimum = current;
            }
        }
        return minimum;
    }

    public float average() {
        float total = 0;
        for (Entry<String, Integer> entry : shuffleMap.entrySet()) {
            total += entry.getValue();
        }
        return total / shuffleMap.entrySet().size();
    }

    @Override
    public String toString() {
        // this cycle should be used for small sized decks
        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> entry : shuffleMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(Integer.toString(entry.getValue()));
            sb.append("\n");
        }
        sb.append("average: ");
        sb.append(Float.toString(average()));
        sb.append(", minimum: ");
        sb.append(Integer.toString(minimum()));
        sb.append(", maximum: ");
        sb.append(Integer.toString(maximum()));
        sb.append("\n");
        return sb.toString();
    }
}
