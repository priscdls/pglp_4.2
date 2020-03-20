package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class UndoTest {

	@Test
	public void test() {
		
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		pile.push(2.);
		u.ajoutUndo();
		pile.push(4.);
		u.ajoutUndo();
		u.apply();
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		assertEquals(pile, res);
		
	}

}
