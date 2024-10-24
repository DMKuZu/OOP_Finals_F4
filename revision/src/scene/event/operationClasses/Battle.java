package scene.event.operationClasses;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import game.Game;
import scene.Scene;
import scene.event.Event;

import static game.WhichScene.*;

public class Battle extends Scene {
    private Hero HERO;
    private Enemy ENEMY;
    private Event EVENT;
    private int CHOICE;

    private String MSG;
    private boolean enemyAttacked;

    public Battle(int CHOICE,Hero hero, Enemy ENEMY, Game GAME, Event EVENT){
        super(GAME);
        this.CHOICE = CHOICE;
        this.HERO = hero;
        this.ENEMY = ENEMY;
        this.EVENT = EVENT;
        this.MSG = "";
        this.enemyAttacked = false;

        GAME.getINPUT().setInputListener(this);
    }

    public void doBattle(){
        if(CHOICE < 6) {
            heroAttack();
        }
        else{
            heroFavor();
        }
    }

    private void heroAttack(){
        MSG = HERO.use_skill(CHOICE,ENEMY);
        displayText();
    }

    private void heroFavor(){
        MSG = HERO.use_favor(CHOICE-5);
        displayText();
    }

    private void enemyAttack(){
        MSG = ENEMY.attack();
        displayText();
    }



    @Override
    protected String displayText_Display() {
        return String.format(
                "%s\n" +
                "HP: %d | %d\n\n\n\n" +
                "%s\n" +
                "HP: %d | %d\n\n" +
                "%s",
                ENEMY.getNAME(),
                ENEMY.getCURRSTATS().getHP(), ENEMY.getSTATS().getHP(),
                HERO.getNAME(),
                HERO.getCURRSTATS().getHP(), HERO.getSTATS().getHP(),
                MSG
        );
    }

    @Override
    protected String displayText_Choice() {
        return "Press ENTER to Continue.";
    }

    @Override
    public void onInputReceived(String input) {
        switch (input.toLowerCase()) {
            case "":
                if(!enemyAttacked){
                    if(ENEMY.getCURRSTATS().getHP() <= 0){
                        GAME.nextScene(VICTORY);
                    }
                    else{
                        enemyAttack();
                        enemyAttacked = true;
                    }
                }
                else {
                    if(HERO.getCURRSTATS().getHP() <= 0){
                        GAME.nextScene(DEFEAT);
                    }
                    else{
                        EVENT.displayText();
                        GAME.getINPUT().setInputListener(EVENT);
                    }
                }
                break;
            default:
                System.out.println("Invalid input: " + input);
                break;
        }
    }

}
