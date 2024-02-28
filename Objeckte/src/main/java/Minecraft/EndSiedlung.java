package Minecraft;

import java.util.Random;

public class EndSiedlung {
    int x;
    int y;

    private EndSiedlung(){}
    public static EndSiedlung[] endSiedlungsBuilder(int n, long seed){
        Random random =new Random();
        random.setSeed(seed);
        EndSiedlung[] endSiedlungs1 = new EndSiedlung[n];
        for (int i = 0; i < endSiedlungs1.length; i++) {
            endSiedlungs1[i] = new EndSiedlung();
        }
        return endSiedlungs1;
    }
}
