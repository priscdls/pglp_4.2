package priscille.pglp_4_2;
/**
 * Interface SpecificCommand
 * héritant de l'interface Command.
 */
public interface SpecificCommand extends Command {
    /**
     * Fonction d'application des commandes.
     * @param a La première opérande
     * @param b La seconde opérande
     * @return Le résultat de l'opération
     * @throws Exception
     */
    double apply(double a, double b) throws Exception;
}
