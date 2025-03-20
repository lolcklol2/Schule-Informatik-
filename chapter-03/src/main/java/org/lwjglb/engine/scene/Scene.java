package org.lwjglb.engine.scene;

import org.lwjglb.engine.graph.Model;
import org.lwjglb.engine.graph.Model;
import org.lwjglb.engine.graph.TextureCache;

import java.util.*;

public class Scene {

    private Map<String, Model> modelMap;
    private Projection projection;
    private TextureCache textureCache;
    private Camera camera;

    public Scene(int width, int height) {
        camera = new Camera();
        modelMap = new HashMap<>();
        projection = new Projection(width, height);
        textureCache = new TextureCache();
    }
    public TextureCache getTextureCache(){
        return textureCache;
    }
    public void addEntity(Entity entity){
        String modelId = entity.getModelId();
        Model model = modelMap.get(modelId);
        if (model == null){
            throw new RuntimeException("Could not find model [" + modelId + "]");
        }
        model.getEntitiesList().add(entity);
    }
    public void addModel(Model model) {
        modelMap.put(model.getId(), model);
    }

    public void cleanup() {
        modelMap.values().forEach(Model::cleanup);
    }

    public Map<String, Model> getModelMap() {
        return modelMap;
    }
    public Projection getProjection(){
        return projection;
    }
    public void resize(int width, int height){
        projection.updateProMatrix(width, height);
    }

    public Camera getCamera() {
        return camera;
    }
}
