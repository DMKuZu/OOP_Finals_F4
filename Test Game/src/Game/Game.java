package Game;

import Scene.*;

import java.util.ArrayList;

public class Game {
    private boolean running = true;
    private int currentSceneIndex = 0;
    private static ArrayList<Scene> scenes = new ArrayList<Scene>();
    public Game(){
        scenes.add(new Scene1(this));
        scenes.add(new Scene2(this));
        scenes.add(new Scene3(this));
        scenes.add(new Scene4(this));
    }

    private Scene getSurrentScene(){
        return scenes.get(currentSceneIndex);
    }

    private void gameloop(){
        while(running){
                getSurrentScene().update();
        }
    }

    public void nextScene(){
        if(currentSceneIndex == scenes.size() - 1){
            System.out.print("End of Scenes");
            return;
        }
        currentSceneIndex++;
    }

    public void prevScene(){
        if(currentSceneIndex == 0){
            System.out.print("End of Scenes");
            return;
        }
        currentSceneIndex--;
    }

    public void start(){
        gameloop();
    }
}
