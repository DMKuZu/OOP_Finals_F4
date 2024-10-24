package elements.blessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Blessing_Gacha implements List_of_Blessings{
    private List<Legendary> Legendary_List;
    private List<Epic> Epic_List;
    private List<Rare> Rare_List;
    private List<Uncommon> Uncommon_List;
    private List<Common> Common_List;

    private String name;
    private String stat;
    private int value;


    public Blessing_Gacha(){
        Legendary_List = new ArrayList<>(Arrays.asList(
                Legendary.BLESS1,
                Legendary.BLESS2,
                Legendary.BLESS3,
                Legendary.BLESS4,
                Legendary.BLESS5
        ));

        Epic_List = new ArrayList<>(Arrays.asList(
                Epic.BLESS1,
                Epic.BLESS2,
                Epic.BLESS3,
                Epic.BLESS4,
                Epic.BLESS5,
                Epic.BLESS6,
                Epic.BLESS7,
                Epic.BLESS8,
                Epic.BLESS9,
                Epic.BLESS10
        ));

       Rare_List = new ArrayList<>(Arrays.asList(
                Rare.BLESS1,
                Rare.BLESS2,
                Rare.BLESS3,
                Rare.BLESS4,
                Rare.BLESS5,
                Rare.BLESS6,
                Rare.BLESS7,
                Rare.BLESS8,
                Rare.BLESS9,
                Rare.BLESS10
        ));

       Uncommon_List = new ArrayList<>(Arrays.asList(
                Uncommon.BLESS1,
                Uncommon.BLESS2,
                Uncommon.BLESS3,
                Uncommon.BLESS4,
                Uncommon.BLESS5,
                Uncommon.BLESS6,
                Uncommon.BLESS7,
                Uncommon.BLESS8,
                Uncommon.BLESS9,
                Uncommon.BLESS10
        ));

       Common_List = new ArrayList<>(Arrays.asList(
                Common.BLESS1,
                Common.BLESS2,
                Common.BLESS3,
                Common.BLESS4,
                Common.BLESS5,
                Common.BLESS6,
                Common.BLESS7,
                Common.BLESS8,
                Common.BLESS9,
                Common.BLESS10
        ));
    }

    public Blessing blessing_gacha(String enemyType){
        Random rand = new Random();
        int num,index;

        switch (enemyType) {
            case "norm":
                while (true) {
                    num = rand.nextInt(100);
                    if (num < 50 && !Common_List.isEmpty()) {
                         index = rand.nextInt(Common_List.size());
                        name = Common_List.get(index).getName();
                        stat = Common_List.get(index).getStat();
                        value = Common_List.get(index).getValue();
                        Common_List.remove(index);
                        break;
                    } else if (num < 90 && !Uncommon_List.isEmpty()) {
                        index = rand.nextInt(Uncommon_List.size());
                        name = Uncommon_List.get(index).getName();
                        stat = Uncommon_List.get(index).getStat();
                        value = Uncommon_List.get(index).getValue();
                        Uncommon_List.remove(index);
                        break;
                    } else if (!Rare_List.isEmpty()) {
                        index = rand.nextInt(Rare_List.size());
                        name = Rare_List.get(index).getName();
                        stat = Rare_List.get(index).getStat();
                        value = Rare_List.get(index).getValue();
                        Rare_List.remove(index);
                        break;
                    }
                }
                break;
            case "elite":
                while (true) {
                    num = rand.nextInt(100);
                    if (num < 70 && !Rare_List.isEmpty()) {
                         index = rand.nextInt(Rare_List.size());
                        name = Rare_List.get(index).getName();
                        stat = Rare_List.get(index).getStat();
                        value = Rare_List.get(index).getValue();
                        Rare_List.remove(index);
                        break;
                    } else if (!Epic_List.isEmpty()) {
                         index = rand.nextInt(Epic_List.size());
                        name = Epic_List.get(index).getName();
                        stat = Epic_List.get(index).getStat();
                        value = Epic_List.get(index).getValue();
                        Epic_List.remove(index);
                        break;
                    }
                }
                break;
            case "boss":
                while (true) {
                    num = rand.nextInt(100);
                    if (num < 80 && !Epic_List.isEmpty()) {
                         index = rand.nextInt(Epic_List.size());
                        name = Epic_List.get(index).getName();
                        stat = Epic_List.get(index).getStat();
                        value = Epic_List.get(index).getValue();
                        Epic_List.remove(index);
                        break;
                    } else if (!Legendary_List.isEmpty()) {
                         index = rand.nextInt(Legendary_List.size());
                        name = Legendary_List.get(index).getName();
                        stat = Legendary_List.get(index).getStat();
                        value = Legendary_List.get(index).getValue();
                        Legendary_List.remove(index);
                        break;
                    }
                }
                break;
        }

        return new Blessing(name,stat,value);
    }
}
