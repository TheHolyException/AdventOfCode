package de.theholyexception.days2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import de.theholyexception.DayTemplate;

public class Day07 extends DayTemplate {
		

	private static Map<String, String> circuit = new HashMap<>();
	
	public Day07() throws Exception {
		super(2015, "07");
	}
	
	@Override
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		
		while((line = reader.readLine()) != null) {
			String[] args = line.split(" -> ");
			circuit.put(args[1], args[0]);
		}
		
		result = getVariable("a");
		
		reader.close();
		super.first(); //16076
	}
	
	@Override
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		
		while((line = reader.readLine()) != null) {
			String[] args = line.split(" -> ");
			circuit.put(args[1], args[0]);
		}
		circuit.put("b", String.valueOf(firstResult));
		result = getVariable("a");

		reader.close();
		super.second();
	}

	private static Pattern pattern = Pattern.compile("\\d+");
	public int getVariable(String input) {
		if (pattern.matcher(input).matches()) return Integer.parseInt(input);
		int result = calculate(circuit.get(input));
		circuit.put(input, String.valueOf(result));
		return result;
	}
	
	public int calculate(String inst) {
		String[] args = inst.split(" ");
		if (args.length == 2) {
			return ~getVariable(args[1]) & 0xFFFF;
		} else if (args.length == 3) {
			int var1 = getVariable(args[0]);
			int var2 = getVariable(args[2]);
			
			switch(args[1]) {
			case "AND":
				return var1 & var2;
			case "OR":
				return var1 | var2;
			case "LSHIFT":
				return (var1 << var2) & 0xFFFF;
			case "RSHIFT":
				return (var1 >> var2) & 0xFFFF;
			default:
			}
		} else {
			return getVariable(inst);
		}
		throw new IllegalArgumentException("Invalid command: " + inst);
	}
	
}
