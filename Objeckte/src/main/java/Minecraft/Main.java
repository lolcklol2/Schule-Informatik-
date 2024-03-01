package Minecraft;

public class Main {
    public static void main(String[] args) {
        MinecraftWelt welt = MinecraftWelt.getWelt();
        Player player = welt.player;
        player.setWohnung(10,20, welt.findBiom(10,20));
        player.hotbar[0] = new Tool(2,"test");
        player.selecteditem(0);
        Creeper testcreeper = new Creeper();
        System.out.println(testcreeper.hp);
        player.hit(testcreeper);
        System.out.println(testcreeper.hp);
        Map map = new Map(11);
    }
}
