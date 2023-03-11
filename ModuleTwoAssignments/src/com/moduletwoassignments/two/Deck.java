package com.moduletwoassignments.two;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Deck of cards.
 */
public class Deck {
    private final LinkedList<Card> deck;

    Deck() {
        deck = new LinkedList<>();
        createNewDeck();
    }

    Deck(List<Card> deck) {
        this.deck = new LinkedList<>(deck);
    }

    /**
     * Creates a hand of seven cards.
     *
     * @return a hand with seven cards.
     * @see #drawHand(int)
     */
    public Hand drawHand() {
        Hand hand = drawHand(7);
        return hand;
    }

    /**
     * Creates a hand that contains the specified number of cards. Cards are drawn from the top of the deck.
     *
     * @param numOfCards the number of cards in the deck.
     * @return a hand with cards.
     */
    public Hand drawHand(int numOfCards) {
        if (numOfCards <= 0) {
            throw new IllegalArgumentException("The number of drawn cards must be greater than zero.");
        }

        if (numOfCards > deck.size()) {
            throw new IllegalArgumentException("Not enough cards left in the deck.");
        }

        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < numOfCards; i++) {
            cards.add(deck.pollLast());
        }

        Hand hand = new Hand(cards);
        return hand;
    }

    /**
     * Shuffles the deck of cards.
     *
     * @return the deck of cards.
     * @see Collections#shuffle(List)
     */
    public Deck shuffle() {
        Collections.shuffle(deck);
        return this;
    }

    /**
     * Creates a new, shuffled deck of cards that contains one of each card.
     */
    private void createNewDeck() {
        deck.clear();

        for (CardSuit cardSuit : CardSuit.values()) {
            for (int i = 1; i <= 10; i++) {
                deck.add(new NumberCard(i, cardSuit));
            }

            for (CardFace cardFace : CardFace.values()) {
                deck.add(new FaceCard(cardFace, cardSuit));
            }
        }

        shuffle();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Deck) {
            Deck other = (Deck) object;

            if (this.deck == other.deck) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = deck.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "Deck Of " + deck.size() + " Cards:\n" + deck.toString();
    }
}