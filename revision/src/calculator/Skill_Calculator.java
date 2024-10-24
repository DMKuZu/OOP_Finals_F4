package calculator;

public class Skill_Calculator {

    public Boolean hit_chance(double destDodge){
        return Math.random() > destDodge;
    }


    public int calculate_damage(int baseDmg, int sourceAtk, double sourceCritChance, int destDef, boolean[] isCrit){
        double rawDamage = baseDmg + ((baseDmg/100.0) * sourceAtk);

        double damageAfterDefense = Math.max(rawDamage - destDef, 0);

        double critMultiplier;
        if(Math.random() <= sourceCritChance){
            critMultiplier = 1.8;
            isCrit[0] = true;
        }
        else{
            critMultiplier = 1.0;
            isCrit[0] = false;
        }

        critMultiplier += Math.max(sourceCritChance - 1.0,0.0);

        double finalDamage = damageAfterDefense * critMultiplier;

        return (int) Math.round(finalDamage);
    }

}
