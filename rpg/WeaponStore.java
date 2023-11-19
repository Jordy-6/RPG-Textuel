package rpg;

import java.util.ArrayList;

public class WeaponStore{
    ArrayList<Weapons> weaponsList;

    public WeaponStore() {
        this.weaponsList = new ArrayList<>();
        weaponsList.add(new Axe());
        weaponsList.add(new Pistol());
        weaponsList.add(new Bow());
        weaponsList.add(new Sword());
    }

    public void printWeaponsList() {
        System.out.println("Arme disponible :");
        int index = 0;
        for (Weapons w : this.weaponsList) {
            System.out.println("[" + index + "] " + w.toString() + "\n" + w.ascii_art());
            index++;
        }
    }


    public Weapons getWeapons(int i) {
        return weaponsList.get(i);
    }
}
