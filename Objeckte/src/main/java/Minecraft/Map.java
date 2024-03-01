package Minecraft;

import java.util.Arrays;
import java.util.Random;

public class Map {
    long seed;
    int x;
    int y;
    int[][] map = new int[10][10];
    public Map(long seed){
        this.seed = seed;
    }
}
