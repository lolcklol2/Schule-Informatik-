package org.lwjglb.engine;

import org.lwjglb.engine.scene.Scene;

public interface IGUIInstance {
    void drawGui();
    boolean handleGUIInput(Scene scene, Window window);
}
