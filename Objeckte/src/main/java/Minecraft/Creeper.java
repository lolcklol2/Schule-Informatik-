package Minecraft;

public class Creeper extends Mob {
    int expDmg = 10;
    public Creeper(){
        this.hp = 8;
        this.type = "Creeper";
    }

    @Override
    public void attributeAusgeben() {
        System.out.println(hp);
        System.out.println(type);
        System.out.println(expDmg);
    }
}