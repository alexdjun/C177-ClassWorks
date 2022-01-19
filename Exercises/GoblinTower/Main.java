package GoblinTower;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome Hero! Good Luck!");

        // Creating new hero.
        Hero hero = new Hero();
        hero.setInitialGold();

        // Start the game.
        startJourney(hero);

    }

    // Method to play the game.
    public static void startJourney(Hero hero) {
        // Run in a loop where
        while (hero.getCurrentHealth() > 0) {
            // Walks Forward 1 step and display current steps taken.
            hero.walk();
            System.out.println("\nYou took a step!");
            System.out.println("Current step: " + hero.getSteps());

            // Every 10 step, hero levels up and visits potions shop.
            if ((hero.getSteps() %10) == 0) {
                System.out.println("\nYou have reached the rest area!");

                //Level up and display current level.
                hero.levelUp();
                System.out.println("Level Up!");
                System.out.println("Your current level : " + hero.getLevel());

                //Visit Shop and ask user if they want to buy the potions.
                System.out.println("\nPotion shop!");
                System.out.println("Your current health: " + hero.getCurrentHealth());
                System.out.println("Your current gold: " + hero.getGold());
                System.out.print("Do you want to buy potions? (4 gold each) Y/N ");

                // Getting user input.
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();

                switch (input.toUpperCase()) {
                    // If user wants to buy a potion.
                    case "Y":
                        // Display current gold and ask how many potion user wants to buy.
                        System.out.println("Your current gold: " + hero.getGold());
                        System.out.print("How many potions do you wish to buy? 0 - " + (5 - hero.getPotionCount()) + " ");

                        // Get user input.
                        int count = sc.nextInt();

                        // Run in a loop for number of potions user wants to buy.
                        int i = 0;
                        while(i < count) {
                            // If user has the money, buy and show message.
                            if (hero.getGold() >= 4) {
                                hero.buyPotion();
                                System.out.println("Bought a potion!");
                            }

                            // Else, do not buy and exit out from the loop.
                            else {
                                System.out.println("You do not have enough gold.");
                                break;
                            }
                            i++;
                        }

                    // If user does not want to buy a potion show message and leave.
                    case "N":
                        System.out.println("Continuing the journey...");
                        break;

                    // If user input anything else just consider it as not buying a potion.
                    default:
                        System.out.println("You chose not to buy the potion.");
                        System.out.println("Continuing the journey...");
                        break;
                }
            }

            // If it's not the 10th step.
            else {
                // Have a chance to encounter a goblin. (25% chance).
                Random r = new Random();
                int chances = r.nextInt(5 - 1) + 1;

                // When encountered with a goblin,
                if (chances == 1) {
                    // Create a goblin.
                    Goblin goblin = new Goblin();
                    System.out.println("\nYou encountered a goblin! Prepare for battle!");

                    // Battle until someone dies.
                    while (true) {
                        // Hero attacks first.
                        System.out.println("Hero attacks Goblin!");

                        // Check if the attack damage against goblin is positive.
                        if ((hero.getAttackPower() - goblin.getDefensePower()) >= 1){
                            System.out.println("You dealt : " + (hero.getAttackPower() - goblin.getDefensePower()));
                            goblin.setCurrentHealth(-1 * (hero.getAttackPower() - goblin.getDefensePower()));

                        // If negative, just do 1 damage. (To avoid infinite loop)
                        } else {
                            System.out.println("Goblin defense power is too high!\nHero only dealt : 1");
                            goblin.setCurrentHealth(-1);
                        }

                        // Goblin attacks hero next.
                        System.out.println("Goblin attacks Hero!");

                        // Check if the attack damage against Hero is positive.
                        if ((goblin.getAttackPower() - hero.getDefensePower()) >= 1){
                            System.out.println("Goblin dealt : " + (goblin.getAttackPower() - hero.getDefensePower()));
                            hero.addCurrentHealth(-1 * (goblin.getAttackPower() - hero.getDefensePower()));

                        // If negative, just do 1 damage. (To avoid infinite loop)
                        } else {
                            System.out.println("Hero defense power is too high!\nGoblin only dealt : 1");
                            hero.addCurrentHealth(-1);
                        }

                        // Display current health.
                        System.out.println("\nYour current health: " + hero.getCurrentHealth());

                        // If the hero dies.
                        if (hero.getCurrentHealth() <= 0) {
                            // Show message and ask user if they want to play again.
                            System.out.println("Your Hero has fallen.");
                            System.out.print("Do you want to play again? You keep the gold you earned. Y/N ");

                            // Getting user input.
                            Scanner sc = new Scanner(System.in);
                            String input = sc.nextLine();

                            switch (input.toUpperCase()) {
                                // If user wants to play again.
                                case "Y":
                                    // Get the gold right now.
                                    int gold = hero.getGold();

                                    // Create new hero.
                                    Hero hero1 = new Hero();

                                    // Set the gold to the previously earned gold.
                                    hero1.setGold(gold);

                                    // Start the game again.
                                    startJourney(hero1);
                                    break;

                                // If user does not want to play again.
                                case "N":
                                    // Show level reached and number of goblin slayed.
                                    System.out.println("Level Reached : " + hero.getLevel());
                                    System.out.println("Goblin slayed : " + hero.getSlainGoblin());
                                    System.out.println("It was a great journey! See you next time Hero!");
                                    break;
                                default:
                                    // If user inputs any other string, treat as if user does not want to play again.
                                    System.out.println("You chose not to play again.");
                                    System.out.println("Level Reached : " + hero.getLevel());
                                    System.out.println("Goblin slayed : " + hero.getSlainGoblin());
                                    System.out.println("It was a great journey! See you next time Hero!");
                                    break;
                            }
                            break;

                        // If the hero wins.
                        } else if (goblin.getCurrentHealth() <= 0) {
                            // Get gold and display the current gold.
                            hero.goblinSlayed();
                            System.out.println("You have slayed the Goblin!");
                            System.out.println("You have gained 2 gold!");
                            System.out.println("Your current gold : " + hero.getGold() + "\n");

                            // If the user has potions.
                            if (hero.getPotionCount() > 0) {
                                // Ask user if they want to use the potions.
                                System.out.println("Hero's max HP: " + hero.getMaxHealth());
                                System.out.println("Your current health: " + hero.getCurrentHealth());
                                System.out.println("Your potion amount : " + hero.getPotionCount());
                                System.out.print("Do you want to drink a potion? Y/N ");

                                // Getting user input.
                                Scanner sc = new Scanner(System.in);
                                String input = sc.nextLine();

                                switch (input.toUpperCase()) {
                                    // If user wants to drink a potion.
                                    case "Y":
                                        // Ask user how many they want to drink.
                                        System.out.print("How many potions do you want to drink? ");
                                        int count = sc.nextInt();

                                        // Subtract the potion count.
                                        for (int i = 0; i < count; i++) {
                                            hero.drinkPotion();
                                        }

                                        int i = 0;

                                        // +2 to health amount of times user is drinking.
                                        while (i < count) {
                                            System.out.println("You drank a potion!");
                                            hero.addCurrentHealth(hero.getPotions(i));

                                            // However, if reached max health, break out from loop.
                                            if (hero.getCurrentHealth() == hero.maxHealth) {
                                                break;

                                            // If the current health goes over the max health, set the health back to max health.
                                            } else if (hero.getCurrentHealth() > hero.maxHealth) {
                                                hero.setCurrentHealth();
                                                break;
                                            }
                                            i++;
                                        }

                                        // Display current health and messages.
                                        System.out.println("Your current health: " + hero.getCurrentHealth());
                                        System.out.println("Continuing the journey...");
                                        break;

                                    // If user does not want to drink a potion.
                                    case "N":
                                        System.out.println("Continuing the journey...");
                                        break;

                                    // If user input anything else just consider it as not drinking potion.
                                    default:
                                        System.out.println("You chose not to drink the potion.");
                                        System.out.println("Continuing the journey...");
                                        break;
                                }

                            // If the user doesn't have any potions left.
                            } else {
                                // Show message and move on.
                                System.out.println("You don't have any potions to drink.\nContinuing the journey...");
                            }
                            break;
                        }
                    }
                }

                // If didn't encounter a goblin, continue the journey.
                else {
                    continue;
                }
            }

        }
    }
}
