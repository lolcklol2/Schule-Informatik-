package Minecraft;

import java.util.Random;

public class MinecraftWelt {
    int spawnX;
    int spawny;
    EndSiedlung[] siedlungen;
    long seed;
    int tageGespielt;
    static MinecraftWelt welt;
    Player player;

    EndSiedlung[] Sidungen;
    private MinecraftWelt(){
       siedlungen = EndSiedlung.endSiedlungsBuilder(100,seed);
       tageGespielt = 0;
       seed = (long) (Math.random()*10000);
       player = new Player("Stev");
    }
    public String findBiom(int x, int y){
        Random random = new Random();
        random.setSeed(x+y+seed);
        String[] biome = {"Desert","Savanna","Shrubland","Forest","Plains"};
        return biome[(int)(random.nextFloat() * biome.length)];
    }
    static public MinecraftWelt getWelt(){
        if (welt == null){
            welt = new MinecraftWelt();
            return welt;
        }
        else
            return welt;
    }

}
