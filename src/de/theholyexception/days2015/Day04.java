package de.theholyexception.days2015;

import java.io.FileInputStream;
import java.security.MessageDigest;

import de.theholyexception.DayTemplate;

public class Day04 extends DayTemplate {
	
	public Day04() throws Exception {
		super(2015, "04");
	}
	
	@Override
	public void first() throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		FileInputStream fos = new FileInputStream(file);
		String key = new String(fos.readAllBytes());
		
		int cnt = 0;
		byte[] lastStuff;
		
		do {
			lastStuff = md.digest((key+(cnt++)+"").getBytes());
		} while (!checkZeros1(lastStuff));
		
		result = cnt-1;
		fos.close();
		super.first(); //282749
	}
	
	@Override
	public void second() throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		FileInputStream fos = new FileInputStream(file);
		String key = new String(fos.readAllBytes());
		
		int cnt = 0;
		byte[] lastStuff;
		
		do {
			lastStuff = md.digest((key+(cnt++)+"").getBytes());
		} while (!checkZeros2(lastStuff));
		
		result = cnt-1;
		fos.close();
		super.second(); //9962624
	}	
	
	
	private boolean checkZeros1(byte[] data) {
		
		if (data[0] == 0 && data[1] == 0)
			if (String.format("%02X", data[2]).charAt(0) == '0')
				return true;
		return false;
	}

	private boolean checkZeros2(byte[] data) {
		
		if (data[0] == 0 && data[1] == 0 && data[2] == 0)
			return true;		
		return false;
	}
	

}
