package de.theholyexception.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day04 {
	
	private File file;
	
	public Day04(File file) throws Exception {
		this.file = file;
		first();
		Board.boardIDS = 1;
		second();
	}
	
	public void first() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		int result = 0;	
		
		String[] numbersToDrawn = reader.readLine().split(",");
		List<Board> boards = readBoards(reader);

		Board winner = null;
		for (String n : numbersToDrawn) {
			int number = Integer.parseInt(n);
			for (Board board : boards) {
				if (board.mark(number)) winner = board;
			}
			if (winner != null) {
				result = winner.getRemainingSum() * number;
				break;
			}
		}
		
		System.out.println("Day04 first result: " + result);
		//65325
	}
	
	public void second() throws Exception {		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		int result = 0;
		
		String[] numbersToDrawn = reader.readLine().split(",");		
		List<Board> boards = readBoards(reader);

		Board lastwinner = null;
		int lastDrawnNumber = 0;
		for (String n : numbersToDrawn) {
			if (boards.size() == 0) break;
			int number = Integer.parseInt(n);
			lastDrawnNumber = number;
			List<Board> winners = new ArrayList<>();
			for (Board board : boards) {
				if (board.mark(number)) {
					winners.add(board);
					lastwinner = board;
				}
			}
			boards.removeAll(winners);
		}
		
		result = lastwinner.getRemainingSum() * lastDrawnNumber;		
		System.out.println("Day04 second result: " + result);
		//4624
	}
	
	private List<Board> readBoards(BufferedReader reader) throws Exception {
		List<Board> boards = new ArrayList<>();
		String line = null;
		while((line = reader.readLine()) != null) { //1st readline removes empty header			
			int[][] numbers = new int[5][5];
			for (int i = 0; i < 5; i ++) {
				String[] a = reader.readLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < 5; j++) {
					numbers[i][j]=Integer.parseInt(a[j]);
				}
			}			
			boards.add(new Board(numbers));
		}
		return boards;
	}
	
	
	private class Board {
		
		static int boardIDS = 1;
		int boardID = -1;
		private int[][] dataset;
		private boolean[][] marks = new boolean[5][5];
		
		public Board(int[][] data) {
			this.dataset = data;
			this.boardID = boardIDS++;
		}
		
		public boolean mark(int number) {
			for (int i = 0; i < 5; i ++) {
				for (int j = 0; j < 5; j ++) {
					if (number == dataset[i][j])
						marks[i][j] = true;
				}
			}
			return checkForBingo();
		}
		
		public int getRemainingSum() {
			int result = 0;
			for (int i = 0; i < 5; i ++) {
				for (int j = 0; j < 5; j ++) {
					if (!marks[i][j]) 
						result+=dataset[i][j];
				}
			}
			return result;
		}
		
		
		private boolean checkForBingo() {
			//Horizontal Check
			for (int i = 0; i < 5; i ++) {
				boolean win = true;
				for (int j = 0; j < 5; j ++) {
					if (!marks[i][j]) {
						win = false;
						break;
					}
				}
				if (win) {
//					System.out.println("Horizontal Check WIN!!! line: " + i);
					return true;
				}
			}
			
			//Vertical Check
			for (int i = 0; i < 5; i ++) {
				boolean win = true;
				for (int j = 0; j < 5; j ++) {
					if (!marks[j][i]) {
						win = false;
						break;
					}
				}
				if (win) {
//					System.out.println("Vertical Check WIN!!!");
					return true;
				}
			}
			return false;
		}

		
	}
	
	
}



