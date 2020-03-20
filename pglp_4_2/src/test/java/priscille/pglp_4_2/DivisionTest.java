package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DivisionTest {

	@Test
	public void test() throws Exception {
		Map<String, SpecificCommand> operation = new HashMap<String, SpecificCommand>();
		operation.put("/",new Division());
		double res = operation.get("/").apply(8,2);
		assertTrue(res == 4.);
	}
	
	@Test (expected=Exception.class)
	public void testDivZero() throws Exception {
		Map<String, SpecificCommand> operation = new HashMap<String, SpecificCommand>();
		operation.put("/",new Division());
		operation.get("/").apply(8,0);
	}

}
