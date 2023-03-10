package com.moduletwoassignments.three;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Deck of cards.
 */
public class Deck {
    private LinkedList<Card> deck;

    Deck() {
        deck = new LinkedList<>();
        createNewDeck();
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
     * Creates a hand that contains the specified number of cards. Cards are drawn from the end of the deck.
     *
     * @param numOfCards the number of cards in the deck.
     * @return a hand with cards.
     */
    public Hand drawHand(int numOfCards) {
        if (numOfCards <= 0) {
            throw new IllegalArgumentException("The number of drawn cards must be greater than zero.");
        }

        LinkedList<Card> cards = new LinkedList<>();

        for (int i = 0; i < numOfCards; i++) {
            cards.add(cards.pollLast());
        }

        Hand hand = new Hand(cards);
        return hand;
    }

    /**
     * Shuffles the deck of cards.
     *
     * @see Collections#shuffle(List)
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Sorts the deck of cards by the suit of the cards.
     *
     * @see CompareByCardSuit
     */
    public void sortDeckBySuits() {
        CompareByCardSuit comparator = new CompareByCardSuit();
        Collections.sort(deck, comparator);
    }

    /**
     * Sorts the deck of cards by the numerical values of the cards.
     *
     * @see CompareByCardNumber
     */
    public void sortDeckByNumbers() {
        CompareByCardNumber comparator = new CompareByCardNumber();
        Collections.sort(deck, comparator);
    }

    /**
     * Creates a new, shuffled deck of cards that contains one of each card.
     */
    private void createNewDeck() {
        deck.clear();

        for (int i = 0; i < 10; i++) {
            deck.add(new NumberCard(i + 1, CardSuit.CLUBS));
            deck.add(new NumberCard(i + 1, CardSuit.SPADES));
            deck.add(new NumberCard(i + 1, CardSuit.HEARTS));
            deck.add(new NumberCard(i + 1, CardSuit.DIAMONDS));
        }

        deck.add(new FaceCard(CardFace.JACK, CardSuit.CLUBS));
        deck.add(new FaceCard(CardFace.JACK, CardSuit.SPADES));
        deck.add(new FaceCard(CardFace.JACK, CardSuit.HEARTS));
        deck.add(new FaceCard(CardFace.JACK, CardSuit.DIAMONDS));

        deck.add(new FaceCard(CardFace.QUEEN, CardSuit.CLUBS));
        deck.add(new FaceCard(CardFace.QUEEN, CardSuit.SPADES));
        deck.add(new FaceCard(CardFace.QUEEN, CardSuit.HEARTS));
        deck.add(new FaceCard(CardFace.QUEEN, CardSuit.DIAMONDS));

        deck.add(new FaceCard(CardFace.KING, CardSuit.CLUBS));
        deck.add(new FaceCard(CardFace.KING, CardSuit.SPADES));
        deck.add(new FaceCard(CardFace.KING, CardSuit.HEARTS));
        deck.add(new FaceCard(CardFace.KING, CardSuit.DIAMONDS));

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