package de.theholyexception.days2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

import de.theholyexception.DayTemplate;

public class Day05 extends DayTemplate {
	
	public Day05() throws Exception {
		super(2015, "05");
	}
	
	@Override
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));		
		String line = null;
		
		while((line = reader.readLine()) != null) {
			if (checkWordStepOne(line)) result++;
		}
		reader.close();
		super.first(); //255
	}
	
	@Override
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));		
		String line = null;
		
		while((line = reader.readLine()) != null) {
			if (checkWordStepTwo(line)) result++;
		}
		reader.close();
		super.second();
	}
	
	private boolean checkWordStepOne(String line) {
		return 
				line.matches(".*([aeiou].*){3}") &&
				Pattern.compile("(.)\\1++").matcher(line).find() &&
				!Pattern.compile("(ab|cd|pq|xy)").matcher(line).find();
	}
	
	private boolean checkWordStepTwo(String line) {
		return Pattern.compile("(..).*\\1").matcher(line).find() &&
				Pattern.compile("(.).\\1").matcher(line).find();
	}
	
}
