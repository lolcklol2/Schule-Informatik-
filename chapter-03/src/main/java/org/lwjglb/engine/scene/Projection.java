package org.lwjglb.engine.scene;

import org.joml.Matrix4f;

public class Projection {
    private static final float FOV = (float) Math.toRadians(60.0f);
    private static final float Z_FAR = 1000.f;
    private static final float Z_NEAR = 0.01f;

    private Matrix4f proMatrix;

    public Projection(int width, int height){
        proMatrix = new Matrix4f();
        updateProMatrix(width, height);
    }
    public Matrix4f getProjMatrix(){
        return proMatrix;
    }
    public void updateProMatrix(int width, int height){
       proMatrix.setPerspective(FOV, (float)  width / height, Z_NEAR, Z_FAR);
    }
}
