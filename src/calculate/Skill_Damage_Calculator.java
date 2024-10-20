package calculate;

import java.util.Random;

public class Skill_Damage_Calculator {
    private double damage;

    public int minion_calculate_damage(int base_dmg, int attack_stat, int defense_stat) {
        Random rand = new Random();
        int hit_chance = rand.nextInt(100) + 1; // Random number from 1 to 100

        // Calculate normal damage
        damage = Math.abs(base_dmg/30.0 * (attack_stat - defense_stat));

        // Apply hit type modifiers
        if (hit_chance <= 5) { // Miss
            return 0;
        }
        else if (hit_chance <= 90) { // Normal hit
            return (int) damage;
        }
        else { // Critical hit
            return (int) (1.5 * damage);
        }
    }

    public int hero_calculate_damage(int base_dmg, int attack_stat, int defense_stat) {
        Random rand = new Random();
        int hit_chance = rand.nextInt(100) + 1; // Random number from 1 to 100

        // Calculate normal damage
        damage = Math.abs(base_dmg/250.0 * (attack_stat - defense_stat));

        // Apply hit type modifiers
        if (hit_chance <= 5) { // Miss
            return 0;
        }
        else if (hit_chance <= 90) { // Normal hit
            return (int) damage;
        }
        else { // Critical hit
            return (int) (1.5 * damage);
        }
    }
}
