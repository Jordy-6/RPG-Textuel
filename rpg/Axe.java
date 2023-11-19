package rpg;

public class Axe extends Weapons{

    private static final double DOMMAGE = 13;
    private static final int PRICE = 15;

    public Axe(){
        super("axe",DOMMAGE,PRICE);
    }

    @Override
    public String ascii_art() {
        return " _,-,\n" +
                "T_  |\n" +
                "||`-'\n" +
                "||\n" +
                "||\n" +
                "~~";
    }




    /*
    * Pas obligatoire vu que getter deja présent dans la classe mère
    *  public static double getDamageM() {
       return DOMMAGE;
    }
    public static int getPriceAxe() {
        return PRICE;
    }
    *
    *
    *
    * */

}
