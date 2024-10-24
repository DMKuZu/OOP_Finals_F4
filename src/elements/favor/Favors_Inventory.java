package elements.favor;

import java.util.ArrayList;
import java.util.Random;

public class Favors_Inventory {
    private ArrayList<Favor> favor_List;
    private int favorSize;

    private void set_demo_favors() {
        favor_List.add(new Favor(0));
        favor_List.add(new Favor(2));
        favor_List.add(new Favor(5));
        favorSize = 3;
    }

    private void set_favors() {
        favor_List.add(new Favor());
        favor_List.add(new Favor());
        favor_List.add(new Favor());
        favorSize = 0;
    }

    public Favors_Inventory(){
        favor_List = new ArrayList<>(3);

//        set_demo_favors();
        set_favors();
    }
    
    public String getFavorName(int favorNum){
        return favor_List.get(favorNum-1).getName();
    }
    public String getFavorStat(int favorNum){
        return favor_List.get(favorNum-1).getStat();
    }
    public int getFavorValue(int favorNum){
        return favor_List.get(favorNum-1).getValue();
    }
    public int getFavorSize() {
        return favorSize;
    }

    public Favor gacha() {
        Random rand = new Random();
        int favorNum = rand.nextInt(6);

        Favor favor = new Favor(favorNum);
        favor_List.add(favorSize,favor);
        favorSize++;
        return favor;
    }

    public Favor useFavor(int favorNum){
        Favor used = favor_List.remove(favorNum-1);
        favor_List.add(new Favor());
        favorSize = (favorSize > 0) ? favorSize-1 : 0;
        return used;
    }

    public void favorDesc(){
        for(int i = 0; i < favorSize; i++){
            System.out.println("|| " + favor_List.get(i).toString());
        }
    }

    public void swapFavorDesc(){
        for(int i = 0; i < favorSize; i++){
            System.out.println("|| > " + (i+1) + " : " + favor_List.get(i).toString());
        }
    }
}
