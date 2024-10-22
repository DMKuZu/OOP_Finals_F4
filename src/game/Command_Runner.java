package game;

import elements.enemy.Current_Enemy;
import elements.hero.Chosen_Hero;
import elements.hero.Mazupe;
import elements.hero.Radea;
import elements.hero.Zipau;
import elements.enemy.minions.Saroian_Minions;
import elements.potion.Potions_Inventory;

import java.util.List;
import java.util.Random;

public class Command_Runner implements List_of_Commands{
    private Input_Processor input = new Input_Processor();
    private Prompt_Display prompt = new Prompt_Display();
    private int cmdIndex = -1;                                      ////mao ning index para sa list sa sulod sa master List
    private Chosen_Hero hero;
    private int max_hero_hp;
    private int max_hero_mana;
    private Current_Enemy enemy;
    private Potions_Inventory pots;
    private Boolean current_status = false;
    private int status_effect_counter;


    public void startMenu(){
        enemy = new Saroian_Minions(); ///temporary, you need to make the choose area
        pots = new Potions_Inventory();
        prompt.startMenu();
        cmdIndex = input.getInput(1);

        if(cmdIndex != -1){  ///should go to start menu
            callCommand(1);
        }
    }

    private void callCommand(int listIndex){
        List<String> cmdList = master.get(listIndex);
        String cmd = cmdList.get(cmdIndex);
        /// masterIndex
        /// 0 - exit a choice command
        /// 1 - start menu commands
        /// 2 - characters
        /// 3 - battle commands
        /// 4 - skills commands
        /// 5 - potions commands

        if (listIndex == 1) { /// start menu
            switch(cmd){
                case "start":
                    start();
                    break;
                case "atlas":
                    atlas();
                    break;
                case "credits":
                    credits();
                    break;
                case "exit":
                    exit();
                    break;
            }
        }
        else if(listIndex == 2){ /// character selection
            // change the battle() to choose_area()
            switch(cmd){
                case "radea":
                    hero = new Radea();
                    max_hero_hp = hero.getCheck_HP();
                    max_hero_mana = hero.getCheck_MANA();
                    battle();
                    break;
                case "mazupe":
                    hero = new Mazupe();
                    max_hero_hp = hero.getCheck_HP();
                    max_hero_mana = hero.getCheck_MANA();
                    battle();
                    break;
                case "zipau":
                    hero = new Zipau();
                    max_hero_hp = hero.getCheck_HP();
                    max_hero_mana = hero.getCheck_MANA();
                    battle();
                    break;
            }
        }
        else if(listIndex == 3){  /// battle choice
            switch(cmd){
                case "skills":
                    skills();
                    break;
                case "potions":
                    potions();
                    break;
                case "flee":
                    flee();
                    break;
            }
        }
        else if(listIndex == 4){ /// skills choice
            switch(cmd){
                case "1":
                    attack(1);
                    break;
                case "2":
                    attack(2);
                    break;
                case "3":
                    attack(3);
                    break;
                case "4":
                    attack(4);
                    break;
                case "5":
                    attack(5);
                    break;
                case "back":
                    battle();
                    break;
            }
        }
        else if(listIndex == 5){ /// potions choice
            switch(cmd){
                case "1":
                    use_pot(1);
                    break;
                case "2":
                    use_pot(2);
                    break;
                case "3":
                    use_pot(3);
                    break;
                case "back":
                    battle();
                    break;
            }
        }
    }

//start commands
//************************************************************************************************************************************************************************************************
    private void start(){
        prompt.introPrompt();
        cmdIndex = input.getInput(2);

         /// goes to character selection
        callCommand(2);

    }

    private void atlas(){
        prompt.atlas();
        cmdIndex = input.getInput(0);

        /// goes back to start menu
        startMenu();

    }

    private void credits(){
        prompt.credits();
        cmdIndex = input.getInput(0);

        /// goes back to start menu
        startMenu();

    }

    private void exit(){ /// should end the game
        prompt.exit();
    }

//choose area commands
//***********************************************************************************************************************************************************************************************
    private void choose_area(){
        //prompt
    }

//Battle commands
//************************************************************************************************************************************************************************************************
    private void battle(){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();

        prompt.encounter_battle_choice(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana);
        cmdIndex = input.getInput(3);

        /// chooses what to do in the battle
        callCommand(3);

    }

    private void skills(){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();
        String skill1_name = hero.getSKILL1_NAME();
        String skill2_name = hero.getSKILL2_NAME();
        String skill3_name = hero.getSKILL3_NAME();
        String skill4_name = hero.getSKILL4_NAME();
        String skill5_name = hero.getSKILL5_NAME();
        int cost1 = hero.getMANA_COST1();
        int cost2 = hero.getMANA_COST2();
        int cost3 = hero.getMANA_COST3();
        int cost4 = hero.getMANA_COST4();
        int cost5 = hero.getMANA_COST5();

        prompt.encounter_battle_skills(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,skill1_name,skill2_name,skill3_name,skill4_name,skill5_name,cost1,cost2,cost3,cost4,cost5);
        cmdIndex = input.getInput(4);

        /// goes to choose skills
        callCommand(4);

    }

    private void potions(){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();

        String pot1_name = pots.get_pot(1).getNAME();
        String pot1_effect = pots.get_pot(1).getEffect();
        String pot1_stat = pots.get_pot(1).getStat_to_be_affected();

        String pot2_name = pots.get_pot(2).getNAME();
        String pot2_effect = pots.get_pot(2).getEffect();
        String pot2_stat = pots.get_pot(2).getStat_to_be_affected();

        String pot3_name = pots.get_pot(3).getNAME();
        String pot3_effect = pots.get_pot(3).getEffect();
        String pot3_stat = pots.get_pot(3).getStat_to_be_affected();

        String pot1,pot2,pot3;
        pot1 = pot1_name.equals("<None>") ? "<none>" : pot1_name + " = " + "+" + pot1_effect + " to hero's " + pot1_stat;
        pot2 = pot2_name.equals("<None>") ? "<none>" : pot2_name + " = " + "+" + pot2_effect + " to hero's " + pot2_stat;
        pot3 = pot3_name.equals("<None>") ? "<none>" : pot3_name + " = " + "+" + pot3_effect + " to hero's " + pot3_stat;

        prompt.encounter_battle_potions(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,pot1,pot2,pot3);
        cmdIndex = input.getInput(5);

        /// goes to choose potions
        callCommand(5);


    }

    private void flee(){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();

        prompt.encounter_battle_flee(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana);
        cmdIndex = input.getInput(0);

        /// just shows a prompt and should go to choose menu
        //create a choose menu method
        startMenu();
    }

//hero vs enemy Skill  sequence commands
//************************************************************************************************************************************************************************************************
    private void attack(int skill_choice){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();
        String hero_msg = "",enemy_msg = "";

        //for now ang hero jud maguna
        switch(skill_choice){
            case 1:
                hero_msg = hero_skill1();
                break;
            case 2:
                hero_msg = hero_skill2();
                break;
            case 3:
                hero_msg = hero_skill3();
                break;
            case 4:
                hero_msg = hero_skill4();
                break;
            case 5:
                hero_msg = hero_skill5();
                break;
        }

        //this is where the sequence of attacks would be checked
        prompt.encounter_battle_hero_action(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,hero_msg);
        cmdIndex = input.getInput(0);
        if(hero_msg.contains(("Not"))){  //this prompts the user that they have no mana
            skills();
        }
        else {
            enemy_hp = enemy.getHP();  //reset values para sa display
            hero_mana = hero.getMANA();


            if(enemy_hp <= 0){ //checks if namatay ang kalaban
                prompt.encounter_battle_victory(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana);
                cmdIndex = input.getInput(0);
                startMenu();  //change this to reward prompt
            }
            else {
                enemy_msg = enemy_skill_chooser();
                prompt.encounter_battle_enemy_attack(enemy_name, enemy_hp, hero_name, hero_hp, hero_mana, enemy_msg);
                cmdIndex = input.getInput(0);
                hero_hp = hero.getHP();

                if (hero_hp <= 0) {  //checks if namatay ka
                    prompt.encounter_battle_defeat(enemy_name, enemy_hp, hero_name, hero_hp, hero_mana);
                    cmdIndex = input.getInput(0);
                    startMenu(); //change this to you lose prompt
                }
                else {  //way namatay ug continue battle
                    battle();
                }
            }
        }
    }

    private String enemy_skill_chooser(){
        Random rand = new Random();
        int choice = rand.nextInt(3)+1; // random value from 1-3

        int hero_hp = hero.getHP();
        int hero_p_def = hero.getP_DEF();
        int hero_m_def = hero.getM_DEF();
        int damage;

        switch(choice){   //mudisplay rani sa unsay gigamit na attack sa enemy
            case 1:
                damage = enemy.skill1(hero_p_def,hero_m_def);
                hero_hp = Math.max(hero_hp - damage, 0);
                hero.setHP(hero_hp);
                return enemy.getNAME() + " used " + enemy.getSKILL1_NAME() + ". " + damage + " damage dealt.";
            case 2:
                damage = enemy.skill2(hero_p_def,hero_m_def);
                hero_hp = Math.max(hero_hp - damage, 0);
                hero.setHP(hero_hp);
                return enemy.getNAME() + " used " + enemy.getSKILL2_NAME() + ". " + damage + " damage dealt.";
            case 3:
                damage = enemy.skill3(hero_p_def,hero_m_def);
                hero_hp = Math.max(hero_hp - damage, 0);
                hero.setHP(hero_hp);
                return enemy.getNAME() + " used " + enemy.getSKILL3_NAME() + ". " + damage + " damage dealt.";
        }
        return "naa kay mali nabuhat";
    }

    private String hero_skill1() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST1();

        if(mana - mana_cost < 0 || mana == 0){  //checks if mana cost is more than the current mana
            return "Not enough Mana. Try again.";
        }
        else {
            int damage = hero.skill1(enemy_p_def,enemy_m_def);
            enemy_hp = Math.max(enemy_hp - damage, 0);
            enemy.setHP(enemy_hp);

            mana = Math.max(mana - mana_cost,0);
            hero.setMANA(mana);

            // will return the message back to the callCommand();
            return hero.getNAME() + " used " + hero.getSKILL1_NAME() + ". " + damage + " damage dealt.";
        }
    }

    private String hero_skill2() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST2();

        if(mana - mana_cost < 0 || mana == 0){  //checks if mana cost is more than the current mana
            return "Not enough Mana. Try again.";
        }
        else {
            int damage = hero.skill2(enemy_p_def,enemy_m_def);
            enemy_hp = Math.max(enemy_hp - damage, 0);
            enemy.setHP(enemy_hp);

            mana = Math.max(mana - mana_cost,0);
            hero.setMANA(mana);

            // will return the message back to the callCommand();
            return hero.getNAME() + " used " + hero.getSKILL2_NAME() + ". " + damage + " damage dealt.";
        }
    }

    private String hero_skill3() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST3();

        if(mana - mana_cost < 0 || mana == 0){  //checks if mana cost is more than the current mana
            return "Not enough Mana. Try again.";
        }
        else {
            int damage = hero.skill3(enemy_p_def,enemy_m_def);
            enemy_hp = Math.max(enemy_hp - damage, 0);
            enemy.setHP(enemy_hp);

            mana = Math.max(mana - mana_cost,0);
            hero.setMANA(mana);

            // will return the message back to the callCommand();
            return hero.getNAME() + " used " + hero.getSKILL3_NAME() + ". " + damage + " damage dealt.";
        }
    }

    private String hero_skill4() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST4();

        if(mana - mana_cost < 0 || mana == 0){  //checks if mana cost is more than the current mana
            return "Not enough Mana. Try again.";
        }
        else {
            int damage = hero.skill4(enemy_p_def,enemy_m_def);
            enemy_hp = Math.max(enemy_hp - damage, 0);
            enemy.setHP(enemy_hp);

            mana = Math.max(mana - mana_cost,0);
            hero.setMANA(mana);

            // will return the message back to the callCommand();
            return hero.getNAME() + " used " + hero.getSKILL4_NAME() + ". " + damage + " damage dealt.";
        }
    }

    private String hero_skill5() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST5();

        if(mana - mana_cost < 0 || mana == 0){  //checks if mana cost is more than the current mana
            return "Not enough Mana. Try again.";
        }
        else{
            int damage = hero.skill5(enemy_p_def,enemy_m_def);
            enemy_hp = Math.max(enemy_hp - damage, 0);
            enemy.setHP(enemy_hp);

            mana = Math.max(mana - mana_cost,0);
            hero.setMANA(mana);

            // will return the message back to the callCommand();
            return hero.getNAME() + " used " + hero.getSKILL5_NAME() + ". " + damage + " damage dealt.";
        }
    }

//potion commands
//************************************************************************************************************************************************************************************************
    private void use_pot(int potPos){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();
        int hero_p_atk = hero.getP_ATK();
        int hero_m_atk = hero.getM_ATK();
        int hero_p_def = hero.getP_DEF();
        int hero_m_def = hero.getM_DEF();
        String stat_to_affect = pots.get_pot(potPos).getStat_to_be_affected();
        int stat;
        switch (stat_to_affect){ //set up the value of the stat to buff
            case "HP":
                stat = hero_hp;
                break;
            case "MANA":
                stat = hero_mana;
                break;
            case "P_ATK":
                stat = hero_p_atk;
                break;
            case "M_ATK":
                stat = hero_m_atk;
                break;
            case "P_DEF":
                stat = hero_p_def;
                break;
            case "M_DEF":
                stat = hero_m_def;
                break;
            default:
                stat = 0;
        }

        String hero_msg;
        if(pots.get_pot(potPos).getNAME().equals("<None>")){ //prompts the user na walay potion
            hero_msg = "No potion to use";
        }
        else {
            hero_msg = "Used " + pots.get_pot(potPos).getNAME() + ".";
        }

        if(hero_hp == max_hero_hp && stat_to_affect.equals("HP")){
            hero_msg = "HP is full.";
            prompt.encounter_battle_hero_action(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,hero_msg);
            cmdIndex = input.getInput(0);
            potions();
        }
        if(hero_mana == max_hero_mana && stat_to_affect.equals("MANA")){
            hero_msg = "MANA is full.";
            prompt.encounter_battle_hero_action(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,hero_msg);
            cmdIndex = input.getInput(0);
            potions();
        }
        int buff_stat = pots.use_pot(potPos,stat);

        //kung maguse ug potion it is still your turn so bawia by dakoa ang stat sa enemy
        prompt.encounter_battle_hero_action(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,hero_msg);
        cmdIndex = input.getInput(0);
        switch (stat_to_affect){ //buff the stat
            case "HP":
                hero.setHP(Math.min(buff_stat,max_hero_hp));
                break;
            case "MANA":
                hero.setMANA(Math.min(buff_stat,max_hero_mana));
                break;
            case "P_ATK":
                hero.setP_ATK(buff_stat);
                break;
            case "M_ATK":
                hero.setM_ATK(buff_stat);
                break;
            case "P_DEF":
                hero.setP_DEF(buff_stat);
                break;
            case "M_DEF":
                hero.setM_DEF(buff_stat);
                break;
        }

        //since buff to hero paman ang mabuhat, back to potions lang sa una
        potions();
    }

}