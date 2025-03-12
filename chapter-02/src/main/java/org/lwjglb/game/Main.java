package org.lwjglb.game;

import org.lwjglb.engine.*;
import org.lwjglb.engine.graph.Render;
import org.lwjglb.engine.scene.Scene;

public class Main implements IAppLogic{

    public static void main(String[] args) {
        Main main = new Main();
        Engine gameEng = new Engine("test", new Window.WindowOptions(), main);
        gameEng.start();
    }

    @Override
    public void cleanup() {

    }

    @Override
    public void init(Window window, Scene scene, Render render) {

    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis) {

    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {

    }
}