package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Stack;

import org.junit.After;
import org.junit.Test;

public class SaisieRPNTest {

	
	InputStream stdin = System.in;
	
	@After
	public void tearDown() throws Exception {
		System.setIn(stdin);
	}

	@Test
	public void testCalculReussi() throws Exception {
		String e = "8\n4\n15\n12\n2\n+\n-\n*\n/\nquit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		
		assertEquals(s.calcul(), res);
	}
	
	@Test
	public void testCalculUndo() throws Exception {
		String e = "2\n4\n*\nundo\nquit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		res.push(4.);
		
		assertEquals(s.calcul(), res);
	}
}
