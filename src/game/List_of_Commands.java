package game;

import java.util.Map;

public interface List_of_Commands {
    //key == input of the user

    Map<String,String> STARTMENU = Map.ofEntries(
        Map.entry("start","start"),
        Map.entry("atlas","atlas"),
        Map.entry("credits","credits"),
        Map.entry("exit","exit"),
        Map.entry("1","start"),
        Map.entry("2","atlas"),
        Map.entry("3","credits"),
        Map.entry("4","exit")
    );

    Map<String,String> CHOOSEHERO = Map.ofEntries(
            Map.entry("radea","radea"),
            Map.entry("mazupe","mazupe"),
            Map.entry("zipau","zipau"),
            Map.entry("superidolsirkhai","superidolsirkhai"),
            Map.entry("1","radea"),
            Map.entry("2","mazupe"),
            Map.entry("3","zipau"),
            Map.entry("69","superidolsirkhai")
    );

    Map<String,String> TRANCE = Map.ofEntries(
            Map.entry("continue","continue"),
            Map.entry("offer","offer"),
            Map.entry("1","offer"),
            Map.entry("2","continue")
    );

    Map<String,String> BATTLE = Map.ofEntries(
            Map.entry("skills","skills"),
            Map.entry("favors","favors"),
            Map.entry("info","info"),
            Map.entry("1","skills"),
            Map.entry("2","favors"),
            Map.entry("3","info")
    );

    Map<String,String> CHOOSESKILL = Map.ofEntries(
            Map.entry("1","1"),
            Map.entry("2","2"),
            Map.entry("3","3"),
            Map.entry("4","4"),
            Map.entry("5","5"),
            Map.entry("6","back"),
            Map.entry("back","back")
    );

    Map<String,String> CHOOSEFAVOR = Map.ofEntries(
            Map.entry("1","1"),
            Map.entry("2","2"),
            Map.entry("3","3"),
            Map.entry("4","back/continue"),
            Map.entry("back","back"),
            Map.entry("continue","continue")

    );


    Map<String,String> FORK = Map.ofEntries(
            Map.entry("1","1"),
            Map.entry("2","2")

    );
}