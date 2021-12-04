package de.theholyexception;

import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.theholyexception.days.Day01;
import de.theholyexception.days.Day02;
import de.theholyexception.days.Day03;
import de.theholyexception.days.Day04;

public class AdventOfCode {
	
	public static void main(String[] args) throws Exception {
		new Day01(new File("./inputs/day01.txt")); // 1228 	- 1257
		new Day02(new File("./inputs/day02.txt")); // 1692075 	- 1749524700
		new Day03(new File("./inputs/day03.txt")); // 1071734 	- 6124992
		new Day04(new File("./inputs/day04.txt")); // 65325 	- 4624
	}
	

}
