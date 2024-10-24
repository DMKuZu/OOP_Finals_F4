package elements.potion;

import calculate.Potion_Calculator;
import elements.hero.Chosen_Hero;

import java.util.ArrayList;

public class Potions_Inventory extends Chosen_Hero implements Potion_Stats{
    private final int MAX_CAP = 3;
    private ArrayList<Pots> potList;
    private Potion_Calculator calc = new Potion_Calculator();

    public Potions_Inventory(){
        potList = new ArrayList<>(MAX_CAP);
        //you have to set the values at the indexes to be null para makabuhat ka ug tripping
        set_demo_potions();
    }

    private void set_demo_potions() {
        Pots healthPot = new Pots(pot1_NAME,pot1_TARGET,pot1_STAT,pot1_EFFECT,pot1_TURNS);
        Pots manaPot = new Pots(pot2_NAME,pot2_TARGET,pot2_STAT,pot2_EFFECT,pot2_TURNS);
        Pots strengthPot = new Pots(pot3_NAME,pot3_TARGET,pot3_STAT,pot3_EFFECT,pot3_TURNS);

        add_pot(healthPot);
        add_pot(manaPot);
        add_pot(strengthPot);
    }

    public Boolean is_full(){
        return potList.size() >= MAX_CAP;
    }

    public Pots get_pot(int listPos){
        return potList.get(listPos -1);
    }

    public String add_pot(Pots newPot){
        if(is_full()){
            return "You have full Inventory. You want to swap Pots? (y|n)";
        }
        else{
            potList.add(newPot);
            return "Added " + newPot.getNAME();
        }
    }

    public String swap_pot(Pots newPot,int listPos){
        Pots oldPot = get_pot(listPos);
        potList.set(listPos -1,newPot);
        return "Swapped " + oldPot.getNAME() + " with " + newPot.getNAME();
    }

    public int use_pot(int listPos, int stat){    //it returns the new stat TO set the new stat
        Pots usedPot = get_pot(listPos);
        potList.remove(listPos -1);
        add_pot(new Pots());

        int buff;
        String effect = usedPot.getEffect();

        if(usedPot.getEffect().contains("%")){      //checks if it is a multiplier effect potion
            effect = effect.replace("%", "");
            double multiplier = Double.parseDouble(effect);
            buff = calc.calculate_hero_buff(multiplier,stat);
        }
        else if(usedPot.getEffect().contains("<None>")){   //<none> ang value, just a placeholder
            buff = -1;
        }
        else{                                        //checks if its an addend effect potion
            int addend = Integer.parseInt(usedPot.getEffect());
            buff = calc.calculate_hero_buff(addend,stat);
        }

        return buff;
    }



}
