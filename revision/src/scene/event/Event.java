package scene.event;

import elements.creature.hero.Hero;
import game.Game;
import scene.Scene;

public abstract class Event extends Scene {
    protected Hero HERO;
    protected int currWorld;
    protected int currEncounter;

    protected Event(Hero hero,int currWorld, int currEncounter , Game GAME){
        super(GAME);
        this.HERO = hero;
        this.currWorld = currWorld;
        this.currEncounter = currEncounter;
    }

    protected abstract String displayText_Display();

    protected String displayText_Choice() {
        return "Press ENTER to continue.";
    }

    public abstract void onInputReceived(String input);
}
