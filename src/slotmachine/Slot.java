package slotmachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import application.Controller;
import application.astStatsCalc;
import application.slotStatsCalc;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Slot extends Application {

	private Image Earth = new Image("file:Earth.png");
	private Image Mercury = new Image("file:Mercury.png");
	private Image Moon = new Image("file:Moon.png");
	private Image Saturn = new Image("file:Saturn.png");
	private Image Neptune = new Image("file:Neptune.png");
	private Image Venus = new Image("file:Venus.png");
	private Image Sun = new Image("file:Sun.png");
	private Image Jupiter = new Image("file:Jupiter.png");
	private Image Mars = new Image("file:Mars.png");
	private Image Pluto = new Image("file:Pluto.png");
	private Image space = new Image("file:space.png");
	
	private Label totalWonField;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
	
		ImageView slot1 = new ImageView(Earth);
		
		slot1.setFitHeight(400);
		slot1.setFitWidth(400);
		
		ImageView slot2 = new ImageView(Earth);
		
		slot2.setFitHeight(400);
		slot2.setFitWidth(400);
		
		ImageView slot3 = new ImageView(Earth);
		
		slot3.setFitHeight(400);
		slot3.setFitWidth(400);
	
	
		HBox symbols = new HBox(10, slot1, slot2, slot3);
		symbols.setAlignment(Pos.CENTER);

		// Add the Amount Inserted label and text field.
		Label insertedLabel = new Label("Amount Inserted: $");
		insertedLabel.setTextFill(Color.ANTIQUEWHITE);
		insertedLabel.setFont(new Font("Montesserat",30));
		TextField insertedField = new TextField("0.00");
		insertedField.setMaxWidth(95);
		insertedField.setMaxHeight(30);
		

		
		
		Controller n = new Controller();
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		try {
        			if(Double.parseDouble(totalWonField.getText()) == 0.00) {
        				n.astReturn((ActionEvent) e);
        			} else {
        			
        			System.out.println(totalWonField.getText());
        			rewriteFile();
					n.astReturn((ActionEvent) e);
        			}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        	
        	
        }; 
		
        Button btn = new Button();
        btn.setText("Stop Before It's Too Late");
        btn.setFont(Font.font("Montesserat", FontWeight.BOLD, 50));
        btn.setLayoutY(275);
        btn.setLayoutX(265);
        btn.setTextFill(Color.RED);
        btn.toFront();
        btn.setOnAction(event);
        
        
        HBox leave = new HBox(11, btn);
        leave.setAlignment(Pos.CENTER);
        

		HBox insertedBox = new HBox(insertedLabel, insertedField);

		// Add the Amount Won This Spin Labels
		Label wonThisSpinLabel = new Label("Amount Won This Spin: $");
		wonThisSpinLabel.setTextFill(Color.ANTIQUEWHITE);
		wonThisSpinLabel.setFont(new Font("Montesserat",30));
		
		Label wonThisSpinField = new Label("0.00");
		wonThisSpinField.setTextFill(Color.ANTIQUEWHITE);
		wonThisSpinField.setFont(new Font("Montesserat",30));

		HBox wonThisSpinBox = new HBox(wonThisSpinLabel, wonThisSpinField);

		// Add the Total Amount Won Labels
		Label totalWonLabel = new Label("Total Amount Won: $");
		
		totalWonLabel.setTextFill(Color.ANTIQUEWHITE);
		totalWonLabel.setFont(new Font("Montesserat",30));
		
		totalWonField = new Label("0.00");
		totalWonField.setTextFill(Color.ANTIQUEWHITE);
		totalWonField.setFont(new Font("Montesserat",30));
		
		

		HBox totalWonBox = new HBox(totalWonLabel, totalWonField);

		// Add the spin button
		Button spinButton = new Button("Spin");
		spinButton.setFont(new Font("Montesserat",30));
		spinButton.setPrefHeight(100);
		spinButton.setPrefWidth(400);
		HBox buttonBox = new HBox(10, spinButton);
		buttonBox.setAlignment(Pos.CENTER);

		GridPane grid = new GridPane();
		grid.setHgap(50);
		grid.add(insertedBox, 0, 0);
		grid.add(wonThisSpinBox, 1, 0);
		grid.add(totalWonBox, 1, 1);
		//grid.add(btn, 0, 0);
		grid.setAlignment(Pos.CENTER);

		VBox layout = new VBox(75, symbols, grid, buttonBox, leave);
		layout.setPadding(new Insets(35));

		spinButton.setOnAction(new EventHandler<ActionEvent>() {

		public void handle(ActionEvent e) {
		double userBet = Double.parseDouble(insertedField.getText());
		slot1.setImage(slotVal());
		slot2.setImage(slotVal());
		slot3.setImage(slotVal());
		
	      RotateTransition rotateTransition1 = new RotateTransition(); 
	      
	      //Setting the duration for the transition
	      
	      //Setting the node for the transition 
	      rotateTransition1.setNode(slot1);       
	      
	      //Setting the angle of the rotation 
	      rotateTransition1.setByAngle(360); 
	      
	      //Setting the cycle count for the transition 
	      rotateTransition1.setCycleCount(1); 
	      
	      //Setting auto reverse value to false 
	      rotateTransition1.setAutoReverse(false); 
	      
	      //Playing the animation 
	      rotateTransition1.play(); 
	      
	      RotateTransition rotateTransition2 = new RotateTransition(); 
	      
	    
	      rotateTransition2.setNode(slot2);       
	      
	      rotateTransition2.setByAngle(360); 
	      
	   
	      rotateTransition2.setCycleCount(1); 
	      
	     
	      rotateTransition2.setAutoReverse(false); 
	      
	  
	      rotateTransition2.play();
	      
	      RotateTransition rotateTransition3 = new RotateTransition(); 
	      
	
	      rotateTransition3.setNode(slot3);       
	      
	   
	      rotateTransition3.setByAngle(360); 
	
	      rotateTransition3.setCycleCount(1); 
	    
	      rotateTransition3.setAutoReverse(false); 
	      

	      rotateTransition3.play();

		if (slot1.getImage() == slot2.getImage() && slot2.getImage() == slot3.getImage()) {
		userBet *= 3.0;
		wonThisSpinField.setText(String.format("$%.2f", userBet));
		totalWonField.setText(String.format("%.2f", (Double.parseDouble(totalWonField.getText()) + userBet)));
		}
		else if (slot1.getImage() == slot2.getImage()) {
		userBet *= 2.0;
		wonThisSpinField.setText(String.format("%.2f", userBet));
		totalWonField.setText(String.format("%.2f", (Double.parseDouble(totalWonField.getText()) + userBet)));
		}
		else if (slot1.getImage() == slot3.getImage()) {
		userBet *= 2.0;
		wonThisSpinField.setText(String.format("%.2f", userBet));
		totalWonField.setText(String.format("%.2f", (Double.parseDouble(totalWonField.getText()) + userBet)));
		}
		else if (slot2.getImage() == slot3.getImage()) {
		userBet *= 2.0;
		wonThisSpinField.setText(String.format("%.2f", userBet));
		totalWonField.setText(String.format("%.2f", (Double.parseDouble(totalWonField.getText()) + userBet)));
		}
		else {
	
		wonThisSpinField.setText(String.format("%.2f", (userBet - (userBet*2))));
		totalWonField.setText(String.format("%.2f", (Double.parseDouble(totalWonField.getText()) - userBet)));
		}

		}
		});
		StackPane root = new StackPane(layout);
		
		BackgroundImage bImg = new BackgroundImage(space,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
       Background bGround = new Background(bImg);
       root.setBackground(bGround);

		Scene scene = new Scene(root, 600, 650);

		primaryStage.setScene(scene);

		primaryStage.setTitle("Slot Machine");
		
		primaryStage.setMaximized(true);
		
		primaryStage.show();
		
		}

		private Image slotVal() {
		Random rand = new Random();
		int randomNum = rand.nextInt(10);
		Image val = Earth;
		switch (randomNum) {
		case 0:
		val = Pluto;
		break;
		case 1:
		val = Mercury;
		break;
		case 2:
		val = Earth;
		break;
		case 3:
		val = Moon;
		break;
		case 4:
		val = Jupiter;
		break;
		case 5:
		val = Mars;
		break;
		case 6:
		val = Sun;
		break;
		case 7:
		val = Saturn;
		break;
		case 8:
		val = Venus;
		break;
		case 9:
		val = Neptune;
		break;
		}

		return val;
		}
		
		
		//Brendon's Code
        
	slotStatsCalc player;

	private void rewriteFile() throws IOException{
	
		player = new slotStatsCalc(Double.parseDouble(totalWonField.getText()));
		int counter = 0;

		double score1 = 0.00;
		double prv =0;
		double ave=0;
		double h=0;
		double l =0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("blackjack.txt"));
	
			prv = Double.parseDouble(br.readLine());
			score1 = Double.parseDouble(br.readLine());
			System.out.println("THE TOTAL " + score1);
			ave = Double.parseDouble(br.readLine());
			h = Double.parseDouble(br.readLine());
			l = Double.parseDouble(br.readLine());
			counter = Integer.parseInt(br.readLine());
	
		br.close();
	
		} catch(Exception e) {
			
		}
		System.out.println("ths "+score1);
		if(score1 == 0.00) { 
	
		FileWriter wr1 = new FileWriter("blackjack.txt");
		System.out.println("Score1 is thishere: " + score1);
		System.out.println("Case 1");
		wr1.write(totalWonField.getText() + "\n");
		wr1.write(totalWonField.getText() + "\n"); 
		wr1.write(totalWonField.getText() + "\n"); 
		wr1.write(totalWonField.getText() + "\n");
		wr1.write(totalWonField.getText() + "\n"); 
		wr1.write(Integer.toString(1));
		wr1.close();

		} else if (score1 != 0.00){

			FileWriter wr2 = new FileWriter("blackjack.txt");
			System.out.println("Case 2");

			wr2.write(totalWonField.getText() + "\n");
			double rpl = score1 + Double.parseDouble(totalWonField.getText());
			wr2.write(Double.toString(rpl) + "\n");
			wr2.write(Double.toString(ave) + "\n");
			wr2.write(Double.toString(h) + "\n");
			wr2.write(Double.toString(l) + "\n");
			wr2.write(counter += 1);
			wr2.close();

			System.out.println("current score: " + totalWonField.getText() + "\nHigh score: " + player.HighScore() + "\nAve score: " + player.AveScore());

			FileWriter wr = new FileWriter("blackjack.txt");


			wr.write(totalWonField.getText()+ "\n");
			wr.write(Double.toString(rpl) + "\n"); 
			wr.write(Double.toString(player.getAve()) + "\n");		//finds average score

			h = player.HighScore();									//finds highest score
			wr.write(Double.toString(h) + "\n");

			l = player.LowScore();									//finds lowest score
			wr.write(Double.toString(l) + "\n");


			wr.write(Integer.toString(counter));
			wr.close();

			}

	}}
		


