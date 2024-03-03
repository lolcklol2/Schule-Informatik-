package Minecraft;

public class Main {
    public static void main(String[] args) {
        MinecraftWelt welt = MinecraftWelt.getWelt();
        Player player = welt.player;
        player.hotbar[0] = new Tool(4);
        player.selecteditem(0);
        Creeper creeper = new Creeper();
        System.out.println(creeper.hp);
        player.hit(creeper);
        System.out.println(creeper.hp);
        Map map = new Map(welt.seed);
    }
}
