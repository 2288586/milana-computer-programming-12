package com.moduletwoassignments.three;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck + "\n");

        System.out.println(deck.sortByNumbers() + "\n");
        System.out.println(deck.sort(new CompareByCardNumber()) + "\n");

        System.out.println(deck.sortBySuits() + "\n");
        System.out.println(deck.sort(new CompareByCardSuit()));
    }
}