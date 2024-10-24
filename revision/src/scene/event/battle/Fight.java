package scene.event.battle;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import game.Game;
import scene.event.Event;
import scene.event.operationClasses.Battle;

public abstract class Fight extends Event {
    protected Enemy ENEMY;

    protected Fight(Hero hero, Enemy ENEMY, int currWorld, int currEncounter, Game GAME) {
        super(hero, currWorld, currEncounter, GAME);
        this.ENEMY = ENEMY;
    }

    protected String displayText_Display(){
        return String.format(
                "%s\n" +
                "HP: %d | %d\n\n\n\n" +
                "%s\n" +
                "%s\n\n" +
                "SKILLS\n" +
                "%s\n\n" +
                "FAVORS\n" +
                "%s\n\n" +
                "BLESSINGS\n" +
                "%s",
                ENEMY.getNAME(),
                ENEMY.getCURRSTATS().getHP(), ENEMY.getSTATS().getHP(),
                HERO.getNAME(),
                HERO.statDesc(),
                HERO.skillDesc(),
                HERO.getFAVOR().favorDesc(),
                HERO.blessingDesc()
        );
    }

    protected String displayText_Choice() {
        return String.format(
                "Type the number of your command!\n\n" +
                        "SKILLS\n" +
                        "%s\n\n" +
                        "FAVORS\n" +
                        "%s\n\n",
                HERO.chooseSkill(),
                HERO.getFAVOR().choiceFavorDesc()
        );
    }

    public void onInputReceived(String input){
        switch (input.toLowerCase()) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
                int choice = Integer.parseInt(input);
                if(choice >= 1 && choice <=5 && HERO.hasUses(choice)  ||  choice>=6 && choice<=8 && (choice-5)<=HERO.getFAVOR().getFavorSize()){
                    System.out.println("Going into Battle...");
                    Battle battle = new Battle(choice,HERO, ENEMY,GAME,this);

                    battle.doBattle();
                }
                else System.out.println("Can't perform command...");
                break;
            default:
                System.out.println("Invalid input: " + input);
                break;
        }
    }
}
