package Minecraft;

public class Tool extends Item {

    String name;

    int Halbarkeit;

    public Tool(int dmg){
        this.dmg = dmg;
        maxStack = 1;
    }
}
