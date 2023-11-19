package rpg;

public abstract class Weapons {
    protected double damage;
    protected int price;
    protected String name;

    public Weapons(String name,double damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public double getDamage() {
        System.out.println(this.damage);
        return this.damage;

    }


    public int getPrice() {
        return this.price;
    }

    public String toString() {
        return this.name+ " damage : " + this.damage + " price : " + this.price + " $";
    }

    public abstract String ascii_art();

}
