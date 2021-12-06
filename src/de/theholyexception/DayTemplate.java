package de.theholyexception;

import java.io.File;

public abstract class DayTemplate {

	protected File file;
	protected int year;
	protected String day;
	protected long result;
	protected long firstResult;
	protected long secondResult;
	protected long timeStop;
	
	public DayTemplate(int year, String day) throws Exception {
		this.year = year;
		this.day = day;
		file = new File("./inputs/"+year+"/Day"+day+".txt");
		
		result = 0;
		timeStop = System.currentTimeMillis();
		first();
		firstResult = result;
		
		result = 0;
		timeStop = System.currentTimeMillis();
		second();
		secondResult = result;
	}
	
	public void first() throws Exception {
		System.out.println("Y:"+year+" - Day" + day + ".1 Time Took: " + (System.currentTimeMillis()-timeStop) + "ms, Result: " + result);
	}
	
	public void second() throws Exception {
		System.out.println("Y:"+year+" - Day" + day + ".2 Time Took: " + (System.currentTimeMillis()-timeStop) + "ms, Result: " + result);
	}
	
}
