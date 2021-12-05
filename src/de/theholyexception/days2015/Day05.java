package de.theholyexception.days2015;

import java.io.BufferedReader;
import java.io.FileReader;

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
			if (checkWord(line)) result++;
		}
		reader.close();
		super.first();
	}
	
	@Override
	public void second() throws Exception {
		super.second();
	}
	
	private boolean checkWord(String line) {
		return countVowels(line) >= 3 && letterTwiceInRow(line) && badWordChecks(line);
	}
	
	private int countVowels(String line) {
		int res = 0;
		for (int i = 0; i < line.length(); i ++) {
			switch (line.charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				res++;
				break;
			}
		}
		return res;
	}
	
	private boolean letterTwiceInRow(String line) {
		char last = (char)-1;
		for (int i = 0; i < line.length(); i ++) {
			if (last == line.charAt(i)) return true;
			last = line.charAt(i);
		}
		return false;
	}
	
	private static String[] badWords = new String[] {"ab", "cd", "pq", "xy"};
	private boolean badWordChecks(String line) {
		for (String word : badWords) {
			if (line.contains(word)) return false;
		}
		return true;
	}
	
}
