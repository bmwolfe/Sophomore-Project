package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class MemoryGameCode {
	private int turns = 0; 
	private int points = 0; 
	private final int boardHeight = 3; 
	private final int boardWidth = 4;
	private final int boardSize = boardHeight * boardWidth;
	private Random random = new Random();
	
	//private ArrayList<String> gameBoard = new ArrayList <String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11")); 
	private  ArrayList<String> memoryBoard= new ArrayList<String>(Arrays.asList("","","","","","","","","","","",""));
	private  final ArrayList<String> memoryOptions = new ArrayList<String>(Arrays.asList("a","a","b","b","c","c","d","d","e","e","f","f"));
	
	
	public MemoryGameCode() {
		
	}
	
	
	//review this
	
	public void setUpBoard() {
		for (int i = 0; i < boardSize; i++) {
			String memoryOption = memoryOptions.get(i);
			int position = random.nextInt(boardSize);
			
			while(!Objects.equals(memoryBoard.get(position), "")) {
				position = random.nextInt(boardSize);
			}
			memoryBoard.set(position, memoryOption);
			//System.out.println(i+ " " + position + memoryBoard.toString());
		}
	}
	
	public boolean isMatch(String x, String y) {
		if (x.equalsIgnoreCase(y)) {
			turns++;
			return true;
		}
		else {
			turns++;
			return false;
		}
	}
	
	public int getTurns() {
		return turns;
	}
	
	public String getArrayValue(int x) {
		
		String z = memoryBoard.get(x);
		return z;
		
	}
	
	public void printBoard() {
		//System.out.print(memoryBoard.toString());
	}
}
