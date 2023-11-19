package rpg;

public class Pistol extends Weapons{
    private static final double DOMMAGE = 35;
    private static final int PRICE = 70;
    public Pistol(){
        super("pistol",DOMMAGE,PRICE);
    }

    @Override
    public String ascii_art() {
        return " +--^----------,--------,-----,--------^-,\n" +
                " | |||||||||   `--------'     |          O\n" +
                " `+---------------------------^----------|\n" +
                "   `\\_,---------,---------,--------------'\n" +
                "     / XXXXXX /'|       /'\n" +
                "    / XXXXXX /  `\\    /'\n" +
                "   / XXXXXX /`-------'\n" +
                "  / XXXXXX /\n" +
                " / XXXXXX /\n" +
                "(________(                \n" +
                " `------'   ";
    }


}
