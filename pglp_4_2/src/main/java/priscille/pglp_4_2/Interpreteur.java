package priscille.pglp_4_2;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {
	public Map<String, GeneriqueCommand> commands;
	
	private Interpreteur() {
		this.commands = new HashMap<String, GeneriqueCommand>();
	}
	
	public void addCommand(String name, GeneriqueCommand com) {
		this.commands.put(name, com);
	}
	
	public void executeCommand(String name) {
		if(commands.containsKey(name)) {
			commands.get(name).apply();
		}
	}
	
	public static Interpreteur init() {
		Interpreteur i = new Interpreteur();
		i.addCommand("undo", );
		i.addCommand("quit", () -> System.exit(0));
	}
}
