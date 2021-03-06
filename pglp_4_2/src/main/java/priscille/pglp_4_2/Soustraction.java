package priscille.pglp_4_2;
/**
 * Classe Soustraction
 * implemente l'interface SpecificCommand.
 */
public class Soustraction implements SpecificCommand {
    /**
     * Application de l'opération soustraction.
     * @return Le résultat de l'opération
     */
    @Override
    public double apply(final double op1, final double op2) throws Exception {
        return op1 - op2;
    }
}
