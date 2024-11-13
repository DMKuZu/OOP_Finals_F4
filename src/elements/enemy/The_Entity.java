package elements.enemy;

import java.util.Arrays;
import java.util.List;

public class The_Entity {
    private final String name;
    private final List<String> SKILL_NAME;
    private final List<Integer> BASE_DMG;

    private final String enemyType;

    protected void init(Current_Enemy enemy){
        enemy.setNAME(name);
        enemy.setSKILL_NAME(SKILL_NAME);
        enemy.setBASE_DMG(BASE_DMG);
        enemy.setEnemyType(enemyType);
    }

    protected The_Entity(){
        name = "The Entity";
        SKILL_NAME = Arrays.asList(
                "Void of Extinction",
                "Reality Collapse",
                "Corruption Manifest",
                "Eternal Darkness",
                "World Ender"
        );
        BASE_DMG = Arrays.asList(
                10,
                15,
                20,
                25,
                30
        );
        enemyType = "final";
    }
}
