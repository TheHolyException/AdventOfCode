package de.theholyexception.days2015;

import java.io.FileInputStream;

import de.theholyexception.DayTemplate;

public class Day01 extends DayTemplate {
	
	public Day01() throws Exception {
		super(2015, "01");
	}

	@Override
	public void first() throws Exception {		
		FileInputStream fis = new FileInputStream(file);
		int c = -1;
		while((c = fis.read()) != -1) {
			if (c == '(') result++;
			else if (c == ')') result--;
		}

		fis.close();
		super.first();
	}

	@Override
	public void second() throws Exception {
		int pos = 0;
		int charpos = 0;
		FileInputStream fis = new FileInputStream(file);
		int c = -1;
		while((c = fis.read()) != -1) {
			charpos++;
			if (c == '(') pos++;
			else if (c == ')') {
				pos--;
				if (pos == -1) {
					result = charpos;
					break;
				}
			}
		}

		fis.close();
		super.second();
	}
	
}
