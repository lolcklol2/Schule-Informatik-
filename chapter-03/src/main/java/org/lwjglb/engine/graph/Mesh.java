package org.lwjglb.engine.graph;

import org.lwjgl.opengl.GL30;
import org.lwjgl.system.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;

import static org.lwjgl.opengl.GL30.*;

public class Mesh {

    private int numVertices;
    private int vaoId;
    private List<Integer> vboIdList;

    public int createVBO(float[] data,int sizeVektor,int index){
        int vboId = glGenBuffers();
        vboIdList.add(vboId);
        FloatBuffer buffer = MemoryUtil.memCallocFloat(data.length);
        buffer.put(0, data);
        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(index);
        glVertexAttribPointer(index, sizeVektor, GL_FLOAT, false, 0, 0);
        MemoryUtil.memFree(buffer);
        return vboId;
    }
    public int createEBO(int[] data){
        int eboId = glGenBuffers();
        vboIdList.add(eboId);
        IntBuffer indicesBuffer = MemoryUtil.memCallocInt(data.length);
        indicesBuffer.put(0, data);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);

        MemoryUtil.memFree(indicesBuffer);
        return eboId;
    }
    public Mesh(float[] positions, float[] textureCoordinates , int[] indices) {
        numVertices = indices.length;
        vboIdList = new ArrayList<>();

        vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);

        // Positions VBO
        int vboId = createVBO(positions, 3,0);

        // Texture VBO
        vboId = createVBO(textureCoordinates, 2, 1);


        // Index EBO
        vboId = createEBO(indices);
    }

    public void cleanup() {
        vboIdList.forEach(GL30::glDeleteBuffers);
        glDeleteVertexArrays(vaoId);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public final int getVaoId() {
        return vaoId;
    }
}
