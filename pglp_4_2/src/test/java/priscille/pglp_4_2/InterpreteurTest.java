package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class InterpreteurTest {

	@Test
	public void testUndo() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo undo = new Undo(pile);
		Interpreteur i = Interpreteur.init(undo);
		pile.push(2.);
		undo.ajoutUndo();
		pile.push(4.);
		undo.ajoutUndo();
		i.executeCommand("undo");
		
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		assertEquals(pile, res);
	}

	@Test (expected = Exception.class)
	public void testCommandeInvalide() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo undo = new Undo(pile);
		Interpreteur i = Interpreteur.init(undo);
		i.executeCommand("u");
	}
}
