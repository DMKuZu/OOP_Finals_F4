package elements.status;


import java.util.Map;

public interface List_of_Effects {
    //key == type

    Map<String,String> what_to_affect = Map.ofEntries(
            Map.entry("burn","HP"),
            Map.entry("regen","HP"),
            Map.entry("weaken","ATK"),
            Map.entry("empower","ATK"),
            Map.entry("frail","DEF"),
            Map.entry("fortify","DEF"),
            Map.entry("enshroud","DODGE"),
            Map.entry("sharpen","CRIT"),
            Map.entry("stun","turn"),
            Map.entry("silence","skills"),
            Map.entry("cleanse","effects")
    );

    Map<String,String> who_to_affect = Map.ofEntries(
            Map.entry("burn","opp"),
            Map.entry("regen","self"),
            Map.entry("weaken","opp"),
            Map.entry("empower","self"),
            Map.entry("frail","opp"),
            Map.entry("fortify","self"),
            Map.entry("enshroud","self"),
            Map.entry("sharpen","self"),
            Map.entry("stun","opp"),
            Map.entry("silence","opp"),
            Map.entry("cleanse","self")
    );

    Map<String,Double> value_of_effect = Map.ofEntries(
            Map.entry("burn",10.0),
            Map.entry("regen", 10.0),
            Map.entry("weaken",0.2),
            Map.entry("empower",0.2),
            Map.entry("frail",0.2),
            Map.entry("fortify",0.2),
            Map.entry("enshroud",50.0),
            Map.entry("sharpen",70.0),
            Map.entry("stun",0.0),
            Map.entry("silence",0.0),
            Map.entry("cleanse",0.0)
    );

    Map<String,Integer> turns_of_effect = Map.ofEntries(
            Map.entry("burn",3),
            Map.entry("regen", 3),
            Map.entry("weaken",3),
            Map.entry("empower",3),
            Map.entry("frail",3),
            Map.entry("fortify",3),
            Map.entry("enshroud",3),
            Map.entry("sharpen",3),
            Map.entry("stun",2),
            Map.entry("silence",3),
            Map.entry("cleanse",1)
    );
}
