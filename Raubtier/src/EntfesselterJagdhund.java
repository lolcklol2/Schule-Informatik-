public class EntfesselterJagdhund extends Jagdhund{
    String blutdurst;
    public void zerfetze(int zeitdauer){
        if (zeitdauer <= 5){
            System.out.println("er hat doch grad erst angefangen");
            return;
        }
        if (zeitdauer <= 10){
            System.out.println("dass ist gaschön Zerfetze");
            return;
        }
        System.out.println("man sied da nix mehr von der Beute");

    }
}
