package rpg;

import java.util.ArrayList;
import java.util.Scanner;

import static rpg.Map.matriceCarte;

public  abstract class Player implements  ActionsPlayer{
    protected String name;
    protected ArrayList<Weapons> weapons;
    protected double money;
    protected double HP;
    protected int tour = 0;


    public Player(String name) {
        this.name = name;
        this.money = 50;
        this.weapons = new ArrayList<Weapons>();
        this.HP = 100.;
    }

    public String getName() {
        return this.name;
    }

    public abstract void info();

    public double getMoney() {
        return money;
    }
    public ArrayList<Weapons> getWeapons() {
        return this.weapons;
    }

    public double getHP(){
        return this.HP;
    }


    @Override
    public void buyWeapon(Weapons w) {
        if (w.getPrice() <= this.money) {
            this.weapons.add(w);
            this.money -= w.getPrice();
        } else {
            System.out.println("Vous n'avez pas assez d'argent " +
                    "(Votre argent : " + this.money + " - prix de l'arme : " + w.getPrice());
        }
    }

    public void actualWeapon(){
        System.out.println("Votre arme actuelle : " + this.weapons.get(0).toString() + "\n");
    }

    public void changeInventory(){
        int index = 0;
        if(this.weapons.size() < 2){
            System.out.println("Vous n'avez pas assez d'arme pour la changer");
        } else {
            System.out.println(getWeapons());
            actualWeapon();
            System.out.println("Choisissez votre nouvelle arme : (0 correspond à la 1ère arme de votre inventaire et "+ (this.weapons.size()-1) +" correspond à la dernière arme de votre inventaire)");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            Weapons temp = this.weapons.get(0);
            this.weapons.set(0, this.weapons.get(choice));
            this.weapons.set(choice, temp);
            System.out.println("Votre nouvelle arme actuelle : " + this.weapons.get(0).toString() + "\n");
        }

    }

    @Override
    public void goLeft(Map map){
        int x = 0;
        int y = 0;
        for (int i = 0; i < matriceCarte.length; i++) {
            for (int j = 0; j < matriceCarte[i].length; j++) {
                if ("P".equals(matriceCarte[i][j]) ||
                        "O/P".equals(matriceCarte[i][j]) ||
                        "#/P".equals(matriceCarte[i][j])){
                    x = i;
                    y = j;
                }
            }
        }
        if (y == 0){
            System.out.println("Vous ne pouvez pas aller à gauche");
        } else {
            matriceCarte[x][y] = " " ;
            if("O".equals(matriceCarte[x][y-1])){
                matriceCarte[x][y-1] = "O/P";
            }
            else if("#".equals(matriceCarte[x][y-1])){
                matriceCarte[x][y-1] = "#/P";
            }
            else{
                matriceCarte[x][y-1] = "P";
            }
        }
    }
    @Override
    public void goRight(Map map){
        int x = 0;
        int y = 0;
        for (int i = 0; i < matriceCarte.length; i++) {
            for (int j = 0; j < matriceCarte[i].length; j++) {
                if ("P".equals(matriceCarte[i][j]) ||
                    "O/P".equals(matriceCarte[i][j]) ||
                    "#/P".equals(matriceCarte[i][j])){
                    x = i;
                    y = j;
                }
            }
        }
        if (y == 5){
            System.out.println("Vous ne pouvez pas aller à droite");
        } else {
            matriceCarte[x][y] = " " ;
            if("O".equals(matriceCarte[x][y+1])){
                matriceCarte[x][y+1] = "O/P";
            }
            else if("#".equals(matriceCarte[x][y+1])){
                matriceCarte[x][y+1] = "#/P";
            }
            else{
                matriceCarte[x][y+1] = "P";
            }
        }
    }
    @Override
    public void goUp(Map map){
        int x = 0;
        int y = 0;
        for (int i = 0; i < matriceCarte.length; i++) {
            for (int j = 0; j < matriceCarte[i].length; j++) {
                if ("P".equals(matriceCarte[i][j]) ||
                        "O/P".equals(matriceCarte[i][j]) ||
                        "#/P".equals(matriceCarte[i][j])){
                    x = i;
                    y = j;
                }
            }
        }
        if (x == 0){
            System.out.println("Vous ne pouvez pas aller en haut");
        } else {
            matriceCarte[x][y] = " " ;
            if("O".equals(matriceCarte[x-1][y])){
                matriceCarte[x-1][y] = "O/P";
            }
            else if("#".equals(matriceCarte[x-1][y])){
                matriceCarte[x-1][y] = "#/P";
            }
            else{
                matriceCarte[x-1][y] = "P";
            }
        }
    }
    @Override
    public void goDown(Map map){
        int x = 0;
        int y = 0;
        for (int i = 0; i < matriceCarte.length; i++) {
            for (int j = 0; j < matriceCarte[i].length; j++) {
                if ("P".equals(matriceCarte[i][j]) ||
                        "O/P".equals(matriceCarte[i][j]) ||
                        "#/P".equals(matriceCarte[i][j])){
                    x = i;
                    y = j;
                }
            }
        }
        if (x == 5){
            System.out.println("Vous ne pouvez pas aller en bas");
        } else {
            matriceCarte[x][y] = " " ;
            if("O".equals(matriceCarte[x+1][y])){
                matriceCarte[x+1][y] = "O/P";
            }
            else if("#".equals(matriceCarte[x+1][y])){
                matriceCarte[x+1][y] = "#/P";
            }
            else{
                matriceCarte[x+1][y] = "P";
            }
        }
    }


    public void hit(double damage) {
        this.HP -= damage;
    }

    public abstract void special(Destructible e);

    public int countTour(){
        return this.tour++;
    }

    public double recompense(){
        this.money += 10.;
         return 10.;
    };
}
