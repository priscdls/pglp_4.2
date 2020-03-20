package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class MoteurRPNTest {

	@Test
	public void testMultiplication() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(2.);
		m.addOperande(4.);
		m.executeCommand("*");
		
		Stack<Double> res = new Stack<Double>();
		res.push(8.);
		
		assertEquals(pile, res);
	}
	
	@Test
	public void testAddition() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(2.);
		m.addOperande(4.);
		m.executeCommand("+");
		
		Stack<Double> res = new Stack<Double>();
		res.push(6.);
		
		assertEquals(pile, res);
	}
	
	@Test
	public void testSoustraction() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(6.);
		m.addOperande(4.);
		m.executeCommand("-");
		
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		
		assertEquals(pile, res);
	}
	
	@Test
	public void testDivision() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(8.);
		m.addOperande(4.);
		m.executeCommand("/");
		
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		
		assertEquals(pile, res);
	}
	
	@Test (expected=Exception.class)
	public void testDivisionZero() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(8.);
		m.addOperande(0.);
		m.executeCommand("/");
	}
	
	@Test (expected=Exception.class)
	public void testCommandeInconnu() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.executeCommand("e");
	}
	
	@Test (expected=Exception.class)
	public void testNbOperandeInvalide() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(8.);
		m.executeCommand("/");
	}
}
