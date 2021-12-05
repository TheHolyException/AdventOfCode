package de.theholyexception.days2015;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import de.theholyexception.DayTemplate;

public class Day03 extends DayTemplate {

	public Day03() throws Exception {
		super(2015, "03");
	}
	
	@Override
	public void first() throws Exception {
		FileInputStream fis = new FileInputStream(file);
		int c = -1;
		List<Long> visited = new ArrayList<>();
		Santa santa = new Santa(0, 0);
		visited.add(0L);
		result = 1;
		while((c = fis.read()) != -1) {
			char cha = (char) c;
			switch (cha) {
			case '^':
				santa.y++;
				break;
			case '>':
				santa.x++;
				break;
			case 'v':
				santa.y--;
				break;
			case '<':
				santa.x--;
				break;
			default:
				System.err.println("Invalid Character: " + cha);
				break;
			}
			
			long location = santa.getLocation();
			if (!visited.contains(location)) {
				result++;
				visited.add(location);
			}
		}
		fis.close();
		super.first();
		//2572
	}
	
	@Override
	public void second() throws Exception {
		FileInputStream fis = new FileInputStream(file);
		int c = -1;
		List<Long> visited = new ArrayList<>();
		Santa[] santas = new Santa[] {new Santa(0,0), new Santa(0,0)};
		Santa santa;
		visited.add(0L);
		result = 1;
		int cnt = 0;
		while((c = fis.read()) != -1) {
			santa = santas[cnt++ & 1];
			char cha = (char) c;
			switch (cha) {
			case '^':
				santa.y++;
				break;
			case '>':
				santa.x++;
				break;
			case 'v':
				santa.y--;
				break;
			case '<':
				santa.x--;
				break;
			default:
				System.err.println("Invalid Character: " + cha);
				break;
			}
			
			long location = santa.getLocation();
			if (!visited.contains(location)) {
				result++;
				visited.add(location);
			}
		}
		fis.close();
		super.second();
	}
	

	public class Santa {
		
		int x;
		int y;
		
		public Santa(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public long getLocation() {
			return convertToLong(x, y);
		}
		
	}
	
	public static long convertToLong(int a, int b) {
		return (long)a << 32 | b & 0xFFFFFFFFL;
	}
	
	public static int[] convertToInt(long c) {
		int[] ints = new int[2];
		ints[0] = (int)(c >> 32);
		ints[1] = (int)c;
		return ints;
	}	
}
