package GoblinTower;

public class Unit {
    // Declaring variable
    protected int maxHealth;
    protected int attackPower;
    protected int defensePower;

    //Methods
    //Method to display HP, Attack, and Defense.
    public void displayStats() {
        System.out.println("Max HP : " + getMaxHealth());
        System.out.println("Attack Power : " + getAttackPower());
        System.out.println("Defense Power : " + getDefensePower());
    }

    // Getters.
    // Returns desired variables.
    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getDefensePower() {
        return this.defensePower;
    }
}
