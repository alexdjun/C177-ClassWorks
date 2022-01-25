package PlayerDeck;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean menu = true;

        System.out.println("Welcome to the card game!\n");

        // Do while loop so only the user can terminate the program.
        do {
            System.out.print("Do you want to play the game? Y/N ");
            String answer = sc.nextLine();

            // Switch statement by changing a letter to uppercase.
            switch (answer.toUpperCase()) {
                // When user wants to play the game:
                case "Y":
                    System.out.println("Let's start the game!\n");

                    // Creating a deck.
                    PlayerDeck myDeck = new PlayerDeck();
                    myDeck.createDeck();

                    // Shuffling the deck.
                    myDeck.shuffleDeck();

                    // While deck isn't empty, keep on drawing and playing it.
                    while (myDeck.getSize() > 0) {
                        // Using try and catch to make sure user doesn't put numbers higher than the number of cards in deck.
                        try {
                            System.out.println("How many cards do you want to draw from your deck? 0 - " + " "
                                    + myDeck.getSize() + " : ");
                            int draw = sc.nextInt();
                            if (draw > 0) {
                                if (draw > myDeck.getSize()) {
                                    throw new ArrayIndexOutOfBoundsException();
                                }
                                // Draw cards.
                                myDeck.drawCards(draw);

                                // Play cards.
                                myDeck.playHand(draw);
                            } else if (draw == 0) {
                                System.out.println("You need to draw!");
                            } else if (draw < 0) {
                                System.out.println("Please enter a number betwwen 0 - "
                                        + myDeck.getSize());
                            } else {
                                throw new InputMismatchException();
                            }

                        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                            System.out.println("You can only enter positive integer!");
                            sc.next();
                        }
                    }
                    break;

                // When user doesn't want to play the game:
                case "N":
                    // Say goodbye to the user and end the loop.
                    System.out.println("See you next time!");
                    menu = false;
                    break;

                // When user inputs other than y/n, prompt the user to input the choices correctly again.
                default:
                    System.out.println("\nEnter either Y or N.\n");
                    break;
            }
        } while (menu);
    }
}
