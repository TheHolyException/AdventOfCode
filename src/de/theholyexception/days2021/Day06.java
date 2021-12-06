package de.theholyexception.days2021;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import de.theholyexception.DayTemplate;

public class Day06 extends DayTemplate {
	
	public Day06() throws Exception {
		super(2021, "06");
	}
	
	@Override
	public void first() throws Exception {
		
		result = processFish(80);
		
		super.first();//390923
	}
	
	@Override
	public void second() throws Exception {
		result = processFishOVER9000(256);
		super.second();//1749945484935
	}
	
	private int processFish(int days) throws Exception {
		List<Integer> fishes = new ArrayList<>();
		FileInputStream fis = new FileInputStream(file);
		int c = -1;
		while((c = fis.read()) != -1) {
			fishes.add(Integer.valueOf(String.valueOf((char)c)));
			fis.read();
		}
		
		for (int i = 1; i <= days; i ++) {
			int count = fishes.size();
			for (int x = 0; x < count; x ++) {
				int fish = fishes.get(x);
				if (fish-- == 0) {
					fish=6;
					fishes.add(8);
				}
				fishes.set(x, fish);
			}
//			System.out.println("After " + i + " days: " + fishes.size());
		}
		
		fis.close();
		return fishes.size(); 
	}
	
	private long processFishOVER9000(int days) throws Exception {
		List<Integer> fishes = new ArrayList<>();
		FileInputStream fis = new FileInputStream(file);
		int c = -1;
		while((c = fis.read()) != -1) {
			fishes.add(Integer.valueOf(String.valueOf((char)c)));
			fis.read();
		}
		

		Long[] number = new Long[] {0L,0L,0L,0L,0L,0L,0L,0L,0L};
		
		for (int fish : fishes) {
			number[fish]++;

		}
		
		for (int i = 0; i < days; i ++) {
			long dingens = number[0];
			number[0] = number[1];
			number[1] = number[2];
			number[2] = number[3];
			number[3] = number[4];
			number[4] = number[5];
			number[5] = number[6];
			number[6] = number[7] + dingens;
			number[7] = number[8];
			number[8] = dingens;
		}
		
		long res = 0;
		for (long l : number) {
			res+=l;
		}
		
		fis.close();
		return res;
	}

}
