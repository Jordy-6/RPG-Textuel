package rpg;

import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        String message;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choississez votre nom :");
        String name = scanner.nextLine();
        //String name = "a";
        System.out.println("Choississez votre classe :");
        System.out.println("1 - Warrior");
        System.out.println("2 - Magician");
        System.out.println("3 - Elfe");
        int choiceClass = scanner.nextInt();
        Player p = null;
        switch (choiceClass) {
            case 1 -> {
                p = new Warrior(name);
                System.out.println("Vous avez choisi la classe guerrier");
            }
            case 2 -> {
                p = new Magician(name);
                System.out.println("Vous avez choisi la classe magicien");
            }
            case 3 -> {
                p = new Elf(name);
                System.out.println("Vous avez choisi la classe elfe");
            }
            default -> System.out.println("Vous n'avez pas choisi de classe valide, recommencez");
        }
        System.out.println("Nom du joueur : " + p.getName() + "\n\n");
        WeaponStore store = new WeaponStore();
        store.printWeaponsList();
        System.out.println("Choississez une arme :");
        int choice = scanner.nextInt();
        p.buyWeapon(store.getWeapons(choice));
        if (p.getMoney() < store.getWeapons(choice).getPrice()) {
            System.out.println("Choississez une arme moins chère :");
            choice = scanner.nextInt();
            p.buyWeapon(store.getWeapons(choice));
        }
        switch (choice) {
            case 0 -> System.out.println("Vous avez choisi une hache\n");
            case 1 -> System.out.println("Vous avez choisi un pistolet\n");
            case 2 -> System.out.println("Vous avez choisi un arc\n");
            case 3 -> System.out.println("Vous avez choisi une épée\n");
            default -> {
                System.out.println("Vous n'avez pas choisi d'arme valide, recommencez");
                return;
            }
        }

        Map map = new Map();

        while (!map.verifSortie()) {
            map.afficherCarte();

                if ("O/P".equals(map.emplacementPerso()) || "#/P".equals(map.emplacementPerso())) {
                    Obstacle o = new Obstacle();
                    Monster m = new Monster();
                    if ("O/P".equals(map.emplacementPerso())) {
                        while (o.getLife() >= 0) {
                            System.out.println("Vous êtes sur un obstacle");
                            System.out.println("Voulez vous le détruire ? (y/n)");
                            String choice2 = scanner.nextLine();
                            if (choice2.equals("y") || choice2.equals("Y")) {
                                if(p.countTour() < 3){
                                    message = "Veuillez attendre 3 tour avant de l'utiliser";
                                }
                                else{
                                    message = "Compétence disponible";
                                }
                                System.out.println("Voulez vous utiliser votre compétence spéciale ? (y/n) " + message);
                                String choice3 = scanner.nextLine();
                                if (choice3.equals("y") || choice3.equals("Y")) {
                                    p.special(o);
                                    System.out.println("Vie de l'obstacle : " + o.getLife());
                                } else {
                                    System.out.println("Votre attaque a causé " + p.getWeapons().get(0).getDamage() + " de dégats");
                                    o.hit(p.getWeapons().get(0).getDamage());
                                    System.out.println("Vie de l'obstacle : " + o.getLife());
                                    p.countTour();
                                }

                            }
                            else {
                                map.afficherCarte();
                                System.out.println("Choississez une direction");
                                System.out.println("Vous pouvez vous déplacer vers le haut (z), le bas (s), la gauche (q) ou la droite (d)");
                                String move = scanner.nextLine();
                                switch (move) {
                                    case "z" -> p.goUp(map);
                                    case "s" -> p.goDown(map);
                                    case "q" -> p.goLeft(map);
                                    case "d" -> p.goRight(map);

                                    default -> System.out.println("Choississez une direction valide");

                                }
                                break;

                            }
                        }
                        if (o.getLife() <= 0) {
                            System.out.println("Vous avez détruit l'obstacle");
                            System.out.println("Vous avez gagné " + p.recompense() + " $ grace à votre victoire");
                            map.afficherCarte();
                            System.out.println("Vous pouvez vous déplacer vers le haut (z), le bas (s), la gauche (q) ou la droite (d)");
                            String move = scanner.nextLine();
                            switch (move) {
                                case "z" -> p.goUp(map);
                                case "s" -> p.goDown(map);
                                case "q" -> p.goLeft(map);
                                case "d" -> p.goRight(map);
                                default -> System.out.println("Choississez une direction");
                            }
                        }
                    } else {
                        System.out.println("Vous êtes sur un monstre");
                        while (m.getLife() > 0 && p.getHP() > 0) {

                            System.out.println("Voulez vous l'attaquer ? (y/n)");
                            String choice2 = scanner.nextLine();
                            if (choice2.equals("y") || choice2.equals("Y")) {
                                if(p.countTour() < 3){
                                     message = "Veuillez attendre 3 tour avant de l'utiliser";
                                }
                                else{
                                    message = "Compétence disponible";
                                }
                                System.out.println("Voulez vous utiliser votre compétence spéciale ? (y/n) " + message);
                                String choice3 = scanner.nextLine();
                                if (choice3.equals("y") || choice3.equals("Y")) {
                                    p.special(m);
                                   if(p instanceof Magician || p instanceof Warrior){
                                       System.out.println("Vie du monstre : " + m.getLife() + "\n");
                                   }
                                   else{
                                       System.out.println("Vie du monstre : " + m.getLife() + "\n");
                                       System.out.println("Le monstre vous attaque");
                                       p.hit(m.getDamage());
                                       System.out.println("Vie du joueur : " + p.getHP());
                                   }
                                } else {
                                    System.out.println("Votre attaque a causé " + p.getWeapons().get(0).getDamage() + " de dégats");
                                    m.hit(p.getWeapons().get(0).getDamage());
                                    System.out.println("Vie du monstre : " + m.getLife() + "\n");
                                    System.out.println("Le monstre vous attaque");
                                    p.hit(m.getDamage());
                                    System.out.println("Vie du joueur : " + p.getHP() + "\n");
                                    p.countTour();
                                }
                            } else {
                                map.afficherCarte();
                                System.out.println("Choississez une direction");
                                System.out.println("Vous pouvez vous déplacer vers le haut (z), le bas (s), la gauche (q) ou la droite (d)");
                                String move = scanner.nextLine();
                                switch (move) {
                                    case "z" -> p.goUp(map);
                                    case "s" -> p.goDown(map);
                                    case "q" -> p.goLeft(map);
                                    case "d" -> p.goRight(map);

                                    default -> System.out.println("Choississez une direction valide");

                                }
                                break;
                            }
                        }
                        if (m.getLife() <= 0) {
                            System.out.println("Vous avez détruit le monstre");
                            System.out.println("Vous avez gagné " + p.recompense() + " $ grace à votre victoire\n");
                            map.afficherCarte();
                            System.out.println("Vous pouvez vous déplacer vers le haut (z), le bas (s), la gauche (q) ou la droite (d)");
                            String move = scanner.nextLine();
                            switch (move) {
                                case "z" -> p.goUp(map);
                                case "s" -> p.goDown(map);
                                case "q" -> p.goLeft(map);
                                case "d" -> p.goRight(map);
                                default -> System.out.println("Choississez une direction");
                            }
                        }
                        else if(p.getHP() <= 0){
                            System.out.println("Vous êtes mort\n\n");
                            System.out.println("GAME OVER");
                            System.exit(0);
                        }
                    }

                } else {

                    System.out.println("Vous êtes sur une case vide");
                    System.out.println("Vous pouvez vous déplacer vers le haut (z), le bas (s), la gauche (q) ou la droite (d)");
                    System.out.println("Vous pouvez aussi voir le magasin d'arme (w),les infos de votre personnage(i), ou changer d'arme (c)\n");
                    String move = scanner.nextLine();
                    switch (move) {
                        case "z" -> p.goUp(map);
                        case "s" -> p.goDown(map);
                        case "q" -> p.goLeft(map);
                        case "d" -> p.goRight(map);
                        case "w" -> {
                            store.printWeaponsList();
                            System.out.println("Choississez une arme :");
                            int choice2 = scanner.nextInt();
                            p.buyWeapon(store.getWeapons(choice2));
                            System.out.println("Il vous reste " + p.getMoney() + " $");
                        }
                        case "i" -> p.info();
                        case "c" -> p.changeInventory();
                        default -> System.out.println("Choississez une direction");
                    }
                }
            }
        }


    }

