package de.theholyexception.days2021;

import java.io.BufferedReader;
import java.io.FileReader;

import de.theholyexception.DayTemplate;

public class Day05 extends DayTemplate {
	
	public Day05() throws Exception {
		super(2021, "05");
	}
	
	@Override
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		
		int[][] field = new int[999][999];
		
		while((line = reader.readLine()) != null) {
			String[] args = line.split(" -> ");
			int[] fromPos = new int[] {Integer.parseInt(args[0].split(",")[0]), Integer.parseInt(args[0].split(",")[1])};
			int[] toPos = new int[] {Integer.parseInt(args[1].split(",")[0]), Integer.parseInt(args[1].split(",")[1])};
			
			if (fromPos[0] == toPos[0] || fromPos[1] == toPos[1]) {
				for (int x = Math.min(fromPos[0], toPos[0]); x <= Math.max(fromPos[0], toPos[0]); x++) {
					for (int y = Math.min(fromPos[1], toPos[1]); y <= Math.max(fromPos[1], toPos[1]); y++) {
						field[x][y]+=1;
					}
				}
			}
		}
		
		for (int x = 0; x < field.length; x ++) {
			for (int y = 0; y < field.length; y++) {
				if (field[x][y] >= 2) result++;
			}
		}
		
		reader.close();
		super.first(); //5698
	}

	@Override
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
				
		int[][] field = new int[999][999];
		
		while((line = reader.readLine()) != null) {
			String[] args = line.split(" -> ");
			int[] fromPos = new int[] {Integer.parseInt(args[0].split(",")[0]), Integer.parseInt(args[0].split(",")[1])};
			int[] toPos = new int[] {Integer.parseInt(args[1].split(",")[0]), Integer.parseInt(args[1].split(",")[1])};
			
			if (!(fromPos[0] == toPos[0] || fromPos[1] == toPos[1])) {
				int x = fromPos[0];
				int y = fromPos[1];
				for (int i = 0; i < Math.max(fromPos[0], toPos[0]) - Math.min(fromPos[0], toPos[0])+1; i ++) {
					field[x][y]+=1;
					if (x > toPos[0]) x--;
					else x++;
					if (y > toPos[1]) y--;
					else y++;
				}
			} else {
				for (int x = Math.min(fromPos[0], toPos[0]); x <= Math.max(fromPos[0], toPos[0]); x++) {
					for (int y = Math.min(fromPos[1], toPos[1]); y <= Math.max(fromPos[1], toPos[1]); y++) {
						field[x][y]+=1;
					}
				}
			}
		}
		
		for (int x = 0; x < field.length; x ++) {
			for (int y = 0; y < field.length; y++) {
				if (field[x][y] >= 2) result++;
			}
		}
		
		reader.close();
		super.second();
	}

}
