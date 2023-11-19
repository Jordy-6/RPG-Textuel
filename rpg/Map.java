package rpg;

import java.util.Random;

public class Map {
    protected static String[][] matriceCarte;
    public Map() {
        matriceCarte = new String[6][6];  // Correction ici : utilisez la variable de classe plutôt qu'une variable locale
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Générer aléatoirement Monstre (#), Obstacle (O) ou un espace vide ( )
                int choix = random.nextInt(3);
                if (choix == 0) {
                    matriceCarte[i][j] = "#"; // Monstre
                } else if (choix == 1) {
                    matriceCarte[i][j] = "O"; // Obstacle
                } else {
                    matriceCarte[i][j] = " "; // Espace vide
                }
            }
        }
        matriceCarte[5][0] = "P"; // personnage
        matriceCarte[0][5] = "S"; // sortie
    }
    public void afficherCarte() {
        System.out.println("Carte :");
        System.out.println("------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print( "[ "+ matriceCarte[i][j] + " ]");
            }
            System.out.println();
        }
        System.out.println("------");
    }

    public boolean verifSortie() {
        boolean sortie = false;
        if("P".equals(matriceCarte[0][5])){
            sortie = true;
            System.out.println("Vous avez trouvé la sortie");
        }

        return sortie;
    }

    public String emplacementPerso() {
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
        return matriceCarte[x][y];
    }
}
