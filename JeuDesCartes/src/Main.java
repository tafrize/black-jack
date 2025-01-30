import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.melanger();


        System.out.println("Cartes mélangées :");
        jeu.afficherCartes();

        // Distribution des cartes aux joueurs
        Map<String, List<Carte>> joueurs = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            joueurs.put("Joueur " + i, jeu.distribuer(13));
        }

        // Affichage des mains des joueurs
        for (Map.Entry<String, List<Carte>> entry : joueurs.entrySet()) {
            System.out.println("\n" + entry.getKey() + " :");
            for (Carte carte : entry.getValue()) {
                System.out.println(carte);
            }
        }

        // Simulation d'un pli
        System.out.println("\nTour de jeu : Chaque joueur joue une carte !");
        Map<String, Carte> cartesJouees = new HashMap<>();
        for (String joueur : joueurs.keySet()) {
            if (!joueurs.get(joueur).isEmpty()) {
                Carte carteJouee = joueurs.get(joueur).remove(0);
                cartesJouees.put(joueur, carteJouee);
                System.out.println(joueur + " joue " + carteJouee);
            }
        }

        // Détermination du vainqueur du pli
        String gagnant = null;
        Carte carteGagnante = null;
        for (Map.Entry<String, Carte> entry : cartesJouees.entrySet()) {
            if (carteGagnante == null || Jeu.comparerCartes(entry.getValue(), carteGagnante) > 0) {
                gagnant = entry.getKey();
                carteGagnante = entry.getValue();
            }
        }

        System.out.println("\nLe gagnant du pli est : " + gagnant);
    }
}
