package Minecraft;

public class fightibel {
    int dmg;
    int hp;
    public void takehit(fightibel enemy){
        this.hp = this.hp - enemy.dmg;

    }
    public void hit(fightibel enemy){
        enemy.takehit(this);
    }
}
