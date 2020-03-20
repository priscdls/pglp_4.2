package priscille.pglp_4_2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MultiplicationTest {

	@Test
	public void test() throws Exception {
		Map<String, SpecificCommand> operation = new HashMap<String, SpecificCommand>();
		operation.put("*",new Multiplication());
		double res = operation.get("*").apply(2,2);
		assertTrue(res == 4.);
	}

}
