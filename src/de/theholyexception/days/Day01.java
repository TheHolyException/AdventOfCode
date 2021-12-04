package de.theholyexception.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Day01 {

	private File file;
	
	public Day01(File file) throws Exception {
		this.file = file;
		first();
		second();
	}
	
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		int increments = 0;
		int prev = -1;		
		String line = null;
		while((line = reader.readLine()) != null) {
			int curr = Integer.parseInt(line);
			if (prev != -1 && prev < curr) {
				increments ++;
			}
			prev = curr;
		}
		System.out.println("Day01 first Increments: " + increments);
		//1228
	}
	
	public void second() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

		
		int[] mess = new int[3];
		int increments = 0;
		int prev = -1;
		
		String line = null;
		while((line = reader.readLine()) != null) {
			if (prev == -1) {
				mess[0] = Integer.parseInt(reader.readLine());
				mess[1] = Integer.parseInt(reader.readLine());
				mess[2] = Integer.parseInt(reader.readLine());
			} else {
				mess[0] = mess[1];
				mess[1] = mess[2];
				mess[2] = Integer.parseInt(line);
			}
			
			int curr = mess[0]+mess[1]+mess[2];
			
			if (prev != -1 && prev < curr)
				increments ++;
			
			prev = curr;
			
			
		}
		System.out.println("Day01 second Increments: " + increments);
		//1257
	}
	
}
