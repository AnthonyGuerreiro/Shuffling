package com.card;

public class Card {
    private static int idGenerator = 0;
    private int id;

    public Card() {
        id = ++idGenerator;
    }

    public int getId() {
        return id;
    }

}