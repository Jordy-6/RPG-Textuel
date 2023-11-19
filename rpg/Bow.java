package rpg;

public class Bow extends Weapons{

    private static final double DOMMAGE = 11;
    private static final int PRICE = 11;
    public Bow(){
        super("bow",DOMMAGE,PRICE);
    }

    @Override
    public String ascii_art() {
        return " 4$$-.      *Archery*                           \n" +
                "           4   \".                                        \n" +
                "           4    ^.                                       \n" +
                "           4     $                                       \n" +
                "           4     'b                                      \n" +
                "           4      \"b.                                    \n" +
                "           4        $                                    \n" +
                "           4        $r                                   \n" +
                "           4        $F                                   \n" +
                "-$b========4========$b====*P=-                           \n" +
                "           4       *$$F                                  \n" +
                "           4        $$\"                                  \n" +
                "           4       .$F                                   \n" +
                "           4       dP                                    \n" +
                "           4      F                                      \n" +
                "           4     @                                       \n" +
                "           4    .                                        \n" +
                "           J.                                            \n" +
                "          '$$     ";
    }


}
