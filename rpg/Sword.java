package rpg;

public class Sword extends Weapons{
    private static final double DOMMAGE = 20;
    private static final int PRICE = 25;
    public Sword(){
        super("sword",DOMMAGE,PRICE);
    }

    @Override
    public String ascii_art() {
        return "     /| ________________\n" +
                "O|===|* >________________>\n" +
                "      \\|";
    }

}
