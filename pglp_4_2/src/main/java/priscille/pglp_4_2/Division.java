package priscille.pglp_4_2;
/**
 * Classe Division
 * implemente l'interface SpecificCommand.
 */
public class Division implements SpecificCommand {
    /**
     * Application de l'opération division.
     * @return Le résultat de l'opération
     */
    @Override
    public double apply(final double op1, final double op2) throws Exception {
        if (op2 == 0) {
            throw new Exception();
        }
        return op1 / op2;
    }
}
