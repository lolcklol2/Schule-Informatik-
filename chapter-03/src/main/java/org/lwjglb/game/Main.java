package org.lwjglb.game;


import imgui.*;
import imgui.flag.ImGuiCond;
import org.joml.Vector2f;
import org.lwjglb.engine.*;
import org.lwjglb.engine.graph.*;
import org.lwjglb.engine.scene.*;

import static org.lwjgl.glfw.GLFW.*;

public class Main implements IAppLogic , IGUIInstance{
    private static final float MOVENT_SPEED = 0.005f;
    private Entity cubeEntity;
    private Entity cubeEntity2;
    private float rotation;

    public static void main(String[] args) {
        Main main = new Main();
        Engine gameEng = new Engine("chapter-03", new Window.WindowOptions(), main);
        gameEng.start();
    }

    @Override
    public void drawGui(){
        ImGui.newFrame();
        ImGui.setNextWindowPos(0, 0, ImGuiCond.Always);
        ImGui.showDemoWindow();
        ImGui.endFrame();
        ImGui.render();
    }
    @Override
    public boolean handleGUIInput(Scene scene, Window window) {
        ImGuiIO imGuiIO = ImGui.getIO();
        //MouseInput mouseInput = window.getMouseInput();
        //Vector2f mousePos = mouseInput.getCurrentPos();
        //imGuiIO.addMousePosEvent(mousePos.x, mousePos.y);
        //imGuiIO.addMouseButtonEvent(0, mouseInput.isLeftButtonPressed());
        //imGuiIO.addMouseButtonEvent(1, mouseInput.isRightButtonPressed());

        return imGuiIO.getWantCaptureMouse() || imGuiIO.getWantCaptureKeyboard();
    }
    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        Model cubeModel = ModelLoader.loadModel("cube-model", "resources/Models/cube.obj", scene.getTextureCache());
        scene.addModel(cubeModel);
        cubeEntity = new Entity("cubeEntity", cubeModel.getId());
        cubeEntity.setPosition(0,0,-2);
        scene.addEntity(cubeEntity);

      //  scene.setGUIInstance(this);
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis, boolean inputConsumed) {
        if (inputConsumed){
            return;
        }
        float move = diffTimeMillis * MOVENT_SPEED;
        Camera camera = scene.getCamera();
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
        }
        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            camera.moveUp(move);
        } else if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveDown(move);
        }
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        rotation += 0;
        if (rotation> 360){
            rotation = 0;
        }
        cubeEntity.updateModelMatrix();
        cubeEntity.setRotation(0,1,0,(float) rotation);
    }
}
