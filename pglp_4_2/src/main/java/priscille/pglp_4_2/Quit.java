package priscille.pglp_4_2;
/**
 * Classe Quit
 * implemente l'interface GeneriqueCommand.
 */
public class Quit implements GeneriqueCommand {
    /**
     * Application de la commande quit.
     */
    @Override
    public void apply() {
        System.out.println("Vous avez quitté.");
    }
}
