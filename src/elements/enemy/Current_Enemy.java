package elements.enemy;


import calculator.Skill_Calculator;
import elements.hero.mazupe.Mazupe;
import elements.hero.radea.Radea;
import elements.hero.zipau.Zipau;
import elements.value.Stats;
import elements.hero.Chosen_Hero;

import java.util.List;
import java.util.Random;


public class Current_Enemy {
    private String NAME;
    private Stats STATS;
    private Stats CURRSTATS;

    private List<String> SKILL_NAME;
    private List<Integer> BASE_DMG;

    private String enemyType;

    private Chosen_Hero BOSS;

    private final Skill_Calculator calc = new Skill_Calculator();

    public String getNAME() {
        return NAME;
    }
    public Stats getSTATS() {
        return STATS;
    }
    public Stats getCURRSTATS() {
        return CURRSTATS;
    }
    public String getSKILL_NAME(int skillNum){
        return SKILL_NAME.get(skillNum-1);
    }
    public String getEnemyType() {
        return enemyType;
    }

    protected void setNAME(String NAME) {
        this.NAME = NAME;
    }
    protected void setSKILL_NAME(List<String> SKILL_NAME) {
        this.SKILL_NAME = SKILL_NAME;
    }
    protected void setBASE_DMG(List<Integer> BASE_DMG) {
        this.BASE_DMG = BASE_DMG;
    }
    protected void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }


    public Current_Enemy(Chosen_Hero hero,int worldCtr, int encounterCtr, boolean isNorm){
        int normHP = (int) Math.floor(Math.min(hero.getSTATS().getHP() * 0.9, 300));
        int normATK = (int) Math.floor(Math.min(hero.getSTATS().getATK() * (0.8 + Math.random() * (1.2 - 0.8)), 300));
        int normDEF = (int) Math.floor(Math.min(hero.getSTATS().getDEF() * (0.2 + Math.random() * (0.4 - 0.2)), 300));
        double normDODGE = 0.02 + Math.random() * (0.05 - 0.02);
        double normCRIT = 0.02 + Math.random() * (0.07 - 0.02);

        int eliteHP = (int) Math.floor(Math.min(hero.getSTATS().getHP() * 1.2, 500));
        int eliteATK = (int) Math.floor(Math.min(hero.getSTATS().getATK() * (1.0 + Math.random() * (1.4 - 1.0)), 500));
        int eliteDEF = (int) Math.floor(Math.min(hero.getSTATS().getDEF() * (0.3 + Math.random() * (0.5 - 0.3)), 500));
        double eliteDODGE = 0.04 + Math.random() * (0.07 - 0.04);
        double eliteCRIT = 0.04 + Math.random() * (0.09 - 0.04);

        int bossHP = (int) Math.floor(Math.min(hero.getSTATS().getHP() * 1.5, 700));
        int bossATK = (int) Math.floor(Math.min(hero.getSTATS().getATK() * (1.2 + Math.random() * (1.6 - 1.2)), 700));
        int bossDEF = (int) Math.floor(Math.min(hero.getSTATS().getDEF() * (0.4 + Math.random() * (0.6 - 0.4)), 700));
        double bossDODGE = 0.06 + Math.random() * (0.09 - 0.06);
        double bossCRIT = 0.06 + Math.random() * (0.11 - 0.06);

        int finalHP = (int) Math.floor(Math.min(hero.getSTATS().getHP() * 1.8, 1000));
        int finalATK = (int) Math.floor(Math.min(hero.getSTATS().getATK() * (1.2 + Math.random() * (1.8 - 1.2)), 700));
        int finalDEF = (int) Math.floor(Math.min(hero.getSTATS().getDEF() * (0.5 + Math.random() * (0.7 - 0.5)), 700));
        double finalDODGE = 0.01 + Math.random() * (0.04 - 0.01);
        double finalCRIT = 0.01 + Math.random() * (0.04 - 0.01);


        STATS = new Stats(bossHP,bossATK,bossDEF,bossDODGE,bossCRIT);
        CURRSTATS = new Stats(bossHP,bossATK,bossDEF,bossDODGE,bossCRIT);

        switch(hero.getNAME().toLowerCase()){
            case "radea":
                switch (worldCtr) {
                    case 1:
                        if(encounterCtr == 13) BOSS = new Mazupe(STATS,CURRSTATS);
                        else new Quaceron_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 2:
                        if(encounterCtr == 13) BOSS = new Zipau(STATS,CURRSTATS);
                        else new Azrueian_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 3:
                        if(encounterCtr == 13) BOSS = new Radea(STATS,CURRSTATS);
                        else new Saroian_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 4:
                        new The_Entity().init(this);
                        break;
                }
                break;
            case "mazupe":
                switch (worldCtr) {
                    case 1:
                        if(encounterCtr == 13) BOSS = new Zipau(STATS,CURRSTATS);
                        else new Azrueian_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 2:
                        if(encounterCtr == 13) BOSS = new Radea(STATS,CURRSTATS);
                        else new Saroian_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 3:
                        if(encounterCtr == 13) BOSS = new Mazupe(STATS,CURRSTATS);
                        else new Quaceron_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 4:
                        new The_Entity().init(this);
                        break;
                }
                break;
            case "zipau":
            default:
                switch (worldCtr) {
                    case 1:
                        if(encounterCtr == 13) BOSS = new Radea(STATS,CURRSTATS);
                        else new Saroian_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 2:
                        if(encounterCtr == 13) BOSS = new Mazupe(STATS,CURRSTATS);
                        else new Quaceron_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 3:
                        if(encounterCtr == 13) BOSS = new Zipau(STATS,CURRSTATS);
                        else new Azrueian_Enemy(encounterCtr,isNorm).init(this);
                        break;
                    case 4:
                        new The_Entity().init(this);
                        break;
                }
                break;
        }

        switch (encounterCtr){
            case 1:
            case 3:
            case 7:
            case 9:
                STATS = new Stats(normHP,normATK,normDEF,normDODGE,normCRIT);
                CURRSTATS = new Stats(normHP,normATK,normDEF,normDODGE,normCRIT);
                break;
            case 5:
                STATS = new Stats(eliteHP,eliteATK,eliteDEF,eliteDODGE,eliteCRIT);
                CURRSTATS = new Stats(eliteHP,eliteATK,eliteDEF,eliteDODGE,eliteCRIT);
                break;
            case 11:
                if (isNorm) {
                    STATS = new Stats(normHP, normATK, normDEF, normDODGE, normCRIT);
                    CURRSTATS = new Stats(normHP, normATK, normDEF, normDODGE, normCRIT);
                } else {
                    STATS = new Stats(eliteHP, eliteATK, eliteDEF, eliteDODGE, eliteCRIT);
                    CURRSTATS = new Stats(eliteHP, eliteATK, eliteDEF, eliteDODGE, eliteCRIT);
                }
                break;
        }

        if(worldCtr == 4){
            STATS = new Stats(finalHP,finalATK,finalDEF,finalDODGE,finalCRIT);
            CURRSTATS = new Stats(finalHP,finalATK,finalDEF,finalDODGE,finalCRIT);
        }
    }

    public String attack(Chosen_Hero hero){
        Random rand = new Random();
        int skillNum; String msg = "";
        switch (enemyType){
            case "norm":
                skillNum = rand.nextInt(3)+1;
                msg = norm_skill(skillNum,hero);
                break;
            case "elite":
                skillNum = rand.nextInt(4)+1;
                msg = elite_skill(skillNum,hero);
                break;
            case "boss":
                skillNum = rand.nextInt(5)+1;
                msg = BOSS.boss_use_skill(skillNum,hero);
                break;
            case "final":
                skillNum = rand.nextInt(5)+1;
                msg = final_skill(skillNum,hero);
                break;
        }

        return msg;
    }

    private String norm_skill(int skillNum, Chosen_Hero hero){
        int damage = 0;
        boolean isAHit = false;
        boolean[] isCrit = new boolean[1];

        switch (skillNum){
            case 1:
                damage = calc.calculate_damage(BASE_DMG.get(0), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 2:
                damage = calc.calculate_damage(BASE_DMG.get(1), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 3:
                damage = calc.calculate_damage(BASE_DMG.get(2), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
        }

        int heroHP = hero.getCURRSTATS().getHP();
        if(isAHit){
            hero.getCURRSTATS().setHP(Math.max(heroHP - damage, 0));

            if(isCrit[0]) return "Used " + getSKILL_NAME(1) + ".\n|| CRIT! Dealt " + damage + " damage!";
            else return "Used " + getSKILL_NAME(1) + ".\n|| Dealt " + damage + " damage!";
        }
        else{
            return "Skill missed!";
        }
    }

    private String elite_skill(int skillNum, Chosen_Hero hero){
        int damage = 0;
        boolean isAHit = false;
        boolean[] isCrit = new boolean[1];

        switch (skillNum){
            case 1:
                damage = calc.calculate_damage(BASE_DMG.get(0), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 2:
                damage = calc.calculate_damage(BASE_DMG.get(1), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 3:
                damage = calc.calculate_damage(BASE_DMG.get(2), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 4:
                damage = calc.calculate_damage(BASE_DMG.get(3), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
        }

        int heroHP = hero.getCURRSTATS().getHP();
        if(isAHit){
            hero.getCURRSTATS().setHP(Math.max(heroHP - damage, 0));

            if(isCrit[0]) return "Used " + getSKILL_NAME(1) + ".\n|| CRIT! Dealt " + damage + " damage!";
            else return "Used " + getSKILL_NAME(1) + ".\n|| Dealt " + damage + " damage!";
        }
        else{
            return "Skill missed!";
        }
    }

    private String final_skill(int skillNum, Chosen_Hero hero){
        int damage = 0;
        boolean isAHit = false;
        boolean[] isCrit = new boolean[1];

        switch (skillNum){
            case 1:
                damage = calc.calculate_damage(BASE_DMG.get(0), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 2:
                damage = calc.calculate_damage(BASE_DMG.get(1), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 3:
                damage = calc.calculate_damage(BASE_DMG.get(2), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 4:
                damage = calc.calculate_damage(BASE_DMG.get(3), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
            case 5:
                damage = calc.calculate_damage(BASE_DMG.get(4), CURRSTATS.getATK(), CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(hero.getCURRSTATS().getDODGE());
                break;
        }

        int heroHP = hero.getCURRSTATS().getHP();
        if(isAHit){
            hero.getCURRSTATS().setHP(Math.max(heroHP - damage, 0));

            if(isCrit[0]) return "Used " + getSKILL_NAME(1) + ".\n|| CRIT! Dealt " + damage + " damage!";
            else return "Used " + getSKILL_NAME(1) + ".\n|| Dealt " + damage + " damage!";
        }
        else{
            return "Skill missed!";
        }
    }


}
