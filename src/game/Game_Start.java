package game;

import elements.blessing.Blessing;
import elements.blessing.Blessing_Handler;
import elements.enemy.*;
import elements.hero.Chosen_Hero;


public class Game_Start {
    private final Input_Processor input = new Input_Processor();
    private final Prompt_Display prompt = new Prompt_Display();

    private Chosen_Hero hero;
    private Current_Enemy enemy;

    private int encounterCtr;
    private int worldCtr;

    private Blessing_Handler bless;

////////////////////////////////////// The start of everything my person
    public void startMenu(){
        prompt.startMenu();
        String cmd = input.getInput("start menu");

        switch (cmd) {
            case "start":
                startMenu_start();
                break;
            case "atlas":
                startMenu_atlas();
                break;
            case "credits":
                startMenu_credits();
                break;
            case "exit":
                startMenu_exit();
                break;
        }
    }

////////////////////////////////start menu

    private void startMenu_start(){
        prompt.introPrompt();
        String cmd = input.getInput("choose hero");

        hero = new Chosen_Hero(cmd);
        bless = new Blessing_Handler();
        encounterCtr = 0;
        worldCtr = 0;
        startWorld();
    }

    private void startMenu_atlas(){
        prompt.atlas();
        input.getInput("press to continue");

        startMenu();
    }

    private void startMenu_credits(){
        prompt.credits();
        input.getInput("press to continue");

        startMenu();
    }

    private void startMenu_exit(){
        prompt.exit();
        System.exit(0);
    }

/////////////////////////////////////////// exposition stuff

    private void startWorld(){
        encounterCtr = 0;
        worldCtr++;
        prompt.setWorldCtr(worldCtr);

        prompt.startWorldPrompt();
        input.getInput("press to continue");

        encounterChooser();
    }

    private void endWorld(int essence,Blessing blessing){
        //dapat naay prompt ari after winning against boss
        hero.refresh_world();
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
        encounterCtr++;
        prompt.setEncounterCtr(encounterCtr);
        scenario();

        if(encounterCtr % 2 != 0){
            boolean isNorm = (encounterCtr != 5);
            if(encounterCtr == 11){
                //setup ug prompt na nakakakitag norm or elite
                prompt.encounter_fork();
                String cmd = input.getInput("norm or elite");
                isNorm = cmd.equals("2"); //1 is elite and 2 is norm
            }

            enemy = new Current_Enemy(hero,worldCtr,encounterCtr,isNorm);
            encounter_battle_choice();
        }
        else{
            encounter_event();
        }
    }

/////////////////////////////////////////////////// trance stuff / gacha bro

    private void encounter_trance(){
        hero.refresh_encounter();

        prompt.encounter_trance();
        input.getInput("press to continue");

        prompt.trance_offer(hero.getESSENCE(),hero.getFAVOR().getFavorSize());
        String cmd = input.getInput("trance");


        switch (cmd) {
            case "continue":
                prompt.trance_continue();
                input.getInput("press to continue");
                encounterChooser();
                break;
            case "offer":
                trance_offer();
                break;
        }
    }

    private void trance_offer(){
        String cmd = "", msg = "";

        if(hero.getESSENCE() == 0) {   //no more essence
            prompt.trance_notenough();
            input.getInput("press to continue");

            encounterChooser();
        }

        else if(hero.getFAVOR().getFavorSize() == 3 && hero.getESSENCE() > 0){   //exchange favors
            prompt.trance_fullinv(hero.getFAVOR());
            hero.useESSENCE();
            cmd = input.getInput("choose favor");

            switch (cmd){
                case "1":
                    msg = hero.swapFavor(1);
                    break;
                case "2":
                    msg = hero.swapFavor(2);
                    break;
                case "3":
                    msg = hero.swapFavor(3);
                    break;
                default:
                    prompt.trance_continue();
                    input.getInput("press to continue");
                    encounterChooser();
                    break;
            }

            trance_exchanged(msg);
        }

        else if(hero.getESSENCE() > 0 && hero.getFAVOR().getFavorSize() < 3){    // gacha pull
            prompt.trance_pulled(hero.getFAVOR().gacha());
            hero.useESSENCE();
            input.getInput("press to continue");
        }

        prompt.trance_offer(hero.getESSENCE(),hero.getFAVOR().getFavorSize());  // pull again
        cmd = input.getInput("trance");

        switch (cmd) {
            case "continue":
                prompt.trance_continue();
                input.getInput("press to continue");

                encounterChooser();
                break;
            case "offer":
                trance_offer();
                break;
        }
    }

    private void trance_exchanged(String msg){
        prompt.trance_exchanged(msg);
        input.getInput("press to continue");

        trance_offer();
    }

    private void encounter_event(){
        //encounter 12 will have you heal or replenish uses
//        encounter_trance();
        encounterChooser();
    }


////////////////////////////////////////////////////////// battle stuff

    private void encounter_battle_choice(){
        prompt.encounter_battle_choice(hero,enemy);
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
        prompt.battle_skills(hero,enemy);
        String cmd = "", msg = "";

        while(true){
            cmd = input.getInput("choose skill");
            switch (cmd) {
                case "1":
                    msg = hero.use_skill(1, enemy);
                    break;
                case "2":
                    msg = hero.use_skill(2, enemy);
                    break;
                case "3":
                    msg = hero.use_skill(3, enemy);
                    break;
                case "4":
                    msg = hero.use_skill(4, enemy);
                    break;
                case "5":
                    msg = hero.use_skill(5, enemy);
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
        prompt.battle_favors(hero,enemy);
        String cmd = "", msg = "";

        while(true) {
            cmd = input.getInput("choose favor");

            switch (cmd) {
                case "1":
                    msg = hero.use_favor(1);
                    break;
                case "2":
                    msg = hero.use_favor(2);
                    break;
                case "3":
                    msg = hero.use_favor(3);
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

    private void battle_info(){
        prompt.battle_info(hero);
        input.getInput("press to continue");

        encounter_battle_choice();
    }

    private void battle_sequence(String msg){
        String enemyType = enemy.getEnemyType();

        prompt.battle_hero_action(hero,enemy,msg);
        input.getInput("press to continue");

        if(enemy.getCURRSTATS().getHP() <= 0){  //enemy ded
            battle_end(true,enemyType);
        }
        else {
            battle_enemy_attack();
        }
    }

    private void battle_enemy_attack(){
        String msg = enemy.attack(hero);
        prompt.battle_enemy_action(hero,enemy,msg);
        input.getInput("press to continue");

        String enemyType = enemy.getEnemyType();
        if(hero.getCURRSTATS().getHP() <= 0){  //enemy ded
            battle_end(false,enemyType);
        }
        else {
            encounter_battle_choice();
        }
    }

    private void battle_end(boolean victory, String enemyType){
        int essence = (enemyType.equals("norm")) ? 1 :(enemyType.equals("elite")) ? 2:3;
        String enemyName = enemy.getNAME();
        enemy = null;

        if(victory){
            if(worldCtr == 4){  //win against The Entity
                endGame();
            }
            else{
                Blessing blessing = bless.blessing_gacha(enemyType);

                hero.addESSENCE(essence);
                hero.addBLESSING(blessing);
                hero.apply_blessing(blessing);

                if(encounterCtr >= 13){
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
    }
}