package GoblinTower;

import java.util.Random;

    public class Goblin extends Unit {
        // Declaring variables.
        private int currentHealth;

        // Constructor
        public Goblin() {
            // Setting initial stats for the goblin.
            setMaxHealth();
            setCurrentHealth(getMaxHealth());
            setAttackPower();
            setDefensePower();
        }

        // Getter.
        // Returns desired variable.
        public int getCurrentHealth() {
            return this.currentHealth;
        }

        // Setters.
        // Returns desired variables.
        public void setCurrentHealth(int n) {
            this.currentHealth += n;
        }

        public void setMaxHealth() {
            // Max hp is random number between 5 and 10.
            Random r = new Random();
            this.maxHealth = r.nextInt(11 - 5) + 5;
        }

        public void setAttackPower() {
            // Max damage is random number between 2 and 3.
            Random r = new Random();
            this.attackPower = r.nextInt(4 - 2) + 2;
        }

        public void setDefensePower() {
            // Max defense is random number between 1 and 3.
            Random r = new Random();
            this.defensePower = r.nextInt(3 - 1) + 1;
        }
}

