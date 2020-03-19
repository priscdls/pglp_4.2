package priscille.pglp_4_2;

import java.util.Stack;
/**
 * Classe Undo
 * implemente l'interface GeneriqueCommand.
 */
public class Undo implements GeneriqueCommand {
    /**
     * Pile qui stocke l'état actuel du calcul.
     */
    private Stack<Double> pileActuelle;
    /**
     * Pile qui stocke tout les états précedent
     * de la pileActuelle.
     */
    private Stack<Stack<Double>> undo;
    /**
     * Constructeur.
     * @param p La pile
     */
    public Undo(final Stack<Double> p) {
        this.pileActuelle = p;
        undo = new Stack<Stack<Double>>();
    }
    /**
     * Ajout du dernier état de pileActuelle dans Undo.
     */
    @SuppressWarnings("unchecked")
    public void ajoutUndo() {
        Stack<Double> clone = (Stack<Double>) pileActuelle.clone();
        undo.push(clone);
    }
    /**
     * Copie le dernier état de undo dans pileActuelle.
     */
    private void copieUndo() {
        for (double d : undo.lastElement()) {
            pileActuelle.push(d);
        }
    }
    /**
     * Applique le retour à l'etat précedent.
     */
    @Override
    public void apply() {
        if (!pileActuelle.isEmpty()) {
            while (!pileActuelle.isEmpty()) {
                pileActuelle.pop();
            }
            undo.pop();
            copieUndo();
        }
    }
}
