package elements.blessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Blessing_Gacha implements List_of_Blessings{
    private List<Blessing> Legendary;
    private List<Blessing> Epic;
    private List<Blessing> Rare;
    private List<Blessing> Uncommon;
    private List<Blessing> Common;


    public Blessing_Gacha(){
        this.Legendary = new ArrayList<>(Legendary_List);
        this.Epic = new ArrayList<>(Epic_List);
        this.Rare = new ArrayList<>(Rare_List);
        this.Uncommon = new ArrayList<>(Uncommon_List);
        this.Common = new ArrayList<>(Common_List);
    }

    public Blessing blessing_gacha(String enemyType){
        Random rand = new Random();
        int num,index;
        Blessing blessing = new Blessing("none","none",10);

        switch (enemyType) {
            case "norm":
                while (true) {
                    num = rand.nextInt(100);
                    if (num < 50 && !Common.isEmpty()) {
                        index = rand.nextInt(Common.size());
                        blessing = Common.remove(index);
                        break;
                    } else if (num < 90 && !Uncommon.isEmpty()) {
                        index = rand.nextInt(Uncommon.size());
                        blessing = Uncommon.remove(index);
                        break;
                    } else if (!Rare.isEmpty()) {
                        index = rand.nextInt(Rare.size());
                        blessing = Rare.remove(index);
                        break;
                    }
                }
                break;
            case "elite":
                while (true) {
                    num = rand.nextInt(100);
                    if (num < 70 && !Rare.isEmpty()) {
                        index = rand.nextInt(Rare.size());
                        blessing = Rare.remove(index);
                        break;
                    } else if (!Epic.isEmpty()) {
                        index = rand.nextInt(Epic.size());
                        blessing = Epic.remove(index);
                        break;
                    }
                }
                break;
            case "boss":
            case "final":
                while (true) {
                    num = rand.nextInt(100);
                    if (num < 80 && !Epic.isEmpty()) {
                        index = rand.nextInt(Epic.size());
                        blessing = Epic.remove(index);
                        break;
                    } else if (!Legendary.isEmpty()) {
                        index = rand.nextInt(Legendary.size());
                        blessing = Legendary.remove(index);
                        break;
                    }
                }
                break;
        }

        return blessing;
    }
}
