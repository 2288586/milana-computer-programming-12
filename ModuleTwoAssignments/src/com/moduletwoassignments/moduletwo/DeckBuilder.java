package com.moduletwoassignments.moduletwo;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;

public class DeckBuilder {
    private LinkedList<Card> cards;

    DeckBuilder() {
        cards = new LinkedList<>();
        createNewDeck();
    }

    public ArrayList<Card> drawHand() {
        ArrayList<Card> hand = new ArrayList<>(7);

        for (int i = 0; i < 7; i++) {
            hand.add(cards.pollLast());
        }

        return hand;
    }

    public LinkedList<Card> shuffle() {
        Collections.shuffle(cards);
        return cards;
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
    }
}