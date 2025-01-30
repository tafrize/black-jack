import java.util.*;
import java.util.List;
import java.util.ArrayList;


class Carte {
    private String valeur;
    private String couleur;

    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public String getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}

class Jeu {
    private final List<Carte> cartes;
    private static final String[] VALEURS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi", "As"};
    private static final String[] COULEURS = {"Trèfle", "Pique", "Cœur", "Carreau"};

    public Jeu() {
        cartes = new ArrayList<>();
        for (String couleur : COULEURS) {
            for (String valeur : VALEURS) {
                cartes.add(new Carte(valeur, couleur));
            }
        }
    }

    public void afficherCartes() {
        for (Carte carte : cartes) {
            System.out.println(carte.toString());
        }
    }

    public void melanger() {
        Collections.shuffle(cartes);
    }

    public List<Carte> distribuer(int nombreDeCartes) {
        List<Carte> main = new ArrayList<>(cartes.subList(0, nombreDeCartes));
        cartes.subList(0, nombreDeCartes).clear();
        return main;
    }

    public static int comparerCartes(Carte c1, Carte c2) {
        int indice1 = Arrays.asList(VALEURS).indexOf(c1.getValeur());
        int indice2 = Arrays.asList(VALEURS).indexOf(c2.getValeur());
        int comparaisonValeur = Integer.compare(indice1, indice2);
        if (comparaisonValeur != 0) {
            return comparaisonValeur;
        }

        int indiceCouleur1 = Arrays.asList(COULEURS).indexOf(c1.getCouleur());
        int indiceCouleur2 = Arrays.asList(COULEURS).indexOf(c2.getCouleur());

        return Integer.compare(indiceCouleur1, indiceCouleur2);
    }

    public boolean estVide() {
        return cartes.isEmpty();
    }
}

