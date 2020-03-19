package priscille.pglp_4_2;
/**
 * Classe Multiplication
 * implemente l'interface SpecificCommand.
 */
public class Multiplication implements SpecificCommand {
    /**
     * Application de l'opération multiplication.
     * @return Le résultat de l'opération
     */
    @Override
    public double apply(final double op1, final double op2) throws Exception {
        return op1 * op2;
    }
}
