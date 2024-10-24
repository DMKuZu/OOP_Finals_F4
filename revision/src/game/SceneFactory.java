package game;

import scene.Scene;

@FunctionalInterface
public interface SceneFactory<T extends Scene> {
    T create(Object... params);
}