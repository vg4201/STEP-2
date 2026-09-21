import java.util.Scanner;

public class HealthBar {

    static class Character {
        private int health;
        private final int maximumHealth;

        public Character(int maximumHealth) {
            if (maximumHealth < 0) {
                this.maximumHealth = 0;
            } else {
                this.maximumHealth = maximumHealth;
            }

            this.health = this.maximumHealth;
        }

        public void takeDamage(int amount) {
            if (amount <= 0) {
                return;
            }

            health -= amount;

            if (health < 0) {
                health = 0;
            }
        }

        public void heal(int amount) {
            if (amount <= 0) {
                return;
            }

            health += amount;

            if (health > maximumHealth) {
                health = maximumHealth;
            }
        }

        public int getHealth() {
            return health;
        }

        public int getMaximumHealth() {
            return maximumHealth;
        }
    }

    public static void main(String[] args) {
        Character character = new Character(100);

        character.takeDamage(30);
        System.out.println("Health after damage: "
                + character.getHealth());

        character.heal(50);
        System.out.println("Health after healing: "
                + character.getHealth());

        character.takeDamage(150);
        System.out.println("Health after extra damage: "
                + character.getHealth());
    }
}