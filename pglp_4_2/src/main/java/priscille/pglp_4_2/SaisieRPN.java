package priscille.pglp_4_2;

import java.util.Scanner;
import java.util.Stack;

public class SaisieRPN {
    /**
     * Pile d'opérande.
     */
    private Stack<Double> pile;
    /**
     * MoteurRPN pour effectuer les opérations.
     */
    private MoteurRPN moteur;
    /**
     * Interpréteur.
     */
    private Interpreteur interpreteur;
    /**
     * Scanner pour les entrées clavier.
     */
    private Scanner s;
    /**
     * Constructeur.
     */
    public SaisieRPN() {
        this.pile = new Stack<Double>();
        Undo undo = new Undo(pile);
        this.moteur = MoteurRPN.init(pile, undo);
        this.interpreteur = Interpreteur.init(undo);
    }
    /**
     * Execute le calcul sauf exception.
     * @throws Exception
     */
    public Stack<Double> calcul() throws Exception {
        s = new Scanner(System.in);
        double d;
        boolean continuer = true;
        String entrer = "";
        while (continuer) {
            try {
                d = s.nextDouble();
                moteur.addOperande(d);
            } catch (java.util.InputMismatchException e) {
                entrer = s.nextLine();
                try {
                    moteur.executeCommand(entrer);
                } catch (Exception m) {
                    try {
                        interpreteur.executeCommand(
                                entrer);
                    } catch (Exception i) {
                        System.err.println(
                                "Commande impossible");
                    }
                }
            }
            if (entrer.equalsIgnoreCase("quit")) {
                continuer = false;
            } else {
                System.out.print("Expression : "
                        + pile.toString() + "\n");
            }
        }
        s.close();
        System.out.println("Resultat : " + pile.toString());
		return pile;
    }
}
