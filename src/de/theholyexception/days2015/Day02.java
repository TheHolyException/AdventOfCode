package de.theholyexception.days2015;

import java.io.BufferedReader;
import java.io.FileReader;

import de.theholyexception.DayTemplate;

public class Day02 extends DayTemplate {

	public Day02() throws Exception {
		super(2015, "02");
	}
	
	@Override
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] data = line.split("x");
			int l = Integer.parseInt(data[0]);
			int w = Integer.parseInt(data[1]);
			int h = Integer.parseInt(data[2]);
			
			int areaA = 2*l*w;
			int areaB = 2*w*h;
			int areaC = 2*h*l;
			
			int additionalMaterial =  Math.min(areaA, Math.min(areaB, areaC))/2;
			result += areaA + areaB + areaC + additionalMaterial;
		}
		
		reader.close();
		super.first();
	}
	
	@Override
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] data = line.split("x");
			int l = Integer.parseInt(data[0]);
			int w = Integer.parseInt(data[1]);
			int h = Integer.parseInt(data[2]);
			
			int minOne, minTwo;
			minOne = Math.min(l, w);
			if (minOne == l) minTwo = Math.min(h, w);
			else 				 minTwo = Math.min(h, l);
			
			result += 2*minOne + 2*minTwo + (l*w*h);
		}
		
		reader.close();
		super.second();
	}

}
