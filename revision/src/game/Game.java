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
        SceneMap.put(DEFEAT, params -> new _12_Message(HERO,false,currWorld,currEncounter,this));

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

}