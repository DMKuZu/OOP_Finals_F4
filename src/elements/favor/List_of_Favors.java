package elements.favor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface List_of_Favors {
    List<String> NAME_List = Arrays.asList(
            "Blessing of Healing",
            "Ode of the Warriors",
            "Ballads of the Guardians",
            "Song of the Winds",
            "Electrifying Beats",
            "Blessing of Perseverance"

    );

    enum STAT{
        HP(30,"HP"),
        ATK(10,"ATK"),
        DEF(10, "DEF"),
        DODGE(30,"DODGE"),
        CRIT(30,"CRIT"),
        USES(5,"USES");

        private final int value;
        private final String stat;

        STAT(int value,String stat){
            this.value = value;
            this.stat = stat;
        }

        public String getStat() {
            return stat;
        }

        public int getValue(){
            return value;
        }
    }

    Map<String, STAT> Favor_Stat = Map.ofEntries(

            Map.entry("Blessing of Healing", STAT.HP),
            Map.entry("Ode of the Warriors", STAT.ATK),
            Map.entry("Ballads of the Guardians", STAT.DEF),
            Map.entry("Song of the Winds", STAT.DODGE),
            Map.entry("Electrifying Beats", STAT.CRIT),
            Map.entry("Blessing of Perseverance", STAT.USES)

    );



}
