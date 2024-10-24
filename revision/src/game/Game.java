package game;


import elements.blessing.Blessing_Gacha;
import elements.creature.hero.Hero;
import gui.Frame;
import gui.panel.display.Display;
import gui.panel.input.Input_Panel;
import scene.event._0_World_Start;
import scene.event._9_World_End;
import scene.menu.*;

public class Game {
    private final Display DISPLAY;
    private final Display CHOICE;
    private final Input_Panel INPUT;

    private Hero HERO;
    private Blessing_Gacha REWARD;
    private final int currEncounter;
    private final int currWorld;

    public Game(){
        Frame FRAME = new Frame();
        this.DISPLAY = FRAME.getDISPLAY();
        this.CHOICE = FRAME.getCHOICE();
        this.INPUT = FRAME.getINPUT();

        this.REWARD = new Blessing_Gacha();
        currEncounter = 1;
        currWorld = 1;
        menu();
    }

    public void nextScene(GameScene scene){
        switch (scene){
            case MENU:
                menu();
                break;
            case CHOOSE_HERO:
                chooseHero();
                break;
            case START:
                start();
                break;
            case EVENT1:
                event1();
                break;
            case EVENT2:
                event2();
                break;
            case EVENT3:
                event3();
                break;
            case EVENT4:
                event4();
                break;
            case EVENT5:
                event5();
                break;
            case EVENT6:
                event6();
                break;
            case EVENT7:
                event7();
                break;
            case EVENT8:
                event8();
                break;
            case END:
                end();
                break;
            case TRANCE:
                trance();
                break;
            case SCENARIO:
                scenario();
                break;
            case ATLAS:
                atlas();
                break;
            case CREDITS:
                credits();
                break;
            case EXIT:
                exit();
                break;
        }
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


    private void menu(){
        new Menu(this);
    }
    private void chooseHero(){
        new Choose_Hero(this);
    }
    private void atlas(){
        new Atlas(this);
    }
    private void credits(){
        new Credits(this);
    }
    private void exit(){
        new Exit();
    }
    private void start(){
        new _0_World_Start(HERO,currWorld,this);
    }
    private void event1(){

    }
    private void event2(){

    }
    private void event3(){

    }
    private void event4(){

    }
    private void event5(){

    }
    private void event6(){

    }
    private void event7(){

    }
    private void event8(){

    }
    private void trance(){

    }
    private void scenario(){

    }
    private void end(){
        new _9_World_End(HERO,currWorld,this);
    }

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

/////////////////////////////////////////////////// trance stuff / offer bro

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
            case "offer":
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

        else if(HERO.getESSENCE() > 0 && HERO.getFAVOR().getFavorSize() < 3){    // offer pull
            prompt.trance_pulled(HERO.getFAVOR().offer());
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
            case "offer":
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

    private void battle_info(){
        prompt.battle_info(HERO);
        input.getInput("press to continue");

        encounter_battle_choice();
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
                HERO.apply_blessing(blessing);

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