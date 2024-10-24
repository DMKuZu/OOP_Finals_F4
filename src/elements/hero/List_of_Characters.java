package elements.hero;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

///this is useless na


public interface List_of_Characters {
    Map<String, String> NAME_List = Map.ofEntries(
            Map.entry("radea","Radea"),
            Map.entry("mazupe","Mazupe"),
            Map.entry("zipau","Zipau"),
            Map.entry("superidolsirkhai","SupaIdolSirKhaiGumonan")
    );

    Map<String, Integer> HP_List = Map.ofEntries(
            Map.entry("radea",150),
            Map.entry("mazupe",200),
            Map.entry("zipau",100),
            Map.entry("superidolsirkhai",6969)
    );

    Map<String,Integer> ATK_List = Map.ofEntries(
            Map.entry("radea",20),
            Map.entry("mazupe",25),
            Map.entry("zipau",30),
            Map.entry("superidolsirkhai",6969)
    );

    Map<String,Integer> DEF_List = Map.ofEntries(
            Map.entry("radea",25),
            Map.entry("mazupe",35),
            Map.entry("zipau",15),
            Map.entry("superidolsirkhai",-1)
    );

    Map<String,Double> DODGE_List = Map.ofEntries(
            Map.entry("radea",0.20),
            Map.entry("mazupe",0.10),
            Map.entry("zipau",0.15),
            Map.entry("superidolsirkhai",1.0)
    );

    Map<String,Double> CRIT_List = Map.ofEntries(
            Map.entry("radea",0.10),
            Map.entry("mazupe",0.15),
            Map.entry("zipau",0.20),
            Map.entry("superidolsirkhai",1.0)
    );

    List<String> RADEA_SKILL_NAME = Arrays.asList(
            "Shadow Strike     ",
            "Psychic Drain     ",
            "Mental Fortress   ",
            "Thought Pierce    ",
            "Mass Hysteria     "
    );
    List<String> MAZUPE_SKILL_NAME = Arrays.asList(
            "Basic Strike       ",
            "Mountain Breaker   ",
            "War Cry            ",
            "Stone Skin         ",
            "Titan's Grip       "
    );
    List<String> ZIPAU_SKILL_NAME = Arrays.asList(
            "Quick Slash     ",
            "Flash Strike    ",
            "Wind Walker     ",
            "Bright Blade    ",
            "Blade Dance     "
    );
    List<String> SUPA_SKILL_NAME = Arrays.asList(
            "Reality Warp         ",
            "Dimensional Shift    ",
            "Entropy Wave         ",
            "Void Embrace         ",
            "Ultimate Erasure     "
    );
    Map<String,List<String>> SKILL_NAME_List = Map.ofEntries(
            Map.entry("radea",RADEA_SKILL_NAME),
            Map.entry("mazupe",MAZUPE_SKILL_NAME),
            Map.entry("zipau",ZIPAU_SKILL_NAME),
            Map.entry("superidolsirkhai",SUPA_SKILL_NAME)
    );



    List<Integer> RADEA_BASE_DMG = Arrays.asList(
            10,
            15,
            0,
            20,
            25
    );

    List<Integer> RADEA_TOTAL_USES = Arrays.asList(
            -1,
            20,
            15,
            10,
            5
    );

    List<String> RADEA_EFFECT = Arrays.asList(
            "hit",
            "weaken",
            "fortify",
            "stun",
            "silence"
    );




    List<Integer> MAZUPE_BASE_DMG = Arrays.asList(
            10,
            20,
            0,
            0,
            30
    );

    List<Integer> MAZUPE_TOTAL_USES = Arrays.asList(
            -1,
            20,
            15,
            10,
            5
    );

    List<String> MAZUPE_EFFECT = Arrays.asList(
            "hit",
            "frail",
            "empower",
            "fortify",
            "stun"
    );



    List<Integer> ZIPAU_BASE_DMG = Arrays.asList(
            10,
            15,
            0,
            20,
            25
    );

    List<Integer> ZIPAU_TOTAL_USES = Arrays.asList(
            -1,
            20,
            15,
            10,
            5
    );

    List<String> ZIPAU_EFFECT = Arrays.asList(
            "hit",
            "sharpen",
            "enshroud",
            "cleanse",
            "empower"
    );




    List<Integer> SUPA_BASE_DMG = Arrays.asList(
            10,
            15,
            20,
            25,
            30
    );

    List<Integer> SUPA_TOTAL_USES = Arrays.asList(
            -1,
            20,
            15,
            10,
            5
    );

    List<String> SUPA_EFFECT = Arrays.asList(
            "hit",
            "enshroud",
            "silence",
            "stun",
            "burn"
    );


    Map<String,List<Integer>> BASE_DMG_List = Map.ofEntries(
            Map.entry("radea",RADEA_BASE_DMG),
            Map.entry("mazupe",MAZUPE_BASE_DMG),
            Map.entry("zipau",ZIPAU_BASE_DMG),
            Map.entry("superidolsirkhai",SUPA_BASE_DMG)
    );
    Map<String,List<Integer>> TOTAL_USES_List = Map.ofEntries(
            Map.entry("radea",RADEA_TOTAL_USES),
            Map.entry("mazupe",MAZUPE_TOTAL_USES),
            Map.entry("zipau",ZIPAU_TOTAL_USES),
            Map.entry("superidolsirkhai",SUPA_TOTAL_USES)
    );
    Map<String,List<String>> EFFECT_List = Map.ofEntries(
            Map.entry("radea",RADEA_EFFECT),
            Map.entry("mazupe",MAZUPE_EFFECT),
            Map.entry("zipau",ZIPAU_EFFECT),
            Map.entry("superidolsirkhai",SUPA_EFFECT)
    );
}
