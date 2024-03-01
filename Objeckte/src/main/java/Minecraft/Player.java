package Minecraft;

public class Player extends fightibel {
    int x;
    int y;
    String name;
    Item[][] inventar = new Item[3][10];
    Item[] hotbar = new Item[10];
    private Wohnung wohnung;

    private int indexOfSelectedItem;
    public Player(String name){
            this.hp = 20;
            this.name = name;
            selecteditem(0);
            x = 0;
            y = 0;
    }
    public void setWohnung(int x,int y,String biom){
        wohnung = new Wohnung(x,y,biom);
    }
    public void selecteditem(int slot){
        if (slot > 10){
            System.out.println("slot > 10 Error");
        }
        if(!(hotbar[slot] == null)) {
            this.dmg = hotbar[slot].dmg;
            return;
        }
        this.dmg = 1;
    }
    public Wohnung getWohnung() {
        return wohnung;
    }
}
