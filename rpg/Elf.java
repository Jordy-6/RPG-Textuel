package rpg;

public class Elf extends Player{
    String classPlayer = "Elfe";
    public Elf(String name) {
        super(name);
    }

    @Override
    public void special(Destructible e) {
        if (e instanceof Obstacle){
            System.out.println("\nVous avez augmenté votre argent de 10$");
            super.money += 10;

        }
        else if (e instanceof Monster) {
            System.out.println("\nVous avez augmenté votre argent de 20$");
            super.money += 20;
        }
    }

    @Override
    public void info() {
        {
            System.out.println("\nNom : " + this.name + "\nVotre classe : "+ this.classPlayer +"\nArgent : " + this.money + "\nVos armes : " + this.weapons + "\nVotre santé : " + this.HP + "\n");
        }
    }
}
