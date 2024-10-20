package calculate;

public class Potion_Calculator {

    public int calculate_hero_buff(int addend, int stat){
        stat += addend;

        return stat;
    }

    public int calculate_hero_buff(double multiplier, int stat){
        stat += (int) Math.floor((multiplier/100) * stat);

        return stat;
    }
}
