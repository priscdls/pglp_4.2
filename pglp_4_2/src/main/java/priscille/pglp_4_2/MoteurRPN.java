package priscille.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Classe MoteurRPN.
 */
public class MoteurRPN {
	public Map<String, SpecificCommand> operation;
	public Stack<Double> pile;
	private Undo undo;
	
	private MoteurRPN(final Stack<Double> p, final Undo u) {
		this.operation = new HashMap<String, SpecificCommand>();
		this.pile = p;
		this.undo = u;
	}
	
	public void addCommand(final String name, final SpecificCommand command) {
		this.operation.put(name, command);
	}
	
	public void addOperande(double d) {
		pile.push(d);
		undo.ajoutUndo();
	}
	
	public void executeCommand(final String name) throws Exception {
		if(operation.containsKey(name)) {
			if(pile.size() >= 2) {
				double op2 = pile.pop();
				double op1 = pile.pop();
				try {
					pile.push(operation.get(name).apply(op1, op2));
					undo.ajoutUndo();
				} catch (Exception e) {
					pile.push(op1);
					pile.push(op2);
				}
			}else {
				System.err.println("Nombre d'opérandes insuffisant");
			}
		} else {
			throw new Exception();
		}
	}
	
	public static MoteurRPN init(final Stack<Double> pile, final Undo undo) {
		MoteurRPN m = new MoteurRPN(pile, undo);
		m.addCommand("+", new Addition());
		m.addCommand("-", new Soustraction());
		m.addCommand("*", new Multiplication());
		m.addCommand("/", new Division());
		return m;
	}
}