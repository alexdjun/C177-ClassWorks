package GoblinTower;

import java.util.Random;

public class Hero extends Unit {
    // Declaring variables.
    private int currentHealth;
    private int[] potions = {2,2,2,2,2};
    private int potionCount = 5;
    private int gold ;
    private int level = 0;
    private int steps = 0;
    private int slainGoblin = 0;

    // Constructor
    public Hero() {
        // Setting initial stats for the hero.
        setMaxHealth();
        setCurrentHealth();
        setAttackPower();
        setDefensePower();
    }

    //Methods
    public void setInitialGold() {
        // Setting initial gold.
        this.gold = 0;
    }

    public void walk() {
        // Adding steps.
        this.steps += 1;
    }

    public void goblinSlayed() {
        // Add gold and number of goblin salyed.
        this.gold += 2;
        this.slainGoblin++;
    }

    public void levelUp() {
        // Add level.
        this.level += 1;
    }

    public void drinkPotion() {
        // Subtract potion count.
        this.potionCount--;
    }

    public void buyPotion() {
        // Add potion count and subtract gold.
        this.potionCount++;
        this.gold -= 4;
    }

    public void addCurrentHealth(int n) {
        // Add current health.
        this.currentHealth += n;
    }

    // Getters.
    // Returns desired variables.    // Returns desired variables.
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getPotions(int n)  {
        return this.potions[n];
    }

    public int getPotionCount() {
        return this.potionCount;
    }

    public int getGold() {
        return this.gold;
    }

    public int getLevel() {
        return this.level;
    }

    public int getSteps() {
        return this.steps;
    }

    public int getSlainGoblin() {
        return this.slainGoblin;
    }


    // Setters.
    // Returns desired variables.    // Returns desired variables.
    public void setCurrentHealth() {
        this.currentHealth = getMaxHealth();
    }

    public void setMaxHealth() {
        // Max hp is random number between 20 and 30.
        Random r = new Random();
        this.maxHealth = r.nextInt(31 - 20) + 20;
    }

    public void setAttackPower() {
        // Max damage is random number between 1 and 4.
        Random r = new Random();
        this.attackPower = r.nextInt(4 - 1) + 1;
    }

    public void setDefensePower() {
        // Max defense is random number between 1 and 5.
        Random r = new Random();
        this.defensePower = r.nextInt(6 - 1) + 1;
    }

    public void setGold(int n) {
        this.gold = n;
    }
}
