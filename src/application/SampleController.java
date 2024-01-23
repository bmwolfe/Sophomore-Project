package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SampleController {

	@FXML
	private Button timesTwo;

	@FXML
	private Button timesThree;

	@FXML
	private Button timesFour;

	@FXML
	private Button timesFive;

	@FXML
	private Button plusOne;

	@FXML
	private Button plusFive;

	@FXML
	private Button plusHundred;
	
	@FXML
	private Label num;

	@FXML
	private Label cps;
	
	private long cookies = 0;
	long CPS = 0;
	private int multi = 1;
	
	Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), e->{
		cookies += 1;
		num.setText("" + ((cookies)));
		cps.setText("CPS: " + (CPS));
	}));

	Timeline timeline25 = new Timeline(new KeyFrame(Duration.seconds(1), e->{
		cookies += 25;
		num.setText("" + ((cookies)));
	}));
	
	Timeline timeline100 = new Timeline(new KeyFrame(Duration.seconds(1), e->{
		cookies += 100;
		num.setText("" + ((cookies)));
	}));
	
	
    @FXML
	public void addcookie(ActionEvent event) {
		num.setText("" + (cookies += (1 * multi)));
	}

	@FXML
	public void buyMulti(ActionEvent event) {

		if (cookies >= 200) {
			if (multi < 2) {
				multi += 1;
				num.setText("" + (cookies -= 200));
			}
		}
	}

	@FXML
	public void buyTriple(ActionEvent event) {
		if (cookies >= 400) {
			if (multi < 3) {
				multi += 1;
				num.setText("" + (cookies -= 400));
			}
		}
	}
	
	@FXML
	public void buyFour(ActionEvent event) {
		if (cookies >= 600) {
			if (multi < 4) {
				multi += 1;
				num.setText("" + (cookies -= 600));
			}
		}
	}
	
	@FXML
	public void buyFive(ActionEvent event) {
		if (cookies >= 800) {
			if (multi < 5) {
				multi += 1;
				num.setText("" + (cookies -= 800));
			}
		}
	}
	
	@FXML 
	public void addOne(ActionEvent event) {
		//50
		if(cookies >= 50) {
			num.setText("" + (cookies -= 50));
			timeline1.setCycleCount(Animation.INDEFINITE);
			timeline1.play();
			CPS++;
			cps.setText("CPS: " + (CPS));
		}
	}
	
	@FXML 
	public void addFive(ActionEvent event) {
		//350
		if(cookies >= 350) {
			num.setText("Cookies: " + (cookies -= 350));
			timeline25.setCycleCount(Animation.INDEFINITE);
			timeline25.play();
			CPS += 25;
			cps.setText("CPS: " + (CPS));
		}
	}
	
	@FXML 
	public void addHundred(ActionEvent event) {
		//2500
		if(cookies >= 2500) {
			num.setText("" + (cookies -= 2500));
			timeline100.setCycleCount(Animation.INDEFINITE);
			timeline100.play();
			CPS += 100;
			cps.setText("CPS: " + (CPS));			
		}
	}

	cookieStats player;
	
public void returnToMain(ActionEvent event) throws IOException {
		
		if(num.getText().equals("Cookies: 0")) {
			Parent main = FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
			Scene mainScene = new Scene(main);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(mainScene);
			window.setResizable(false);
			window.show();
		} else {
		
		rewriteFile();
		
		Parent main = FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene mainScene = new Scene(main);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainScene);
		window.setResizable(false);
		window.show();
		}
	}
	
	//This method rewrites the file
	//First it saves the previous lines to variables
	//Then it checks if there was a previous score
	//If not, the lines are all saved as the current score
	//If there was a previous score then the previous score is added to the recent score
	//which is now saved to the total. The previous scores as well as the new total score
	//are written into the file and then the playerStats methods are called to calculate
	//the average, lowest and highest scores
	
	private void rewriteFile() throws IOException{
		player = new cookieStats(Integer.parseInt(num.getText()));
		int counter = 0; //player.getCounter()
		
		double score1 = 0;
		int prv =0;
		double ave=0;
		int h=0;
		int l =0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("tbd.txt"));
			
			prv = Integer.parseInt(br.readLine());
			score1 = Double.parseDouble(br.readLine());
			ave = Double.parseDouble(br.readLine());
			h = Integer.parseInt(br.readLine());
			l = Integer.parseInt(br.readLine());
			counter = Integer.parseInt(br.readLine());
			
			br.close();
			
		} catch(Exception e) {
			
		}
		
		if(score1 == 0) { //As of now the file is not updated
			
		FileWriter wr1 = new FileWriter("tbd.txt");
		
		wr1.write(num.getText() + "\n");
		wr1.write(num.getText() + "\n"); 
		wr1.write(num.getText() + "\n"); 
		wr1.write(num.getText() + "\n");
		wr1.write(num.getText() + "\n"); 
		wr1.write(Integer.toString(1));
		wr1.close();
		
		} else if (score1 != 0){
		
		FileWriter wr2 = new FileWriter("tbd.txt");
		
		wr2.write(num.getText() + "\n");
		double rpl = score1 + Double.parseDouble(num.getText());
		wr2.write(Double.toString(rpl) + "\n");
		wr2.write(Double.toString(ave) + "\n");
		wr2.write(Integer.toString(h) + "\n");
		wr2.write(Integer.toString(l) + "\n");
		wr2.write(counter += 1);
		wr2.close();
		
		System.out.println("current score: " + num.getText() + "\nHigh score: " + player.HighScore() + "\nAve score: " + player.AveScore());
		
		FileWriter wr = new FileWriter("tbd.txt");
		
		
		wr.write(num.getText()+ "\n");
		wr.write(Double.toString(rpl) + "\n"); 
		wr.write(Double.toString(player.getAve()) + "\n");		//finds average score
		
		h = player.HighScore();									//finds highest score
		wr.write(Integer.toString(h) + "\n");
		
		l = player.LowScore();									//finds lowest score
		wr.write(Integer.toString(l) + "\n");
		
		
		wr.write(Integer.toString(counter));
		wr.close();
		
		}
		
		
	}
	
}
	
	


