package Scene;

import Game.Game;

import java.util.Scanner;

public abstract class Scene {
    protected Game game;
    protected boolean printed = false;
    protected Scanner sc = new Scanner(System.in);
    public Scene(Game game){
        this.game = game;
    }

    public abstract void getAction();
    public abstract void print();
    public final void update(){
        if(!printed){
            print();
            printed = true;
        }
        getAction();
    }
}
