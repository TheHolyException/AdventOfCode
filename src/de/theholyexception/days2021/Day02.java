package de.theholyexception.days2021;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import de.theholyexception.DayTemplate;

public class Day02 extends DayTemplate {
	
	public Day02() throws Exception {
		super(2021, "02");
	}

	@Override
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String line = null;
		
		int posHorizontal = 0;
		int depth = 0;
		
		while((line = reader.readLine()) != null) {
			String[] cmd = line.split(" ");
			int value = Integer.parseInt(cmd[1]);
			
			
			switch(cmd[0]) {
			case "forward":
				posHorizontal += value;
				break;
				
			case "down":
				depth += value;
				break;
				
			case "up":
				depth -= value;
				break;
				
			default:
				System.err.println("Invalid State: " + cmd[0]);
				break;			
			}
			
			result = posHorizontal * depth;
			
		}
		
		reader.close();
		super.first();
	}

	@Override
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String line = null;
		
		int posHorizontal = 0;
		int depth = 0;
		int aim = 0;
		
		while((line = reader.readLine()) != null) {
			String[] cmd = line.split(" ");
			int value = Integer.parseInt(cmd[1]);
			
			
			switch(cmd[0]) {
			case "forward":
				posHorizontal += value;
				depth += value * aim;
				break;
				
			case "down":
				aim += value;
				break;
				
			case "up":
				aim -= value;
				break;
				
			default:
				System.err.println("Invalid State: " + cmd[0]);
				break;			
			}
			
			result = posHorizontal * depth;
			
		}

		reader.close();
		super.second();
		//1749524700
	}
	
}
