package de.theholyexception.days2015;

import java.io.BufferedReader;
import java.io.FileReader;

import de.theholyexception.DayTemplate;

public class Day06 extends DayTemplate {
	
	public Day06() throws Exception {
		super(2015, "06");
	}
	
	@Override
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		
		boolean[][] lights = new boolean[1000][1000];
		String[] args;
		int[] toPos, fromPos;
		String action;
		while((line = reader.readLine()) != null) {
			args = line.split(" ");
			fromPos = new int[] {Integer.parseInt(args[args.length-3].split(",")[0]), Integer.parseInt(args[args.length-3].split(",")[1])};
			toPos = new int[] {Integer.parseInt(args[args.length-1].split(",")[0]), Integer.parseInt(args[args.length-1].split(",")[1])};
			action = args[args.length-4];

			for (int x = fromPos[0]; x <= toPos[0]; x++) {
				for (int y = fromPos[1]; y <= toPos[1]; y++) {					
					switch (action) {
					case "off":
						if (lights[x][y]) lights[x][y] = false;
						break;
					case "on":
						if (!lights[x][y]) lights[x][y] = true;
						break;
					case "toggle":
						lights[x][y] = !lights[x][y];
						break;
					default:
						System.out.println("Invalid State: " + action);
						break;
					}
				}
			}
		}
		
		for (int x = 0; x < lights.length; x++) {
			for (int y = 0; y < lights.length; y++) {
				if (lights[x][y]) result++;
			}
		}
		
		reader.close();
		super.first(); //400410
	}
	
	@Override
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		
		int[][] lights = new int[1000][1000];
		String[] args;
		int[] toPos, fromPos;
		String action;
		while((line = reader.readLine()) != null) {
			args = line.split(" ");
			fromPos = new int[] {Integer.parseInt(args[args.length-3].split(",")[0]), Integer.parseInt(args[args.length-3].split(",")[1])};
			toPos = new int[] {Integer.parseInt(args[args.length-1].split(",")[0]), Integer.parseInt(args[args.length-1].split(",")[1])};
			action = args[args.length-4];

			for (int x = fromPos[0]; x <= toPos[0]; x++) {
				for (int y = fromPos[1]; y <= toPos[1]; y++) {					
					switch (action) {
					case "off":
						if (lights[x][y] > 0) lights[x][y]--;
						break;
					case "on":
						lights[x][y]++;
						break;
					case "toggle":
						lights[x][y]+=2;
						break;
					default:
						System.out.println("Invalid State: " + action);
						break;
					}
				}
			}
		}
		
		for (int x = 0; x < lights.length; x++) {
			for (int y = 0; y < lights.length; y++) {
				result+=lights[x][y];
			}
		}
		
		reader.close();
		super.second();
	}

}
