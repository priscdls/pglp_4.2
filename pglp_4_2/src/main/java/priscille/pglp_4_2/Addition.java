package priscille.pglp_4_2;
/**
 * Classe Addition
 * implementant l'interface SpecificCommand.
 */
public class Addition implements SpecificCommand {
    /**
     * Application de l'opération d'addition.
     * @return Le résultat de l'opération
     */
    @Override
    public double apply(final double op1, final double op2) {
        return op1 + op2;
    }
}
