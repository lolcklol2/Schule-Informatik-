package Minecraft;

public class Tool extends Item {

    String material;

    int Halbarkeit;

    public Tool(int dmg, String material){
        this.dmg = dmg;
        this.material = material;
        maxStack = 1;
    }
}
