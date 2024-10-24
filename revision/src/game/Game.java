package game;


import elements.blessing.Blessing_Gacha;
import elements.creature.hero.Hero;
import gui.Frame;
import gui.panel.display.Display;
import gui.panel.input.Input_Panel;
import scene.Scene;
import scene.event.*;
import scene.event.battle.*;
import scene.event.offer._10_Trance;
import scene.menu.*;

import java.util.HashMap;
import java.util.Map;

import static game.WhichScene.*;


public class Game {
    private final Display DISPLAY;
    private final Display CHOICE;
    private final Input_Panel INPUT;

    private Hero HERO;
    private final Blessing_Gacha REWARD;
    private int currEncounter;
    private int currWorld;

    private final Map<WhichScene, SceneFactory<? extends Scene>> SceneMap;

    public Game(){
        Frame FRAME = new Frame();
        this.DISPLAY = FRAME.getDISPLAY();
        this.CHOICE = FRAME.getCHOICE();
        this.INPUT = FRAME.getINPUT();

        this.REWARD = new Blessing_Gacha();
        currEncounter = 0;
        currWorld = 1;

        SceneMap = new HashMap<>();
        SceneMap.put(MENU, params -> new Menu(this));
        SceneMap.put(ATLAS, params -> new Atlas(this));
        SceneMap.put(CREDITS, params -> new Credits(this));
        SceneMap.put(CHOOSE_HERO, params -> new Choose_Hero(this));
        SceneMap.put(EXIT, params -> new Exit(this));

        SceneMap.put(START, params -> new _0_World_Start(HERO,currWorld,this));
        SceneMap.put(EVENT1, params -> new _1_Norm(HERO,currWorld,this));
        SceneMap.put(EVENT2, params -> new _2_Norm(HERO,currWorld,this));
        SceneMap.put(EVENT3, params -> new _3_Elite(HERO,currWorld,this));
        SceneMap.put(EVENT4, params -> new _4_Norm(HERO,currWorld,this));
        SceneMap.put(EVENT5, params -> new _5_Norm(HERO,currWorld,this));
        SceneMap.put(EVENT6, params -> new _6_Elite(HERO,currWorld,this));
        SceneMap.put(EVENT7, params -> new _7_Rest(HERO,this));
        SceneMap.put(EVENT8, params -> new _8_Boss(HERO,currWorld,this));
        SceneMap.put(THE_ENTITY, params -> new _69_The_Entity(HERO,this));
        SceneMap.put(END, params -> new _9_World_End(HERO,currWorld,this));

        SceneMap.put(TRANCE, params -> new _10_Trance(HERO,currWorld,currEncounter,this));
        SceneMap.put(SCENARIO, params -> new _11_Scenario(HERO,currWorld,currEncounter,this));
        SceneMap.put(VICTORY, params -> new _12_Message(HERO,true,currWorld,currEncounter,REWARD,this));
        SceneMap.put(DEFEAT, params -> new _12_Message(HERO,false,currWorld,currEncounter,null,this));

        nextScene(MENU);
    }

    public void nextScene(WhichScene scene, Object... params){
        SceneFactory<? extends Scene> factory = SceneMap.get(scene);

        Scene SCENE = factory.create(params);

        SCENE.displayText();
        INPUT.setInputListener(SCENE);
    }

    public Display getDISPLAY() {
        return DISPLAY;
    }
    public Display getCHOICE() {
        return CHOICE;
    }
    public Input_Panel getINPUT() {
        return INPUT;
    }

    public void setHERO(Hero hero){
        this.HERO = hero;
    }
    public void nextEncounter(){this.currEncounter++;}
    public void resetEncounter(){this.currEncounter = 0;}
    public void resetWorld(){this.currWorld = 1;}
    public void nextWorld(){this.currWorld++;}

/*////////////////////////////////////// The start of everything
    private void startMenu(){
        prompt.startMenu();
        String cmd = input.getInput("start menu");

        switch (cmd) {
            case "start":
                startMenu_start();

        }
    }

////////////////////////////////start menu

    private void startMenu_start(){
        prompt.introPrompt();
        String cmd = input.getInput("choose HERO");


        switch (cmd){
            case "radea":
                HERO = new Radea();
                break;
            case "mazupe":
                HERO = new Mazupe();
                break;
            case "zipau":
                HERO = new Zipau();
                break;
            default:
                HERO = new Supa();
        }

        REWARD = new Blessing_Gacha();
        currEncounter = 0;
        currWorld = 0;
        startWorld();
    }


/////////////////////////////////////////// exposition stuff

    private void startWorld(){
        currEncounter = 0;
        currWorld++;
        prompt.setWorldCtr(currWorld);

        prompt.startWorldPrompt();
        input.getInput("press to continue");

        encounterChooser();
    }

    private void endWorld(int essence, Blessing blessing){
        //dapat naay prompt ari after winning against boss
        HERO.refresh_world();
        startWorld();
    }

    private void endGame(){
        //htagi ug prompt ni
        System.out.println("game did not crash");
        startMenu();
    }

    private void scenario(){
        prompt.scenarioPrompt();
        input.getInput("press to continue");
    }

/////////////////////////////////////////////////// encounter chooser

    private void encounterChooser(){
        currEncounter++;
        prompt.setEncounterCtr(currEncounter);
        scenario();

        if(currEncounter % 2 != 0){
            boolean isNorm = (currEncounter != 5);
            if(currEncounter == 11){
                prompt.encounter_fork();
                String cmd = input.getInput("norm or elite");
                isNorm = cmd.equals("2");
            }

            this.ENEMY = new Enemy(HERO, currWorld, currEncounter,isNorm);
            encounter_battle_choice();
        }
        else{
            encounter_event();
        }
    }

/////////////////////////////////////////////////// trance stuff / obtained bro

    private void encounter_trance(){
        HERO.refresh_encounter();

        prompt.encounter_trance();
        input.getInput("press to continue");

        prompt.trance_offer(HERO.getESSENCE(), HERO.getFAVOR().getFavorSize());
        String cmd = input.getInput("trance");


        switch (cmd) {
            case "continue":
                prompt.trance_continue();
                input.getInput("press to continue");
                encounterChooser();
                break;
            case "obtained":
                trance_offer();
                break;
        }
    }

    private void trance_offer(){
        String cmd = "", msg = "";

        if(HERO.getESSENCE() == 0) {   //no more essence
            prompt.trance_notenough();
            input.getInput("press to continue");

            encounterChooser();
        }

        else if(HERO.getFAVOR().getFavorSize() == 3 && HERO.getESSENCE() > 0){   //exchange favors
            prompt.trance_fullinv(HERO.getFAVOR());
            HERO.useESSENCE();
            cmd = input.getInput("choose favor");

            switch (cmd){
                case "1":
                    msg = HERO.swapFavor(1);
                    break;
                case "2":
                    msg = HERO.swapFavor(2);
                    break;
                case "3":
                    msg = HERO.swapFavor(3);
                    break;
                default:
                    prompt.trance_continue();
                    input.getInput("press to continue");
                    encounterChooser();
                    break;
            }

            prompt.trance_exchanged(msg);
            input.getInput("press to continue");

            trance_offer();
        }

        else if(HERO.getESSENCE() > 0 && HERO.getFAVOR().getFavorSize() < 3){    // obtained pull
            prompt.trance_pulled(HERO.getFAVOR().obtained());
            HERO.useESSENCE();
            input.getInput("press to continue");
        }

        prompt.trance_offer(HERO.getESSENCE(), HERO.getFAVOR().getFavorSize());  // pull again
        cmd = input.getInput("trance");

        switch (cmd) {
            case "continue":
                prompt.trance_continue();
                input.getInput("press to continue");

                encounterChooser();
                break;
            case "obtained":
                trance_offer();
                break;
        }
    }

    private void encounter_event(){
        //encounter 12 will have you heal or replenish uses
//        encounter_trance();
        encounterChooser();
    }


////////////////////////////////////////////////////////// battle stuff

    private void encounter_battle_choice(){
        prompt.encounter_battle_choice(HERO, ENEMY);
        String cmd = input.getInput("battle");

        switch (cmd) {
            case "skills":
                battle_skills();
                break;
            case "favors":
                battle_favors();
                break;
            case "info":
                battle_info();
                break;
        }
    }

    private void battle_skills(){
        prompt.battle_skills(HERO, ENEMY);
        String cmd = "", msg = "";

        while(true){
            cmd = input.getInput("choose skill");
            switch (cmd) {
                case "1":
                    msg = HERO.use_skill(1, ENEMY);
                    break;
                case "2":
                    msg = HERO.use_skill(2, ENEMY);
                    break;
                case "3":
                    msg = HERO.use_skill(3, ENEMY);
                    break;
                case "4":
                    msg = HERO.use_skill(4, ENEMY);
                    break;
                case "5":
                    msg = HERO.use_skill(5, ENEMY);
                    break;
                case "back":
                    encounter_battle_choice();
                    break;
            }
            if(msg.contains("no uses")) System.out.println("|| Skill has no uses.");
            else break;
        }

        battle_sequence(msg);
    }

    private void battle_favors(){
        prompt.battle_favors(HERO, ENEMY);
        String cmd = "", msg = "";

        while(true) {
            cmd = input.getInput("choose favor");

            switch (cmd) {
                case "1":
                    msg = HERO.use_favor(1);
                    break;
                case "2":
                    msg = HERO.use_favor(2);
                    break;
                case "3":
                    msg = HERO.use_favor(3);
                    break;
                default:
                    encounter_battle_choice();
                    break;
            }
            if(msg.contains("no favors")) System.out.println("|| No favor at that slot.");
            else break;
        }

        battle_sequence(msg);
    }

    private void battle_sequence(String msg){
        String enemyType = ENEMY.getEnemyType();

        prompt.battle_hero_action(HERO, ENEMY,msg);
        input.getInput("press to continue");

        if(ENEMY.getCURRSTATS().getHP() <= 0){  //ENEMY ded
            battle_end(true,enemyType);
        }
        else {
            battle_enemy_attack();
        }
    }

    private void battle_enemy_attack(){
        String msg = ENEMY.attack(HERO);
        prompt.battle_enemy_action(HERO, ENEMY,msg);
        input.getInput("press to continue");

        String enemyType = ENEMY.getEnemyType();
        if(HERO.getCURRSTATS().getHP() <= 0){  //ENEMY ded
            battle_end(false,enemyType);
        }
        else {
            encounter_battle_choice();
        }
    }

    private void battle_end(boolean victory, String enemyType){
        int essence = (enemyType.equals("norm")) ? 1 :(enemyType.equals("elite")) ? 2:3;
        String enemyName = ENEMY.getNAME();
        ENEMY = null;

        if(victory){
            if(currWorld == 4){  //win against The Entity
                endGame();
            }
            else{
                Blessing blessing = REWARD.blessing_gacha(enemyType);

                HERO.addESSENCE(essence);
                HERO.addBLESSING(blessing);
                HERO.add_blessing(blessing);

                if(currEncounter >= 13){
                    //make it prompt sa endWorld kung ang boss imo napatay
                    // mudepend ni sa unsa na world ka currently
                    endWorld(essence,blessing);
                }

                else{
                    prompt.victoryPrompt(enemyName,essence,blessing);
                    input.getInput("press to continue");

                    encounter_trance();
                }
            }
        }
        else{
            prompt.defeatPrompt(enemyName);
            input.getInput("press to continue");

            startMenu();
        }
    }*/
}