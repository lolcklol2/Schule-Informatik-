package org.lwjglb.engine.graph;

import org.lwjgl.opengl.GL;
import org.lwjglb.engine.Window;
import org.lwjglb.engine.scene.Scene;

import static org.lwjgl.opengl.GL11.*;

public class Render {

    private GUIRender gUIRender;
    private SceneRender sceneRender;

    public Render(Window window) {
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        sceneRender = new SceneRender();
        gUIRender = new GUIRender(window);
    }

    public void cleanup() {
        sceneRender.cleanup();
        gUIRender.cleanup();
    }

    public void render(Window window, Scene scene) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glViewport(0, 0, window.getWidth(), window.getHeight());
        sceneRender.render(scene);
        gUIRender.render(scene);
    }
    public void resize(int width, int height) {
        gUIRender.resize(width, height);
    }
}