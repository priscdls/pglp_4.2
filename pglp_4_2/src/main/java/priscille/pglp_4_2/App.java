package priscille.pglp_4_2;

/**
 * Classe App.
 */
public final class App {
    /**
     * Constructeur.
     */
    private App() {
    }
    /**
     * Début du programme.
     * @param args Les arguments donnés au démarrage de l'application
     */
    public static void main(final String[] args) throws Exception {
        SaisieRPN saisie = new SaisieRPN();
        saisie.calcul();
    }
}
