package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SoustractionTest {

	@Test
	public void test() throws Exception {
		Map<String, SpecificCommand> operation = new HashMap<String, SpecificCommand>();
		operation.put("-",new Soustraction());
		double res = operation.get("-").apply(6,2);
		assertTrue(res == 4.);
	}

}
