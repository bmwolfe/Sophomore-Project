package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MatchController {
	
	matStatsCalc player;

	@FXML
	private GridPane grid;
	
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnExit;
	
	@FXML
	private Label label;
	
	//making buttons
	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btn10;
	@FXML
	private Button btn11;
	
	//object for memory game
	private MemoryGameCode run = new MemoryGameCode();
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> {
		try {
			hideButtons();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}));
	
	//play button
	public void play(ActionEvent event)throws IOException {
		
			//open and clear text files
			FileWriter options = new FileWriter("options.txt");
			options.write("");
			options.close();
		
			FileWriter isMatch = new FileWriter("isMatch.txt");
			isMatch.write("");
			isMatch.close();
		
			//run the scene
			Parent root = FXMLLoader.load(getClass().getResource("MemoryRun.fxml"));
			Scene scene = new Scene(root, 800, 700);
			
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			run.setUpBoard();
			//System.out.println("Playing");
			
			
			//Write the random array into the text file 
			FileWriter write = new FileWriter("options.txt");
			
			for (int i = 0; i<12; i++) {
				write.write(run.getArrayValue(i) + "\n");
			}
			write.close();
			}
	
	//go back to menu screen
	public void exit(ActionEvent event) throws IOException {
		
		rewriteFile();
		
		Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		Scene scene = new Scene(root);
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
		FileWriter options = new FileWriter("options.txt");
		options.write("");
		options.close();
		
		FileWriter isMatch = new FileWriter("isMatch.txt");
		isMatch.write("");
		isMatch.close();
		
	}
	
	public void returnToMain(ActionEvent event) throws IOException {
		Parent main = FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene mainScene = new Scene(main);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainScene);
		window.setResizable(false);
		window.show();
		
	}
	
	private void rewriteFile() throws IOException{
		player = new matStatsCalc(Integer.parseInt(label.getText()));
		int counter = 0; //player.getCounter()
		
		double score1 = 0;
		int prv =0;
		double ave=0;
		int h=0;
		int l =0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("mat.txt"));
			
			prv = Integer.parseInt(br.readLine());
			score1 = Double.parseDouble(br.readLine());
			ave = Double.parseDouble(br.readLine());
			h = Integer.parseInt(br.readLine());
			l = Integer.parseInt(br.readLine());
			counter = Integer.parseInt(br.readLine());
			
			br.close();
			
		} catch(Exception e) {
			
		}
		
		if(score1 == 0) { 
			
		FileWriter wr1 = new FileWriter("mat.txt");
		
		wr1.write(label.getText() + "\n");
		wr1.write(label.getText() + "\n"); 
		wr1.write(label.getText() + "\n"); 
		wr1.write(label.getText() + "\n");
		wr1.write(label.getText() + "\n"); 
		wr1.write(Integer.toString(1));
		wr1.close();
		
		} else if (score1 != 0){
		
		FileWriter wr2 = new FileWriter("mat.txt");
		
		wr2.write(label.getText() + "\n");
		double rpl = score1 + Double.parseDouble(label.getText());
		wr2.write(Double.toString(rpl) + "\n");
		wr2.write(Double.toString(ave) + "\n");
		wr2.write(Integer.toString(h) + "\n");
		wr2.write(Integer.toString(l) + "\n");
		wr2.write(counter += 1);
		wr2.close();
		
		System.out.println("current score: " + label.getText() + "\nHigh score: " + player.HighScore() + "\nAve score: " + player.AveScore());
		
		FileWriter wr = new FileWriter("mat.txt");
		
		
		wr.write(label.getText()+ "\n");
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
	
	//resets both buttons clicked
	public void hideButtons() throws IOException {
		reset1();
		reset2();
	}
	
	//changing color methods for the buttons
	private void changeColor0(String string) {
		System.out.println("changing color");
		switch (string) {
		//red
		case "a":
			btn0.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn0.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn0.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn0.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn0.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn0.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor1(String string) {
		System.out.println("changing color");
		switch (string) {
		//red
		case "a":
			btn1.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn1.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn1.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn1.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn1.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn1.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor2(String string) {
		switch (string) {
		//red
		case "a":
			btn2.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn2.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn2.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn2.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn2.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn2.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor3(String string) {
		switch (string) {
		//red
		case "a":
			btn3.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn3.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn3.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn3.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn3.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn3.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor4(String string) {
		switch (string) {
		//red
		case "a":
			btn4.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn4.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn4.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn4.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn4.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn4.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor5(String string) {
		switch (string) {
		//red
		case "a":
			btn5.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn5.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn5.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn5.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn5.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn5.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor6(String string) {
		switch (string) {
		//red
		case "a":
			btn6.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn6.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn6.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn6.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn6.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn6.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor7(String string) {
		switch (string) {
		//red
		case "a":
			btn7.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn7.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn7.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn7.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn7.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn7.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	
	
	private void changeColor8(String string) {
		switch (string) {
		//red
		case "a":
			btn8.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn8.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn8.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn8.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn8.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn8.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor9(String string) {
		switch (string) {
		//red
		case "a":
			btn9.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn9.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn9.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn9.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn9.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn9.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor10(String string) {
		switch (string) {
		//red
		case "a":
			btn10.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn10.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn10.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn10.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn10.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn10.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
	private void changeColor11(String string) {
		switch (string) {
		//red
		case "a":
			btn11.setStyle("-fx-background-color: red");
			break;
		//orange
		case "b":
			btn11.setStyle("-fx-background-color: orange");
			break;
		//pink
		case "c":
			btn11.setStyle("-fx-background-color: pink");
			break;
		//green
		case "d":
			btn11.setStyle("-fx-background-color: green");
			break;
			
		//blue	
		case "e":
			btn11.setStyle("-fx-background-color: blue");
			break;
			
		//purple	
		case "f":
			btn11.setStyle("-fx-background-color: purple");
			break;
		}
		
	}
	
	
		
		@FXML
		private void reset1() throws IOException {
			
			BufferedReader read1 = new BufferedReader(new FileReader ("isActive1.txt"));
			String x = read1.readLine();
			read1.close();
			
			FileWriter write1 = new FileWriter("isActive1.txt");
			write1.write("");
			write1.close();
			
			FileWriter isMatch = new FileWriter("isMatch.txt");
			isMatch.write("");
			isMatch.close();
			
			switch (x) {
			case "0":
				btn0.setStyle("-fx-background-color: black");
				break;
			case "1":
				btn1.setStyle("-fx-background-color: black");
				break;
			case "2":
				btn2.setStyle("-fx-background-color: black");
				break;
			case "3":
				btn3.setStyle("-fx-background-color: black");
				break;
			case "4":
				btn4.setStyle("-fx-background-color: black");
				break;
			case "5":
				btn5.setStyle("-fx-background-color: black");
				break;
			case "6":
				btn6.setStyle("-fx-background-color: black");
				break;
			case "7":
				btn7.setStyle("-fx-background-color: black");
				break;
			case "8":
				btn8.setStyle("-fx-background-color: black");
				break;
			case "9":
				btn9.setStyle("-fx-background-color: black");
				break;
			case "10":
				btn10.setStyle("-fx-background-color: black");
				break;
			case "11":
				btn11.setStyle("-fx-background-color: black");
				break;
			}
		}
		
		@FXML
		private void reset2() throws IOException {
			
			BufferedReader read1 = new BufferedReader(new FileReader ("isActive2.txt"));
			String x = read1.readLine();
			read1.close();
			
			FileWriter write1 = new FileWriter("isActive2.txt");
			write1.write("");
			write1.close();
			
			FileWriter isMatch = new FileWriter("isMatch.txt");
			isMatch.write("");
			isMatch.close();
			
			switch (x) {
			case "0":
				btn0.setStyle("-fx-background-color: black");
				break;
			case "1":
				btn1.setStyle("-fx-background-color: black");
				break;
			case "2":
				btn2.setStyle("-fx-background-color: black");
				break;
			case "3":
				btn3.setStyle("-fx-background-color: black");
				break;
			case "4":
				btn4.setStyle("-fx-background-color: black");
				break;
			case "5":
				btn5.setStyle("-fx-background-color: black");
				break;
			case "6":
				btn6.setStyle("-fx-background-color: black");
				break;
			case "7":
				btn7.setStyle("-fx-background-color: black");
				break;
			case "8":
				btn8.setStyle("-fx-background-color: black");
				break;
			case "9":
				btn9.setStyle("-fx-background-color: black");
				break;
			case "10":
				btn10.setStyle("-fx-background-color: black");
				break;
			case "11":
				btn11.setStyle("-fx-background-color: black");
				break;
			}
		}
		
		
		
		//could maybe iterate through the text file to find the matches and just save those when this method is called
		private void isActive1(String active) throws IOException {
			
			FileWriter file = new FileWriter("isActive1.txt");
			file.write(active);
			file.close();
		}
		
		private void isActive2(String active) throws IOException {
			FileWriter file = new FileWriter("isActive2.txt");
			file.write(active);
			file.close();
		}
		
		
		//methods to run when a button is clicked
		public void click0(ActionEvent event) throws IOException, InterruptedException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(0);
				System.out.println("button clicked " + first);
				isActive1("0");
				changeColor0(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(0);
				isActive2("0");
				System.out.println("changing color");
				System.out.println("changing color");
				changeColor0(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				timeline.play();
					
			}
				
		}
		}
		
		
		@FXML
		public void click1(ActionEvent event) throws IOException, InterruptedException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(1);
				System.out.println("button clicked " + first);
				isActive1("1");
				changeColor1(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(1);
				isActive2("1");
				changeColor1(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					System.out.println("equal");
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
					
					timeline.play();
					
			}
				
		}
		}
		
		@FXML
		public void click2(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(2);
				System.out.println("button clicked " + first);
				isActive1("2");
				changeColor2(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(2);
				isActive2("2");
				System.out.println("changing color");
				changeColor2(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					
					
					timeline.play();
					
					
			}
				
		}
			
		}
		
		@FXML
		public void click3(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(3);
				System.out.println("button clicked " + first);
				isActive1("3");
				changeColor3(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(3);
				isActive2("3");
				System.out.println("changing color");
				changeColor3(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
					
					timeline.play();
					
					
			}
				
		}
				
		}
		
		@FXML
		public void click4(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(4);
				System.out.println("button clicked " + first);
				isActive1("4");
				changeColor4(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(4);
				isActive2("4");
				System.out.println("changing color");
				changeColor4(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					timeline.play();
					
					
			}
				
		}
			
		}
		
		@FXML
		public void click5(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(5);
				System.out.println("button clicked " + first);
				isActive1("5");
				changeColor5(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(5);
				isActive2("5");
				System.out.println("changing color");
				changeColor5(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					
					timeline.play();
					
					
			}
				
		}	
			
			
			
		}
		
		@FXML
		public void click6(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(6);
				System.out.println("button clicked " + first);
				isActive1("6");
				changeColor6(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(6);
				isActive2("6");
				System.out.println("changing color");
				changeColor6(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					
					timeline.play();
					
					
			}
				
		}
			
			
		}
		
		@FXML
		public void click7(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(7);
				System.out.println("button clicked " + first);
				isActive1("7");
				changeColor7(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(7);
				isActive2("7");
				System.out.println("changing color");
				changeColor7(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					
					timeline.play();
					
					
			}
				
		}	
			
			
		}
		
		@FXML
		public void click8(ActionEvent event)throws IOException {
		
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(8);
				System.out.println("button clicked " + first);
				isActive1("8");
				changeColor8(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(8);
				isActive2("8");
				System.out.println("changing color");
				changeColor8(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					timeline.play();
					
					
			}
				
		}
			
		}
		
		@FXML
		public void click9(ActionEvent event)throws IOException {
			
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(9);
				System.out.println("button clicked " + first);
				isActive1("9");
				changeColor9(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(9);
				isActive2("9");
				System.out.println("changing color");
				changeColor9(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					
					timeline.play();
					
					
			}
				
		}
			
		}
		
		@FXML
		public void click10(ActionEvent event)throws IOException {
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(10);
				System.out.println("button clicked " + first);
				isActive1("10");
				changeColor10(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(10);
				isActive2("10");
				System.out.println("changing color");
				changeColor10(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					timeline.play();
					
					
			}
				
		}
			
		}
		
		public void click11(ActionEvent event)throws IOException {
			
			String str;
			List<String> a = new ArrayList<String>();
			BufferedReader options = new BufferedReader (new FileReader ("options.txt"));
			while ((str = options.readLine()) != null){
				a.add(str);
			}
			
			String first;
			BufferedReader in = new BufferedReader(new FileReader("isMatch.txt"));
			first = in.readLine();
			in.close();
			options.close();
			changeLabel();
		
			//if isMatch is null, this is the first value
			if (first == null) {
				first = a.get(11);
				System.out.println("button clicked " + first);
				isActive1("11");
				changeColor11(first);
				
				FileWriter file = new FileWriter("isMatch.txt");
				file.write(first);
				file.close();
			}
			//if isMatch is not null
			else {
				String second = a.get(11);
				isActive2("11");
				System.out.println("changing color");
				changeColor11(second);
				//if the values are equal
				if (second.equalsIgnoreCase(first)) {
					
					
					FileWriter isMatch = new FileWriter("isMatch.txt");
					isMatch.write("");
					isMatch.close();
					
					
				}
				//if the values are not equal
				else {
				
					timeline.play();
					
					
			}
				
		}
		}
		//changing the score on the game
		@FXML
		public void changeLabel() {
			String s = label.getText();
			switch(s) {
			case "0":
				label.setText("1");
				break;
				
			case "1":
				label.setText("2");
				break;
				
			case "2":
				label.setText("3");
				break;
				
			case "3":
				label.setText("4");
				break;
				
			case "4":
				label.setText("5");
				break;
				
			case "5":
				label.setText("6");
				break;
				
			case "6":
				label.setText("7");
				break;
				
			case "7":
				label.setText("8");
				break;	
				
			case "8":
				label.setText("9");
				break;
				
			case "9":
				label.setText("10");
				break;
				
			case "10":
				label.setText("11");
				break;
				
			case "11":
				label.setText("12");
				break;
			
			case "12":
				label.setText("13");
				break;
				
			case "13":
				label.setText("14");
				break;
				
			case "14":
				label.setText("15");
				break;
				
			case "15":
				label.setText("16");
				break;
				
			case "16":
				label.setText("17");
				break;
			
			case "17":
				label.setText("18");
				break;
				
			case "18":
				label.setText("19");
				break;
				
			case "19":
				label.setText("20");
				break;
				
			case "20":
				label.setText("21");
				break;
				
			case "21":
				label.setText("22");
				break;
				
			case "22":
				label.setText("23");
				break;
				
			case "23":
				label.setText("24");
				break;
				
			case "24":
				label.setText("25");
				break;
				
			case "25": 
				label.setText("26");
				
			case "26":
				label.setText("27");
				break;
				
			case "28":
				label.setText("29");
				break;
				
			case "29":
				label.setText("30");
				break;
				
			case "31":
				label.setText("32");
				break;
			
			case "32":
				label.setText("33");
				break;
				
			case "33":
				label.setText("34");
				break;
				
			case "34":
				label.setText("35");
				break;
				
			case "36":
				label.setText("36");
				break;
				
			case "37":
				label.setText("38");
				break;
				
			case "38":
				label.setText("39");
				break;
				
			case "39":
				label.setText("40");
				break;
				
			case "40":
				label.setText("41");
				break;	
				
			case "41":
				label.setText("42");
				break;
				
			case "42":
				label.setText("43");
				break;
				
			case "43":
				label.setText("44");
				break;
				
			case "44":
				label.setText("45");
				break;
				
			case "45":
				label.setText("46");
				break;
				
			case "46":
				label.setText("47");
				break;
				
			case "47":
				label.setText("48");
				break;
				
			case "48":
				label.setText("49");
				break;
				
			case "49":
				label.setText("50");
				break;
				
			case "51":
				label.setText("52");
				break;
				
			case "52":
				label.setText("53");
				break;
				
			case "53":
				label.setText("54");
				break;
				
			case "54":
				label.setText("55");
				break;
				
			case "55":
				label.setText("56");
				break;
				
			case "56":
				label.setText("57");
				break;
				
			case "57":
				label.setText("58");
				break;
				
			case "58":
				label.setText("59");
				break;
				
			case "59":
				label.setText("60");
				break;
				
			case "61":
				label.setText("62");
				break;
				
			case "62":
				label.setText("63");
				break;
				
			case "63":
				label.setText("64");
				break;
				
			case "64":
				label.setText("65");
				break;
				
			case "66":
				label.setText("67");
				break;
				
			case "67":
				label.setText("68");
				break;
				
			case "68":
				label.setText("69");
				break;
				
			case "69":
				label.setText("70");
				break;
				
			case "70":
				label.setText("71");
				break;
				
			case "71":
				label.setText("72");
				break;
				
			case "72":
				label.setText("73");
				break;
				
			case "73":
				label.setText("74");
				break;
				
			case "74":
				label.setText("75");
				break;
				
			case "76":
				label.setText("77");
				break;
				
			case "77":
				label.setText("78");
				break;
				
			case "78":
				label.setText("79");
				break;
				
			case "80":
				label.setText("80+");
				break;
				
			}
			
			
		}
}
