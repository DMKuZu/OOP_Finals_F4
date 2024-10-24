package elements.favor;

import java.util.ArrayList;
import java.util.Random;

public class Favors_Inventory {
    private ArrayList<Favor> favor_List;
    private int favorSize;


    public Favors_Inventory(){
        favor_List = new ArrayList<>(3);
    }

    public int getFavorSize() {
        return favorSize;
    }


    public Favor offer() {
        Random rand = new Random();
        int favorNum = rand.nextInt(6);

        Favor favor = new Favor(favorNum);
        favor_List.add(favorSize,favor);
        favorSize++;
        return favor;
    }

    public Favor useFavor(int favorNum){
        Favor used = favor_List.remove(favorNum-1);
        favorSize = (favorSize > 0) ? favorSize-1 : 0;
        return used;
    }



    public String swapFavorDesc(){
        StringBuilder description = new StringBuilder();
        int i = 1;
        for (Favor favor : favor_List) {
            description.append(String.format("> %d : %s\n\n", i++,favor.toString()));
        }
        return description.toString();
    }

    public String choiceFavorDesc(){
        StringBuilder description = new StringBuilder();
        int i = 6;
        for (Favor favor : favor_List) {
            description.append(String.format("> %d : %s\n\n", i++,favor.toString()));
        }
        return description.toString();
    }

    public String favorDesc(){
        StringBuilder description = new StringBuilder();
        for (Favor favor : favor_List) {
            description.append(String.format("%s\n", favor.toString()));
        }
        return description.toString();
    }

}
