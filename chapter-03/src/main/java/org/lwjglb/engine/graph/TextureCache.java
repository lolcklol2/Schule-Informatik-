package org.lwjglb.engine.graph;

import java.util.*;

public class TextureCache {
    public static final String DEFAULT_TEXTURE = "";
    private Map<String, Texture> textureFilePathMap;

    public TextureCache(){
       textureFilePathMap = new HashMap<>();
       textureFilePathMap.put(DEFAULT_TEXTURE, new Texture(DEFAULT_TEXTURE));
    }
    public void cleanup(){
        textureFilePathMap.values().forEach(Texture::cleanup);
    }
    public Texture createTexture(String texturePath) {
        return textureFilePathMap.computeIfAbsent(texturePath, Texture::new);
    }
    public Texture getTexture(String texturePath){
        Texture texture = null;
        if (texturePath != null) {
            texture = textureFilePathMap.get(texturePath);
        }
        if (texture == null){
           texture = textureFilePathMap.get(DEFAULT_TEXTURE);
        }
        return texture;
    }
}
