package application;

import java.io.BufferedReader;
import java.io.FileReader;

public class slotStatsCalc {
	private double Score;
	private double Total = 0;
	private double Ave = 0;
	private double Max = 0;
	private double Min = Integer.MAX_VALUE;
	private int i = 0;
	
	public slotStatsCalc(double Score) {
		this.Score = Score;
		i++;
		AveScore();
		LowScore();
		HighScore();
	}
	
	public void setScore(int Score) {
		this.Score = Score;
		i++;
	}
	
	public double getScore() {
		return this.Score;
	}
	
	public double getAve() {
		return Ave;
	}
	
	public double getMin() {
		return Min;
	}
	
	public double getMax() {
		return Max;
	}
	
	public int getCounter() {
		return i;
	}
	
	public double getTotal() {
		return Total;
	}
	
	//							We can now edit text files, the basic text file editor works perfectly.
	//							Now we need to be able to change the text according to the scores acquired in game
	
	public double AveScore() {
		//double text;
		try {
			BufferedReader br = new BufferedReader(new FileReader("blackjack.txt"));
			Score = Double.parseDouble(br.readLine());
			//System.out.println("this is the score: " + jeopScore);
			Total = Double.parseDouble(br.readLine());
			//System.out.println("this is the total: " + jeopTotal);
			Ave = Double.parseDouble(br.readLine());
			//System.out.println("this is the AVEscore: " + Ave);
			//br.readLine(); //ave
			br.readLine(); //high
			br.readLine(); //low
			i = Integer.parseInt(br.readLine()) + 1;
			//System.out.println("this is the i: " + i);
			
			br.close();
			
		} catch(Exception e) {
			
		}
			if(Ave == 0) {
				Total = Score;
				Ave = Total;
			} else {
				System.out.println("processing ave: " + Ave + "\nTotal is: " + Total + "\nI is: " + i);
				Ave = (Total / (i));
				//System.out.println("processing ave: " + jeopAve);
			}
			
			//System.out.println("this is the AVEscore: " + jeopAve);
			return Ave;
		}
	
	public double LowScore() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("blackjack.txt"));
			Score = Double.parseDouble(br.readLine());
			br.readLine();
			br.readLine();
			br.readLine();
			Min = Double.parseDouble(br.readLine());
			br.readLine();
			
			br.close();
			
		} catch(Exception e) {
			
		}
		if(Score < Min) {
			Min = Score;
		}
		return Min;
	}
	
	public double HighScore() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("blackjack.txt"));
			Score = Double.parseDouble(br.readLine());
			//System.out.println("SCORE IS " + jeopScore);
			br.readLine();
			br.readLine();
			Max = Double.parseDouble(br.readLine());
			//System.out.println("MAX IS " + jeopMax);
			br.readLine();
			br.readLine();
			br.close();
			
			if(Score > Max) {
				Max = Score;
				//System.out.println("MAX IS " + jeopMax);
				return Max;
			}
			
			} catch(Exception e) {
			
		}
			
		
		return Max;
	}
}

