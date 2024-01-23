package application;

import java.io.BufferedReader;
import java.io.FileReader;

public class playerStats {

	private int jeopScore;
	private double jeopTotal = 0;
	private double jeopAve = 0;
	private int jeopMax = 0;
	private int jeopMin = Integer.MAX_VALUE;
	private int i = 0;
	
	public playerStats(int jeopScore) {
		this.jeopScore = jeopScore;
		i++;
		jeopAveScore();
		jeopLowScore();
		jeopHighScore();
	}
	
	public void setJeopScore(int jeopScore) {
		this.jeopScore = jeopScore;
		i++;
	}
	
	public int getJeopScore() {
		return this.jeopScore;
	}
	
	public double getJeopAve() {
		return jeopAve;
	}
	
	public int getJeopMin() {
		return jeopMin;
	}
	
	public int getJeopMax() {
		return jeopMax;
	}
	
	public int getCounter() {
		return i;
	}
	
	public double getTotal() {
		return jeopTotal;
	}
	
	//							We can now edit text files, the basic text file editor works perfectly.
	//							Now we need to be able to change the text according to the scores acquired in game
	
	public double jeopAveScore() {
		//double text;
		try {
			BufferedReader br = new BufferedReader(new FileReader("jeop.txt"));
			jeopScore = Integer.parseInt(br.readLine());
			//System.out.println("this is the score: " + jeopScore);
			jeopTotal = Double.parseDouble(br.readLine());
			//System.out.println("this is the total: " + jeopTotal);
			jeopAve = Double.parseDouble(br.readLine());
			System.out.println("this is the AVEscore: " + jeopAve);
			//br.readLine(); //ave
			br.readLine(); //high
			br.readLine(); //low
			i = Integer.parseInt(br.readLine()) + 1;
			//System.out.println("this is the i: " + i);
			
			br.close();
			
		} catch(Exception e) {
			
		}
			if(jeopAve == 0) {
				jeopTotal = jeopScore;
				jeopAve = jeopTotal;
				System.out.println("MEEEEEE");
			} else {
				//System.out.println("processing ave: " + jeopAve + "\nTotal is: " + jeopTotal + "\nI is: " + i);
				jeopAve = (jeopTotal / (i));
				//System.out.println("processing ave: " + jeopAve);
			}
			
			//System.out.println("this is the AVEscore: " + jeopAve);
			return jeopAve;
		}
	
	public int jeopLowScore() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("jeop.txt"));
			jeopScore = Integer.parseInt(br.readLine());
			br.readLine();
			br.readLine();
			br.readLine();
			jeopMin = Integer.parseInt(br.readLine());
			br.readLine();
			
			br.close();
			
		} catch(Exception e) {
			
		}
		if(jeopScore < jeopMin) {
			jeopMin = jeopScore;
		}
		return jeopMin;
	}
	
	public int jeopHighScore() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("jeop.txt"));
			jeopScore = Integer.parseInt(br.readLine());
			//System.out.println("SCORE IS " + jeopScore);
			br.readLine();
			br.readLine();
			jeopMax = Integer.parseInt(br.readLine());
			//System.out.println("MAX IS " + jeopMax);
			br.readLine();
			br.readLine();
			br.close();
			
			if(jeopScore > jeopMax) {
				jeopMax = jeopScore;
				//System.out.println("MAX IS " + jeopMax);
				return jeopMax;
			}
			
			} catch(Exception e) {
			
		}
			
		
		return jeopMax;
	}
	
}