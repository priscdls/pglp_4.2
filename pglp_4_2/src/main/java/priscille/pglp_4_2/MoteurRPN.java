package priscille.pglp_4_2;

import java.util.Stack;
/**
 * Classe MoteurRPN.
 */
public final class MoteurRPN extends Interpreteur {
    /**
     * Pile d'opérandes.
     */
    public Stack<Double> pile;
    /**
     * Retour en arrière.
     */
    private Undo undo;
    /**
     * Constructeur.
     * @param p La pile
     * @param u Le undo
     */
    private MoteurRPN(final Stack<Double> p, final Undo u) {
        super();
        this.pile = p;
        this.undo = u;
    }
    /**
     *  Fonction qui ajoute une opération a la liste.
     * @param name Nom de la commande
     * @param command Classe de la commande
     */
    public void addCommand(final String name, final SpecificCommand command) {
        this.commands.put(name, command);
    }
    /**
     * Ajoute une opérande a la pile.
     * @param op L'opérande a ajouter
     */
    public void addOperande(final double op) {
        pile.push(op);
        undo.ajoutUndo();
    }
    /**
     * Fonction qui execute l'opération.
     * @param name Nom de la commande
     * @throws Exception
     */
    public void executeCommand(final String name) throws Exception {
        if (commands.containsKey(name)) {
            if (pile.size() >= 2) {
                double op2 = pile.pop();
                double op1 = pile.pop();
                try {
                    pile.push(((SpecificCommand)
                            commands.get(name)).apply(op1, op2));
                    undo.ajoutUndo();
                } catch (Exception e) {
                    pile.push(op1);
                    pile.push(op2);
                    throw e;
                }
            } else {
                System.err.println("Nombre d'opérandes insuffisant");
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
    /**
     * Initialisation du MoteurRPN.
     * @param pile La pile d'opérandes
     * @param undo Le retour en arrière
     * @return Le moteur RPN initialisé
     */
    public static MoteurRPN init(final Stack<Double> pile, final Undo undo) {
        MoteurRPN m = new MoteurRPN(pile, undo);
        m.addCommand("+", new Addition());
        m.addCommand("-", new Soustraction());
        m.addCommand("*", new Multiplication());
        m.addCommand("/", new Division());
        return m;
    }
}
