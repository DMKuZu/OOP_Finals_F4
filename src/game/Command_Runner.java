package game;

import elements.*;
import java.util.List;
import java.util.Random;

public class Command_Runner implements List_of_Commands{
    private Input_Processor input = new Input_Processor();
    private Prompt_Display prompt = new Prompt_Display();
    private int cmdIndex = -1;                                      ////mao ning index para sa list sa sulod sa master List
    private Chosen_Hero hero;
    private Current_Enemy enemy = new Saroian_Minions();///temporary, you need to make the choose area

    public void startMenu(){
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
                /*case "help":
                    help();
                    break;*/
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
                    battle("What do you want to do?");
                    break;
                case "mazupe":
                    hero = new Mazupe();
                    battle("What do you want to do?");
                    break;
                case "zipau":
                    hero = new Zipau();
                    battle("What do you want to do?");
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
                    battle("What do you want to do?");
                    break;
            }
        }
        else if(listIndex == 5){ /// potions choice
            switch(cmd){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "back":

                    break;
            }
        }
    }

//start commands
//************************************************************************************************************************************************************************************************
    private void start(){
        prompt.introPrompt();
        cmdIndex = input.getInput(2);

        if(cmdIndex != -1){ /// goes to character selection
            callCommand(2);
        }

    }

    private void atlas(){
        prompt.atlas();
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){ /// goes back to start menu
            startMenu();
        }
    }

    /*private void help(){                    ///figure out a way to be able to call help() in any part of the game and go back to the previous function call
        prompt.help();
        cmdIndex = input.getInput(2);

        if(cmdIndex != -1){ //just to make sure that i am not accessing incorrectly
            startMenu();
        }
    }*/

    private void credits(){
        prompt.credits();
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){ /// goes back to start menu
            startMenu();
        }
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
    private void battle(String message){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();

        prompt.encounter_battle_choice(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana, message);
        cmdIndex = input.getInput(3);

        if(cmdIndex != -1){ /// chooses what to do in the battle
            callCommand(3);
        }
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

        prompt.encounter_battle_skills(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,skill1_name,skill2_name,skill3_name,skill4_name,skill5_name);
        cmdIndex = input.getInput(4);

        if(cmdIndex != -1){ /// goes to choose skills
            callCommand(4);
        }
    }

    private void potions(){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();

        prompt.encounter_battle_potions(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,"helaing galing","mana padako","pagahi");
        cmdIndex = input.getInput(5);

        if(cmdIndex != -1){ /// goes to choose potions
            //callCommand(5);
            battle("What do you want to do?");
        }
    }

    private void flee(){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();

        prompt.encounter_battle_flee(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana);
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){ /// just shows a prompt and should go to choose menu
            ///create a choose menu method
            startMenu();
        }
    }

//hero vs enemy Skill  sequencecommands
//dapat ang mahitabo is it will affect stats of enemy and hero
//************************************************************************************************************************************************************************************************
    private void attack(int skill_choice){
        String enemy_name = enemy.getNAME();
        int enemy_hp = enemy.getHP();
        String hero_name = hero.getNAME();
        int hero_hp = hero.getHP();
        int hero_mana = hero.getMANA();
        String hero_msg = "",enemy_msg = "";

        switch(skill_choice){
            case 1:
                hero_msg = hero_skill1();
                enemy_msg = enemy_skill_chooser();
                break;
            case 2:
                hero_msg = hero_skill2();
                enemy_msg = enemy_skill_chooser();
                break;
            case 3:
                hero_msg = hero_skill3();
                enemy_msg = enemy_skill_chooser();
                break;
            case 4:
                hero_msg = hero_skill4();
                enemy_msg = enemy_skill_chooser();
                break;
            case 5:
                hero_msg = hero_skill5();
                enemy_msg = enemy_skill_chooser();
                break;
        }
        prompt.encounter_battle_attack(enemy_name,enemy_hp,hero_name,hero_hp,hero_mana,hero_msg,enemy_msg);
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){
            battle("What do you want to do?");
        }
    }

    private String enemy_skill_chooser(){
        Random rand = new Random();
        int choice = rand.nextInt(3)+1; // random value from 1-3

        int hero_hp = hero.getHP();
        int hero_p_def = hero.getP_DEF();
        int hero_m_def = hero.getM_DEF();
        int damage;

        switch(choice){
            case 1:
                damage = enemy.skill1(hero_p_def,hero_m_def);
                hero_hp = Math.max(hero_hp - damage, 0);
                hero.setHP(hero_hp);
                return enemy.getNAME() + " used " + enemy.getSKILL1_NAME() + ".";
            case 2:
                damage = enemy.skill2(hero_p_def,hero_m_def);
                hero_hp = Math.max(hero_hp - damage, 0);
                hero.setHP(hero_hp);
                return enemy.getNAME() + " used " + enemy.getSKILL2_NAME() + ".";
            case 3:
                damage = enemy.skill3(hero_p_def,hero_m_def);
                hero_hp = Math.max(hero_hp - damage, 0);
                hero.setHP(hero_hp);
                return enemy.getNAME() + " used " + enemy.getSKILL3_NAME() + ".";
        }
        return "naa kay mali nabuhat";
    }

    private String hero_skill1() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST1();

        int damage = hero.skill1(enemy_p_def,enemy_m_def);
        enemy_hp = Math.max(enemy_hp - damage, 0);
        enemy.setHP(enemy_hp);

        mana = Math.max(mana - mana_cost,0);
        hero.setMANA(mana);

        // will return the message back to the callCommand();
        return hero.getNAME() + " used " + hero.getSKILL1_NAME() + ".";
    }

    private String hero_skill2() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST2();

        int damage = hero.skill2(enemy_p_def,enemy_m_def);
        enemy_hp = Math.max(enemy_hp - damage, 0);
        enemy.setHP(enemy_hp);

        mana = Math.max(mana - mana_cost,0);
        hero.setMANA(mana);

        // will return the message back to the callCommand();
        return hero.getNAME() + " used " + hero.getSKILL2_NAME() + ".";
    }

    private String hero_skill3() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST3();

        int damage = hero.skill3(enemy_p_def,enemy_m_def);
        enemy_hp = Math.max(enemy_hp - damage, 0);
        enemy.setHP(enemy_hp);

        mana = Math.max(mana - mana_cost,0);
        hero.setMANA(mana);

        // will return the message back to the callCommand();
        return hero.getNAME() + " used " + hero.getSKILL3_NAME() + ".";
    }

    private String hero_skill4() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST4();

        int damage = hero.skill4(enemy_p_def,enemy_m_def);
        enemy_hp = Math.max(enemy_hp - damage, 0);
        enemy.setHP(enemy_hp);

        mana = Math.max(mana - mana_cost,0);
        hero.setMANA(mana);

        // will return the message back to the callCommand();
        return hero.getNAME() + " used " + hero.getSKILL4_NAME() + ".";
    }

    private String hero_skill5() {
        int enemy_hp = enemy.getHP();
        int enemy_p_def = enemy.getP_DEF();
        int enemy_m_def = enemy.getM_DEF();
        int mana = hero.getMANA();
        int mana_cost = hero.getMANA_COST5();

        int damage = hero.skill5(enemy_p_def,enemy_m_def);
        enemy_hp = Math.max(enemy_hp - damage, 0);
        enemy.setHP(enemy_hp);

        mana = Math.max(mana - mana_cost,0);
        hero.setMANA(mana);

        // will return the message back to the callCommand();
        return hero.getNAME() + " used " + hero.getSKILL5_NAME() + ".";
    }




}