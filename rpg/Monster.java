package rpg;

public class Monster extends Destructible{
    private static final double HP = 100.;
    private static final double DAMAGE = 10.;
    public Monster() {
        super(HP);
    }

    //Attack the player
    public void attack(Player p){
        p.hit(DAMAGE);
    }

    public double getDamage(){
        return this.DAMAGE;
    }




}
