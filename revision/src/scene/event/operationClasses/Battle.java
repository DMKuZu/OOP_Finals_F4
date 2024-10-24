package scene.event.operationClasses;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import game.Game;
import scene.Scene;
import scene.event.Event;

import static game.WhichScene.*;

public class Battle extends Scene {
    private final Hero HERO;
    private final Enemy ENEMY;
    private final Event EVENT;
    private final int CHOICE;

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
        MSG = HERO.useSkill(CHOICE,ENEMY);
        displayText();
    }

    private void heroFavor(){
        MSG = HERO.useFavor(CHOICE-5);
        displayText();
    }

    private void enemyAttack(){
        MSG = ENEMY.attack();
        displayText();
    }



    @Override
    protected String displayText_Display() {
        return String.format(
                """
                %s
                HP: %d | %d
                
                
                
                %s
                HP: %d | %d
                
                %s""",
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
        if(!enemyAttacked){
            ENEMY.inflictEffects();
            HERO.revertEffects();

            if(ENEMY.isDead()){
                GAME.nextScene(VICTORY);
            }
            else{
                enemyAttack();
                enemyAttacked = true;
            }
        }
        else {
            HERO.inflictEffects();
            ENEMY.revertEffects();

            if(HERO.isDead()){
                GAME.nextScene(DEFEAT);
            }
            else{
                EVENT.displayText();
                GAME.getINPUT().setInputListener(EVENT);
            }
        }
    }

}
