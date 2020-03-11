package priscille.pglp_4_2;

import java.util.HashMap;
import java.util.Map;

public class MoteurRPN {
public Map<String, SpecificCommand> operation;
	
	private MoteurRPN() {
		this.operation = new HashMap<String, SpecificCommand>();
	}
}