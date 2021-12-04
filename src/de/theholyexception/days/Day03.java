package de.theholyexception.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day03 {
	
	private File file;
	
	public Day03(File file) throws Exception {
		this.file = file;
		first();
		second();
	}
	
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String l = null;
		int result = 0;		
		
		List<String> rows = new ArrayList<>();
		while((l = reader.readLine()) != null) rows.add(l);
		
		StringBuilder mcb = new StringBuilder();
		for (int column = 0; column < rows.get(0).length(); column++) {
			int mcbit = 0;
			for (int i = 0; i < rows.size(); i++) 
				if (rows.get(i).charAt(column) == '1') mcbit++;
			mcb.append(((double)mcbit / (double)rows.size()) > 0.5d ? 1 : 0);
		}
		
		int gamma = Integer.parseInt(mcb.toString(), 2);
		int epsilon = (gamma ^ ((1 << rows.get(0).length()) -1));
		result = gamma * epsilon;
		
		System.out.println("Day03 first result: " + result);
		//1071734
	}
	
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String l = null;
		int result = 0;
		
		List<String> rows = new ArrayList<>();
		while((l = reader.readLine()) != null) rows.add(l);

		int oxygenGenerator = Integer.parseInt(getCommonBits(false, new ArrayList<>(rows)), 2);
		int co2Scrubber = Integer.parseInt(getCommonBits(true, new ArrayList<>(rows)), 2);
		
		result = oxygenGenerator * co2Scrubber;		
		System.out.println("Day03 second result: " + result);
		//6124992
	}
	
	private String getCommonBits(boolean lsb, List<String> remaining) {
		StringBuilder builder = new StringBuilder();
		int size = remaining.get(0).length();
		for (int column = 0; column < size; column++) {
			int oneBits = 0;
			for (String line : remaining)
				if (line.charAt(column) == '1') oneBits++;
			
			char bit = ((
					(lsb && (oneBits < (double)remaining.size()/2)) || (!lsb && (oneBits >= (double)remaining.size()/2))
						) ? '1' : '0');
			if (remaining.size() == 1) {
				bit = remaining.get(0).charAt(column);
				remaining.clear();
			}
			List<String> toRemove = new ArrayList<>();
			for (String line : remaining)
				if (line.charAt(column) != bit) toRemove.add(line);
			remaining.removeAll(toRemove);
			builder.append(bit);
		}
		return builder.toString();
	}
}
