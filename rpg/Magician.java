package rpg;

public class Magician extends Player {
    String classPlayer = "Magicien";
    public Magician(String name) {
        super(name);
    }

    @Override
    public void info() {
        {
            System.out.println("\nNom : " + this.name + "\nVotre classe : "+ this.classPlayer +"\nArgent : " + this.money + "\nVos armes : " + this.weapons + "\nVotre santé : " + this.HP + "\n");
        }
    }

    @Override
    public void special(Destructible e) {
        if(countTour() < 3){
            System.out.println("Vous ne pouvez pas utiliser votre compétence spéciale");
        }
        else{
            if (e instanceof Obstacle)
                System.out.println("\nVous ne pouvez pas utiliser votre compétence sur un obstacle");
            else if (e instanceof Monster) {
                System.out.println("\nCompétence spéciale activée : vous volez la santé du monstre avec votre magie et l'attaquez avec votre arme");
                e.hit(super.weapons.get(0).getDamage() * 2);
                super.HP += super.weapons.get(0).getDamage();
                System.out.println("Votre santé : " + super.HP);
                super.tour = 0;

            }

        }


}
}
