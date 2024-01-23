package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

	public class jeopController {
	private int i = 0;
	private int k = 0;
	//private int z = 0;
	
	private int scr = 0;
	
	String path = "RPReplay_Final1667329849.mp4";
	Media media = new Media(new File(path).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	playerStats player;
	
	//This plays the Jeopardy music
	
	public void playSound(ActionEvent event) throws IOException{
		
		if(k == 0) {
		mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
		mediaPlayer.play();
		k++;;
		} else if(k>0){
			mediaPlayer.stop();
			k = 0;
		}
	}
	
	//This label saves the score from the game
	
	@FXML
	private Label score;
	
	
	//This method returns the user to the game selector page
	//If the user did not play the game, nothing is saved
	//If the user does play the game, the rewriteFile method is called and score is saved
	
	public void returnToMain(ActionEvent event) throws IOException {
		
		mediaPlayer.stop();
		
		if(score.getText().equals("Score")) {
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
		player = new playerStats(Integer.parseInt(score.getText()));
		int counter = 0; //player.getCounter()
		
		double score1 = 0;
		int prv =0;
		double ave=0;
		int h=0;
		int l =0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("jeop.txt"));
			
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
			
		FileWriter wr1 = new FileWriter("jeop.txt");
		
		wr1.write(score.getText() + "\n");
		wr1.write(score.getText() + "\n"); 
		wr1.write(score.getText() + "\n"); 
		wr1.write(score.getText() + "\n");
		wr1.write(score.getText() + "\n"); 
		wr1.write(Integer.toString(1));
		wr1.close();
		
		} else if (score1 != 0){
		
		FileWriter wr2 = new FileWriter("jeop.txt");
		
		wr2.write(score.getText() + "\n");
		double rpl = score1 + Double.parseDouble(score.getText());
		wr2.write(Double.toString(rpl) + "\n");
		wr2.write(Double.toString(ave) + "\n");
		wr2.write(Integer.toString(h) + "\n");
		wr2.write(Integer.toString(l) + "\n");
		wr2.write(counter += 1);
		wr2.close();
		
		System.out.println("current score: " + score.getText() + "\nHigh score: " + player.jeopHighScore() + "\nAve score: " + player.jeopAveScore());
		
		FileWriter wr = new FileWriter("jeop.txt");
		
		
		wr.write(score.getText()+ "\n");
		wr.write(Double.toString(rpl) + "\n"); 
		wr.write(Double.toString(player.getJeopAve()) + "\n");		//finds average score
		
		h = player.jeopHighScore();									//finds highest score
		wr.write(Integer.toString(h) + "\n");
		
		l = player.jeopLowScore();									//finds lowest score
		wr.write(Integer.toString(l) + "\n");
		
		
		wr.write(Integer.toString(counter));
		wr.close();
		
		}
		
		
	}
	
	//These buttons are the main 30 buttons you see on screen to choose a question
	
	@FXML
	private Button btn_1;
	
	@FXML
	private Button btn_2;
	
	@FXML
	private Button btn_3;
	
	@FXML
	private Button btn_4;
	
	@FXML
	private Button btn_5;
	
	@FXML
	private Button btn_6;
	
	@FXML
	private Button btn_7;
	
	@FXML
	private Button btn_8;
	
	@FXML
	private Button btn_9;
	
	@FXML
	private Button btn_10;
	
	@FXML
	private Button btn_11;
	
	@FXML
	private Button btn_12;
	
	@FXML
	private Button btn_13;
	
	@FXML
	private Button btn_14;
	
	@FXML
	private Button btn_15;
	
	@FXML
	private Button btn_16;
	
	@FXML
	private Button btn_17;
	
	@FXML
	private Button btn_18;
	
	@FXML
	private Button btn_19;
	
	@FXML
	private Button btn_20;
	
	@FXML
	private Button btn_21;
	
	@FXML
	private Button btn_22;
	
	@FXML
	private Button btn_23;
	
	@FXML
	private Button btn_24;
	
	@FXML
	private Button btn_25;
	
	@FXML
	private Button btn_26;
	
	@FXML
	private Button btn_27;
	
	@FXML
	private Button btn_28;
	
	@FXML
	private Button btn_29;
	
	@FXML
	private Button btn_30;
	
	//These buttons and image are the questions that pop up on the screen to be answered
	
	@FXML
	private ImageView img1;
	
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
	
	@FXML
	private Button btn12;
	
	@FXML
	private Button btn13;
	
	@FXML
	private Button btn14;
	
	@FXML
	private Button btn15;
	
	@FXML
	private Button btn16;
	
	@FXML
	private Button btn17;
	
	@FXML
	private Button btn18;
	
	@FXML
	private Button btn19;
	
	@FXML
	private Button btn20;

	@FXML
	private Button btn21;
	
	@FXML
	private Button btn22;
	
	@FXML
	private Button btn23;
	
	@FXML
	private Button btn24;
	
	@FXML
	private Button btn25;
	
	@FXML
	private Button btn26;
	
	@FXML
	private Button btn27;
	
	@FXML
	private Button btn28;
	
	@FXML
	private Button btn29;
	
	@FXML
	private Button finalJ;
	
	@FXML
	private Button btn30;
	
	//This button has the playSound method attached to play the music
	
	@FXML
	private Button think;
	
	//These buttons appear when the layer chooses a question, this allows the player to
	//determine whether they are right or wrong, if they are right their score is increased
	
	@FXML
	private Button cor1;
	
	@FXML
	private Button cor2;
	
	@FXML
	private Button cor3;
	
	@FXML
	private Button cor4;
	
	@FXML
	private Button cor5;
	
	@FXML
	private Button wrong;
	
	//These methods make the cover buttons clear so you can see the question under them
	//once a question is chosen
	
	public void makeButtonFinalClear(ActionEvent event) throws IOException {
		if(i < 1) {
			finalJ.setStyle("-fx-background-color: transparent;");
			finalJ.setText(null);
			btn30.setScaleX(4);
			btn30.setScaleY(4);
			btn30.toFront();
			btn30.setLayoutX(250);
			btn30.setLayoutY(175);
			finalJ.toFront();
			i++;
			} else if(i > 0){
				btn30.setScaleX(1);
				btn30.setScaleY(1);
				btn30.setLayoutX(634.5);
				btn30.setLayoutY(300);
				i = 0;
			}
	}
	
	public void makeButton1Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_1.setStyle("-fx-background-color: transparent;");
			btn_1.setText(null);
			btn4.setScaleX(4);
			btn4.setScaleY(4);
			btn4.toFront();
			btn4.setLayoutX(250);
			btn4.setLayoutY(175);
			btn_1.toFront();
			cor1.toFront();
			wrong.toFront();
			i++;
			} else if(i > 0){
				btn4.setScaleX(1);
				btn4.setScaleY(1);
				btn4.setLayoutX(0);
				btn4.setLayoutY(68);
				i = 0;
			}
	}
	
	public void makeButton2Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_2.setStyle("-fx-background-color: transparent;");
			btn_2.setText(null);
			btn9.setScaleX(4);
			btn9.setScaleY(4);
			btn9.toFront();
			btn9.setLayoutX(250);
			btn9.setLayoutY(175);
			btn_2.toFront();
			cor1.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn9.setScaleX(1);
				btn9.setScaleY(1);
				btn9.setLayoutX(100.5);
				btn9.setLayoutY(68);
				btn_2.toFront();
				i = 0;
			}
	}
	
	public void makeButton3Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_3.setStyle("-fx-background-color: transparent;");
			btn_3.setText(null);
			btn24.setScaleX(4);
			btn24.setScaleY(4);
			btn24.toFront();
			btn24.setLayoutX(250);
			btn24.setLayoutY(175);
			btn_3.toFront();
			cor1.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn24.setScaleX(1);
				btn24.setScaleY(1);
				btn24.setLayoutX(200.1);
				btn24.setLayoutY(68);
				i = 0;
			}
	}
	
	public void makeButton4Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_4.setStyle("-fx-background-color: transparent;");
			btn_4.setText(null);
			btn28.setScaleX(4);
			btn28.setScaleY(4);
			btn28.toFront();
			btn28.setLayoutX(250);
			btn28.setLayoutY(175);
			btn_4.toFront();
			cor1.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn28.setScaleX(1);
				btn28.setScaleY(1);
				btn28.setLayoutX(300.2);
				btn28.setLayoutY(68);
				i = 0;
			}
	}
	
	public void makeButton5Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_5.setStyle("-fx-background-color: transparent;");
			btn_5.setText(null);
			btn14.setScaleX(4);
			btn14.setScaleY(4);
			btn14.toFront();
			btn14.setLayoutX(250);
			btn14.setLayoutY(175);
			btn_5.toFront();
			cor1.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn14.setScaleX(1);
				btn14.setScaleY(1);
				btn14.setLayoutX(400.5);
				btn14.setLayoutY(68);
				i = 0;
			}
	}
	
	public void makeButton6Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_6.setStyle("-fx-background-color: transparent;");
			btn_6.setText(null);
			btn19.setScaleX(4);
			btn19.setScaleY(4);
			btn19.toFront();
			btn19.setLayoutX(250);
			btn19.setLayoutY(175);
			btn_6.toFront();
			cor1.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn19.setScaleX(1);
				btn19.setScaleY(1);
				btn19.setLayoutX(500.5);
				btn19.setLayoutY(68);
				i = 0;
			}
	}
	
	public void makeButton7Clear(ActionEvent event) throws IOException {
		if(i < 1) {
		btn_7.setStyle("-fx-background-color: transparent;");
		btn_7.setText(null);
		btn3.setScaleX(4);
		btn3.setScaleY(4);
		btn3.toFront();
		btn3.setLayoutX(250);
		btn3.setLayoutY(175);
		btn_7.toFront();
		cor2.toFront();
		wrong.toFront();
		i++;
		} else if(i > 0){
			btn3.setScaleX(1);
			btn3.setScaleY(1);
			btn3.setLayoutX(0);
			btn3.setLayoutY(136);
			i = 0;
		}
	}
	
	public void makeButton8Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_8.setStyle("-fx-background-color: transparent;");
			btn_8.setText(null);
			btn8.setScaleX(4);
			btn8.setScaleY(4);
			btn8.toFront();
			btn8.setLayoutX(250);
			btn8.setLayoutY(175);
			btn_8.toFront();
			cor2.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn8.setScaleX(1);
				btn8.setScaleY(1);
				btn8.setLayoutX(100.5);
				btn8.setLayoutY(135);
				btn_8.toFront();
				i = 0;
			}
	}
	
	public void makeButton9Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_9.setStyle("-fx-background-color: transparent;");
			btn_9.setText(null);
			btn23.setScaleX(4);
			btn23.setScaleY(4);
			btn23.toFront();
			btn23.setLayoutX(250);
			btn23.setLayoutY(175);
			btn_9.toFront();
			cor2.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn23.setScaleX(1);
				btn23.setScaleY(1);
				btn23.setLayoutX(200.1);
				btn23.setLayoutY(135);
				i = 0;
			}
	}
	
	public void makeButton10Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_10.setStyle("-fx-background-color: transparent;");
			btn_10.setText(null);
			btn27.setScaleX(4);
			btn27.setScaleY(4);
			btn27.toFront();
			btn27.setLayoutX(250);
			btn27.setLayoutY(175);
			btn_10.toFront();
			cor2.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn27.setScaleX(1);
				btn27.setScaleY(1);
				btn27.setLayoutX(300.2);
				btn27.setLayoutY(135);
				i = 0;
			}
	
	}
	
	public void makeButton11Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_11.setStyle("-fx-background-color: transparent;");
			btn_11.setText(null);
			btn13.setScaleX(4);
			btn13.setScaleY(4);
			btn13.toFront();
			btn13.setLayoutX(250);
			btn13.setLayoutY(175);
			btn_11.toFront();
			cor2.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn13.setScaleX(1);
				btn13.setScaleY(1);
				btn13.setLayoutX(400.5);
				btn13.setLayoutY(135);
				i = 0;
			}
	}
	
	public void makeButton12Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_12.setStyle("-fx-background-color: transparent;");
			btn_12.setText(null);
			btn18.setScaleX(4);
			btn18.setScaleY(4);
			btn18.toFront();
			btn18.setLayoutX(250);
			btn18.setLayoutY(175);
			btn_12.toFront();
			cor2.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn18.setScaleX(1);
				btn18.setScaleY(1);
				btn18.setLayoutX(500.5);
				btn18.setLayoutY(135);
				i = 0;
			}
	}
	
	public void makeButton13Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_13.setStyle("-fx-background-color: transparent;");
			btn_13.setText(null);
			btn2.setScaleX(4);
			btn2.setScaleY(4);
			btn2.toFront();
			btn2.setLayoutX(250);
			btn2.setLayoutY(175);
			btn_13.toFront();
			cor3.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn2.setScaleX(1);
				btn2.setScaleY(1);
				btn2.setLayoutX(0);
				btn2.setLayoutY(203.5);
				i = 0;
			}
	}
	
	public void makeButton14Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_14.setStyle("-fx-background-color: transparent;");
			btn_14.setText(null);
			btn7.setScaleX(4);
			btn7.setScaleY(4);
			btn7.toFront();
			btn7.setLayoutX(250);
			btn7.setLayoutY(175);
			btn_14.toFront();
			cor3.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn7.setScaleX(1);
				btn7.setScaleY(1);
				btn7.setLayoutX(100.5);
				btn7.setLayoutY(203.5);
				btn_14.toFront();
				i = 0;
			}
	}
	
	public void makeButton15Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_15.setStyle("-fx-background-color: transparent;");
			btn_15.setText(null);
			btn22.setScaleX(4);
			btn22.setScaleY(4);
			btn22.toFront();
			btn22.setLayoutX(250);
			btn22.setLayoutY(175);
			btn_15.toFront();
			cor3.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn22.setScaleX(1);
				btn22.setScaleY(1);
				btn22.setLayoutX(200.1);
				btn22.setLayoutY(203.5);
				i = 0;
			}
	}
	
	public void makeButton16Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_16.setStyle("-fx-background-color: transparent;");
			btn_16.setText(null);
			btn26.setScaleX(4);
			btn26.setScaleY(4);
			btn26.toFront();
			btn26.setLayoutX(250);
			btn26.setLayoutY(175);
			btn_16.toFront();
			cor3.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn26.setScaleX(1);
				btn26.setScaleY(1);
				btn26.setLayoutX(300.2);
				btn26.setLayoutY(203.5);
				i = 0;
			}
	}
	
	public void makeButton17Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_17.setStyle("-fx-background-color: transparent;");
			btn_17.setText(null);
			btn12.setScaleX(4);
			btn12.setScaleY(4);
			btn12.toFront();
			btn12.setLayoutX(250);
			btn12.setLayoutY(175);
			btn_17.toFront();
			cor3.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn12.setScaleX(1);
				btn12.setScaleY(1);
				btn12.setLayoutX(400.5);
				btn12.setLayoutY(203.5);
				i = 0;
			}
	}
	
	public void makeButton18Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_18.setStyle("-fx-background-color: transparent;");
			btn_18.setText(null);
			btn17.setScaleX(4);
			btn17.setScaleY(4);
			btn17.toFront();
			btn17.setLayoutX(250);
			btn17.setLayoutY(175);
			btn_18.toFront();
			cor3.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn17.setScaleX(1);
				btn17.setScaleY(1);
				btn17.setLayoutX(500.5);
				btn17.setLayoutY(203.5);
				i = 0;
			}
	}
	
	public void makeButton19Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_19.setStyle("-fx-background-color: transparent;");
			btn_19.setText(null);
			img1.setScaleX(4);
			img1.setScaleY(4);
			img1.toFront();
			img1.setX(250);
			img1.setY(-100);
			btn_19.toFront();
			cor4.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				img1.setScaleX(1);
				img1.setScaleY(1);
				img1.setX(0);
				img1.setY(0);
				i = 0;
			}
	}
	
	public void makeButton20Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_20.setStyle("-fx-background-color: transparent;");
			btn_20.setText(null);
			btn6.setScaleX(4);
			btn6.setScaleY(4);
			btn6.toFront();
			btn6.setLayoutX(250);
			btn6.setLayoutY(175);
			btn_20.toFront();
			cor4.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn6.setScaleX(1);
				btn6.setScaleY(1);
				btn6.setLayoutX(100.5);
				btn6.setLayoutY(269);
				btn6.toFront();
				i = 0;
			}
	}
	
	public void makeButton21Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_21.setStyle("-fx-background-color: transparent;");
			btn_21.setText(null);
			btn21.setScaleX(4);
			btn21.setScaleY(4);
			btn21.toFront();
			btn21.setLayoutX(250);
			btn21.setLayoutY(175);
			btn_21.toFront();
			cor4.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn21.setScaleX(1);
				btn21.setScaleY(1);
				btn21.setLayoutX(200.1);
				btn21.setLayoutY(269);
				i = 0;
			}
	}
	
	public void makeButton22Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_22.setStyle("-fx-background-color: transparent;");
			btn_22.setText(null);
			btn25.setScaleX(4);
			btn25.setScaleY(4);
			btn25.toFront();
			btn25.setLayoutX(250);
			btn25.setLayoutY(175);
			btn_22.toFront();
			cor4.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn25.setScaleX(1);
				btn25.setScaleY(1);
				btn25.setLayoutX(300.2);
				btn25.setLayoutY(269);
				i = 0;
			}
	}
	
	public void makeButton23Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_23.setStyle("-fx-background-color: transparent;");
			btn_23.setText(null);
			btn11.setScaleX(4);
			btn11.setScaleY(4);
			btn11.toFront();
			btn11.setLayoutX(250);
			btn11.setLayoutY(175);
			btn_23.toFront();
			cor4.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn11.setScaleX(1);
				btn11.setScaleY(1);
				btn11.setLayoutX(400.5);
				btn11.setLayoutY(269);
				i = 0;
			}
	}
	
	public void makeButton24Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_24.setStyle("-fx-background-color: transparent;");
			btn_24.setText(null);
			btn16.setScaleX(4);
			btn16.setScaleY(4);
			btn16.toFront();
			btn16.setLayoutX(250);
			btn16.setLayoutY(175);
			btn_24.toFront();
			cor4.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn16.setScaleX(1);
				btn16.setScaleY(1);
				btn16.setLayoutX(500.5);
				btn16.setLayoutY(269);
				i = 0;
			}
	}
	
	public void makeButton25Clear(ActionEvent event) throws IOException {
		if(i < 1) {
		btn_25.setStyle("-fx-background-color: transparent;");
		btn_25.setText(null);
		btn1.setScaleX(4);
		btn1.setScaleY(4);
		btn1.toFront();
		btn1.setLayoutX(250);
		btn1.setLayoutY(175);
		btn_25.toFront();
		cor5.toFront();
		wrong.toFront();
		i++;
		}else if(i > 0){
			btn1.setScaleX(1);
			btn1.setScaleY(1);
			btn1.setLayoutX(0);
			btn1.setLayoutY(335);
			i = 0;
		}
	}
	
	public void makeButton26Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_26.setStyle("-fx-background-color: transparent;");
			btn_26.setText(null);
			btn5.setScaleX(4);
			btn5.setScaleY(4);
			btn5.toFront();
			btn5.setLayoutX(250);
			btn5.setLayoutY(175);
			btn_26.toFront();
			cor5.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn5.setScaleX(1);
				btn5.setScaleY(1);
				btn5.setLayoutX(100.5);
				btn5.setLayoutY(335);
				i = 0;
			}
	}
	
	public void makeButton27Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_27.setStyle("-fx-background-color: transparent;");
			btn_27.setText(null);
			btn20.setScaleX(4);
			btn20.setScaleY(4);
			btn20.toFront();
			btn20.setLayoutX(250);
			btn20.setLayoutY(175);
			btn_27.toFront();
			cor5.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn20.setScaleX(1);
				btn20.setScaleY(1);
				btn20.setLayoutX(200.1);
				btn20.setLayoutY(335);
				i = 0;
			}
	}
	
	public void makeButton28Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_28.setStyle("-fx-background-color: transparent;");
			btn_28.setText(null);
			btn29.setScaleX(4);
			btn29.setScaleY(4);
			btn29.toFront();
			btn29.setLayoutX(250);
			btn29.setLayoutY(175);
			btn_28.toFront();
			cor5.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn29.setScaleX(1);
				btn29.setScaleY(1);
				btn29.setLayoutX(300.2);
				btn29.setLayoutY(335);
				i = 0;
			}
	}
	
	public void makeButton29Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_29.setStyle("-fx-background-color: transparent;");
			btn_29.setText(null);
			btn10.setScaleX(4);
			btn10.setScaleY(4);
			btn10.toFront();
			btn10.setLayoutX(250);
			btn10.setLayoutY(175);
			btn_29.toFront();
			cor5.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn10.setScaleX(1);
				btn10.setScaleY(1);
				btn10.setLayoutX(400.5);
				btn10.setLayoutY(335);
				i = 0;
			}
	}
	
	public void makeButton30Clear(ActionEvent event) throws IOException {
		if(i < 1) {
			btn_30.setStyle("-fx-background-color: transparent;");
			btn_30.setText(null);
			btn15.setScaleX(4);
			btn15.setScaleY(4);
			btn15.toFront();
			btn15.setLayoutX(250);
			btn15.setLayoutY(175);
			btn_30.toFront();
			cor5.toFront();
			wrong.toFront();
			i++;
			}else if(i > 0){
				btn15.setScaleX(1);
				btn15.setScaleY(1);
				btn15.setLayoutX(500.5);
				btn15.setLayoutY(335);
				i = 0;
			}
	}
	
	//These buttons allow the player to add to his/her score when they are correct
	
	public void add100(ActionEvent event) throws IOException{
		if(score.getText() == "Score") {
			score.setText("100");
			cor1.toBack();
			wrong.toBack();
		} else {
			scr += 100;
			score.setText("" + scr);
			cor1.toBack();
			wrong.toBack();
		}
	}
	
	public void add200(ActionEvent event) throws IOException{
		if(score.getText() == "Score") {
			score.setText("200");
			cor2.toBack();
			wrong.toBack();
		} else {
			scr += 200;
			score.setText("" + scr);
			cor2.toBack();
			wrong.toBack();
		}
	}
	
	public void add300(ActionEvent event) throws IOException{
		if(score.getText() == "Score") {
			score.setText("300");
			cor3.toBack();
			wrong.toBack();
		} else {
			scr += 300;
			score.setText("" + scr);
			cor3.toBack();
			wrong.toBack();
		}
	}
	
	public void add400(ActionEvent event) throws IOException{
		if(score.getText() == "Score") {
			score.setText("400");
			cor4.toBack();
			wrong.toBack();
		} else {
			scr += 400;
			score.setText("" + scr);
			cor4.toBack();
			wrong.toBack();
		}
	}
	
	public void add500(ActionEvent event) throws IOException{
		if(score.getText() == "Score") {
			score.setText("500");
			cor5.toBack();
			wrong.toBack();
		} else {
			scr += 500;
			score.setText("" + scr);
			cor5.toBack();
			wrong.toBack();
		}
	}
	
	//This just hides the score buttons so the player can't add points after they decide they are wrong on a question
	
	public void wrong(ActionEvent event) throws IOException {
		cor1.toBack();
		cor2.toBack();
		cor3.toBack();
		cor4.toBack();
		cor5.toBack();
		wrong.toBack();
	}
	
public void initialize(URL url, ResourceBundle rb) {
		
	}

}

