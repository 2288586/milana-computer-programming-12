package com.moduletwoassignments.moduletwo;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> cards;

    Deck() {
        cards = new LinkedList<>();
        createNewDeck();
    }

    public Hand drawHand() {
        Hand hand = drawHand(7);
        return hand;
    }

    public Hand drawHand(int numOfCards) {
        LinkedList<Card> cards = new LinkedList<>();

        for (int i = 0; i < numOfCards; i++) {
            cards.add(cards.pollLast());
        }

        Hand hand = new Hand(cards);
        return hand;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private void createNewDeck() {
        cards.clear();

        for (int i = 0; i < 10; i++) {
            cards.add(new NumberCard(i + 1, CardSuit.CLUBS));
            cards.add(new NumberCard(i + 1, CardSuit.SPADES));
            cards.add(new NumberCard(i + 1, CardSuit.HEARTS));
            cards.add(new NumberCard(i + 1, CardSuit.DIAMONDS));
        }

        cards.add(new FaceCard(CardFace.JACK, CardSuit.CLUBS));
        cards.add(new FaceCard(CardFace.JACK, CardSuit.SPADES));
        cards.add(new FaceCard(CardFace.JACK, CardSuit.HEARTS));
        cards.add(new FaceCard(CardFace.JACK, CardSuit.DIAMONDS));

        cards.add(new FaceCard(CardFace.QUEEN, CardSuit.CLUBS));
        cards.add(new FaceCard(CardFace.QUEEN, CardSuit.SPADES));
        cards.add(new FaceCard(CardFace.QUEEN, CardSuit.HEARTS));
        cards.add(new FaceCard(CardFace.QUEEN, CardSuit.DIAMONDS));

        cards.add(new FaceCard(CardFace.KING, CardSuit.CLUBS));
        cards.add(new FaceCard(CardFace.KING, CardSuit.SPADES));
        cards.add(new FaceCard(CardFace.KING, CardSuit.HEARTS));
        cards.add(new FaceCard(CardFace.KING, CardSuit.DIAMONDS));

        shuffle();
    }
}