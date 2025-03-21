package org.lwjglb.engine.graph;

import org.lwjglb.engine.scene.Entity;
import org.lwjglb.engine.scene.Scene;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;

public class SceneRender {

    private ShaderProgram shaderProgram;
    private UniformsMap uniformsMap;

    public SceneRender() {
        List<ShaderProgram.ShaderModuleData> shaderModuleDataList = new ArrayList<>();
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER));
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER));
        shaderProgram = new ShaderProgram(shaderModuleDataList);
        createUniforms();

    }
    private void createUniforms(){
        uniformsMap = new UniformsMap(shaderProgram.getProgramId());
        uniformsMap.createUniform("modelMatrix");
        uniformsMap.createUniform("projectionMatrix");
        uniformsMap.createUniform("txtSampler");
        uniformsMap.createUniform("viewMatrix");
        uniformsMap.createUniform("material.diffuse");
    }

    public void cleanup() {
        shaderProgram.cleanup();
    }


    public void render(Scene scene) {
        shaderProgram.bind();
        uniformsMap.setUniform("projectionMatrix", scene.getProjection().getProjMatrix());
        uniformsMap.setUniform("viewMatrix", scene.getCamera().getViewMatirx());
        uniformsMap.setUniform("txtSampler", 0);

        Collection<Model> models = scene.getModelMap().values();
        TextureCache textureCache = scene.getTextureCache();
        for (Model model : models){
            List<Entity> entities = model.getEntitiesList();
            for (Material material : model.getMaterialList()){
                uniformsMap.setUniform("material.diffuse", material.getDiffuseColor());
               Texture texture = textureCache.getTexture(material.getTexturePath());
               glActiveTexture(GL_TEXTURE0);
               texture.bind();
               for (Mesh mesh: material.getMeshList()){
                   glBindVertexArray(mesh.getVaoId());
                   for (Entity entity : entities){
                       uniformsMap.setUniform("modelMatrix", entity.getModelMatrix());
                       glDrawElements(GL_TRIANGLES, mesh.getNumVertices(), GL_UNSIGNED_INT, 0);
                   }
               }
            }
        }
        glBindVertexArray(0);
        shaderProgram.unbind();
    }
}