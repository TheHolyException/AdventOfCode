package de.theholyexception.days2021;

import java.io.FileInputStream;

import de.theholyexception.DayTemplate;

public class Day07 extends DayTemplate {
	
	public Day07() throws Exception {
		super(2021, "07");
	}
	
	@Override
	public void first() throws Exception {
		FileInputStream fis = new FileInputStream(file);
		String[] x = new String(fis.readAllBytes()).split(",");
		fis.close();
		
		result = Integer.MAX_VALUE;
		for (int i = 0; i < 1000; i++) {
			int sum = 0;
			for (String j : x) {
				int entry = Integer.parseInt(j);
				sum += Math.abs(entry - i);
			}
			if (result > sum) result = sum;
		}	
		super.first(); //343605
	}
	
	@Override
	public void second() throws Exception {
		FileInputStream fis = new FileInputStream(file);
		String[] x = new String(fis.readAllBytes()).split(",");
		fis.close();
		
		result = Integer.MAX_VALUE;
		for (int i = 0; i < 1000; i++) {
			int sum = 0;
			for (String j : x) {
				int entry = Integer.parseInt(j);
				sum += Math.abs(entry - i) * (Math.abs(entry - i)  + 1) /2;
			}
			if (result > sum) result = sum;
		}
		super.second(); //96744904
	}

}
