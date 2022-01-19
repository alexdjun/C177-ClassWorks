package PlayerDeck;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlayerDeck {
    // Variable for deck size.
    private int size = 52;

    // Variable for hand size.
    private int handSize = 0;

    // Variable for deck, hand, and discarded pile respectively.
    private String[] deck = new String[size];
    private String[] hand = new String[size];
    private String[] discard = new String[size];

    // Getter for size.
    public int getSize() {
        return this.size;
    }

    // Method to create a deck.
    public void createDeck() {
        System.out.println("Creating your deck of cards...");

        // Create two new arrays with its suits and ranks.
        String[] suits = {"Club", "Diamond", "Spade", "Heart"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Run in a nested for loop to fill up the deck.
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                this.deck[suits.length * i + j] = ranks[i] + " of " + suits[j];
            }
        }

        System.out.println("Complete!\n");
    }

    // Method to shuffle the deck.
    public void shuffleDeck() {
        System.out.println("Shuffling your deck of cards...");

        // Run in a loop for the size of the deck and change up its order.
        for (int i = 0; i < this.size; i++) {
            int r = i + (int)(Math.random() * (52 - i));
            String temp = this.deck[r];
            this.deck[r] = this.deck[i];
            this.deck[i] = temp;
        }

        System.out.println("Complete!\n");
    }

    // Method to draw cards.
    public void drawCards(int n) {
        // Increase the number of hand size.
        this.handSize += n;

        // Assigning hands with the card drawn from deck.
        for (int i = handSize - n; i < handSize; i++) {
            this.hand[i] = this.deck[i];
        }

        // Reducing the size of the deck.
        this.size -= n;
    }

    // Method to play the hand.
    public void playHand(int n) {
        // Run through loops for amount of cards user has drawn.
        for (int i = handSize - n; i < handSize; i++) {
            System.out.print("Playing your #" + (i+1) + " card: ");
            System.out.println(this.hand[i]);

            // Add the card to the discarded pile.
            this.discard[i] = this.hand[i];
        }
        System.out.println("Empty Hand!\n");
    }

    // Method to display discarded pile if user wanted to see.
    public void showDiscard() {
        System.out.println("Your discarded cards.");
        for (int i = 0; i < this.handSize; i++) {
            System.out.print(this.discard[i] + " ");
        }
        System.out.println();
    }
}
