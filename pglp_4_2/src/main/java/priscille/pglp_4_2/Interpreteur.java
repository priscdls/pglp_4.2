package priscille.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
/**
 * Classe Interpreteur.
 *
 */
public class Interpreteur {
    /**
     * Liste des commandes.
     */
    public Map<String, Command> commands;
    /**
     * Constructeur.
     */
    protected Interpreteur() {
        this.commands = new HashMap<String, Command>();
    }
    /**
     * Fonction qui ajoute une commande a la liste.
     * @param name Nom de la commande
     * @param com Classe de la commande
     */
    public void addCommand(final String name, final GeneriqueCommand com) {
        this.commands.put(name, com);
    }
    /**
     * Fonction qui execute la commande.
     * @param name Nom de la commande
     * @throws Exception
     */
    public void executeCommand(final String name) throws Exception {
        if (commands.containsKey(name)) {
            ((GeneriqueCommand) commands.get(name)).apply();
        } else {
            throw new Exception();
        }
    }
    /**
     * Initialisation de l'interpreteur.
     * @param undo Le retout en arrière
     * @return L'interpreteur initialisé
     */
    public static Interpreteur init(final Undo undo) {
        Interpreteur i = new Interpreteur();
        i.addCommand("undo", undo);
        i.addCommand("quit", new Quit());
        return i;
    }
}
