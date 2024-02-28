package Minecraft;

public abstract class Mob extends fightibel {
    String type;
    public void takedmg(int dmg){
        this.hp = hp - dmg;
    }

    public abstract void attributeAusgeben();
}
