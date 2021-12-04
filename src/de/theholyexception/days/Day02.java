package de.theholyexception.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Day02 {


	private File file;
	
	public Day02(File file) throws Exception {
		this.file = file;
		first();
		second();
	}
	
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String line = null;
		int result = 0;
		
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
		
		System.out.println("Day02 first result: " + result);
		//1692075
	}
	
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String line = null;
		int result = 0;
		
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
		System.out.println("Day02 second result: " + result);
		//1749524700
	}
	
}
