package rpg;

public class Warrior extends Player{
    String classPlayer = "Combattant";
    public Warrior(String name) {
        super(name);
    }

    @Override
    public void special(Destructible e) {
        if(countTour() < 3){
            System.out.println("Vous ne pouvez pas utiliser votre compétence spéciale");
        }
        else{
            if(e instanceof Obstacle)
                System.out.println("\nCompetence spéciale activée : vous attaquez l'obstacle avec rage");
            else if (e instanceof Monster){
                System.out.println("\nCompetence spéciale activée : vous attaquez le monstre avec rage et l'empechez de vous attaquer");
            }
            e.hit(this.weapons.get(0).getDamage() * 3);
            super.tour = 0;
        }
    }

    @Override
    public void info() {
        {
            System.out.println("\nNom : " + this.name + "\nVotre classe : "+ this.classPlayer +"\nArgent : " + this.money + "\nVos armes : " + this.weapons + "\nVotre santé : " + this.HP + "\n");
        }
    }


}
