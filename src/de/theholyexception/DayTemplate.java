package de.theholyexception;

import java.io.File;

public abstract class DayTemplate {

	protected File file;
	protected int year;
	protected String day;
	protected int result;
	
	public DayTemplate(int year, String day) throws Exception {
		this.year = year;
		this.day = day;
		file = new File("./inputs/"+year+"/Day"+day+".txt");
		
		result = 0;
		first();
		result = 0;
		second();
	}
	
	public void first() throws Exception {
		System.out.println("Y:"+year+" - Day" + day + ".1 Result: " + result);
	}
	
	public void second() throws Exception {
		System.out.println("Y:"+year+" - Day" + day + ".2 Result: " + result);
	}
	
}
