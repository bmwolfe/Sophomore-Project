package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.image.ImageView;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import slotmachine.Slot;
import asteroids.AsteroidsApplication;
import asteroids.Ship;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;

public class Controller implements Initializable {
	
	private int jeopScore = 0;
	private double jeopAve = 0;
	private int jeopMax = 0;
	private int jeopMin = Integer.MAX_VALUE;
	private int counter = 0;
	
	@FXML
	private Button btn_achieve;
	
	@FXML
	private Button btn_stats;
	
	@FXML
	private Button btn_ast;
	
	@FXML
	private Button btn_blj;
	
	@FXML
	private Button btn_mat;
	
	@FXML
	private Label jeopScr;
	
	@FXML
	private Label lbl;
	
	@FXML
	private Label lbl2;
	
	@FXML
	private Label lbl3;
	
	@FXML
	private Label lbl4;
	
	
	public void returnToMain(ActionEvent event) throws IOException {
		Parent main = FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene mainScene = new Scene(main);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void displayStats(ActionEvent event) throws IOException {
		Parent stats = FXMLLoader.load(getClass().getResource("Stats.fxml"));
		Scene statsScene = new Scene(stats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(statsScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void astStats(ActionEvent event) throws IOException {
		Parent astStats = FXMLLoader.load(getClass().getResource("AstStats.fxml"));
		Scene astStatsScene = new Scene(astStats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(astStatsScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void bljStats(ActionEvent event) throws IOException {
		Parent bljStats = FXMLLoader.load(getClass().getResource("bljStats.fxml"));
		Scene bljStatsScene = new Scene(bljStats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(bljStatsScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void matStats(ActionEvent event) throws IOException {
		Parent matStats = FXMLLoader.load(getClass().getResource("matStats.fxml"));
		Scene matStatsScene = new Scene(matStats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(matStatsScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void jeopStats(ActionEvent event) throws IOException {
		
		Parent matStats = FXMLLoader.load(getClass().getResource("jeopStats.fxml"));
		Scene matStatsScene = new Scene(matStats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(matStatsScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void tbdStats(ActionEvent event) throws IOException {
		Parent matStats = FXMLLoader.load(getClass().getResource("tbd.fxml"));
		Scene matStatsScene = new Scene(matStats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(matStatsScene);
		window.setResizable(false);
		window.show();
		
	}
	
	
	//duplicate this for the other games
	public void changeTxt(ActionEvent event) throws IOException { 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("jeop.txt"));
			
			jeopScore = Integer.parseInt(br.readLine());
			br.readLine();
			jeopAve = Double.parseDouble(br.readLine());
			jeopMax = Integer.parseInt(br.readLine());
			jeopMin = Integer.parseInt(br.readLine());
			counter = Integer.parseInt(br.readLine()); 
			
			br.close();
			
		} catch(Exception e) {
			
		}
		lbl.setText(""+jeopScore);
		lbl2.setText(""+jeopAve);
		lbl3.setText(""+jeopMax);
		lbl4.setText(""+jeopMin);
		
	}
	
	public void changeTxt1(ActionEvent event) throws IOException { 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("mat.txt"));
			
			jeopScore = Integer.parseInt(br.readLine());
			br.readLine();
			jeopAve = Double.parseDouble(br.readLine());
			jeopMax = Integer.parseInt(br.readLine());
			jeopMin = Integer.parseInt(br.readLine());
			counter = Integer.parseInt(br.readLine()); 
			
			br.close();
			
		} catch(Exception e) {
			
		}
		lbl.setText(""+jeopScore);
		lbl2.setText(""+jeopAve);
		lbl3.setText(""+jeopMax);
		lbl4.setText(""+jeopMin);
		
	}
	
	public void changeTxt2(ActionEvent event) throws IOException { 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("tbd.txt"));
			
			jeopScore = Integer.parseInt(br.readLine());
			br.readLine();
			jeopAve = Double.parseDouble(br.readLine());
			jeopMax = Integer.parseInt(br.readLine());
			jeopMin = Integer.parseInt(br.readLine());
			counter = Integer.parseInt(br.readLine()); 
			
			br.close();
			
		} catch(Exception e) {
			
		}
		lbl.setText(""+jeopScore);
		lbl2.setText(""+jeopAve);
		lbl3.setText(""+jeopMax);
		lbl4.setText(""+jeopMin);
		
	}
	
	public void changeTxt3(ActionEvent event) throws IOException { 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Asteroid.txt"));
			
			jeopScore = Integer.parseInt(br.readLine());
			br.readLine();
			jeopAve = Double.parseDouble(br.readLine());
			jeopMax = Integer.parseInt(br.readLine());
			jeopMin = Integer.parseInt(br.readLine());
			counter = Integer.parseInt(br.readLine()); 
			
			br.close();
			
		} catch(Exception e) {
			
		}
		lbl.setText(""+jeopScore);
		lbl2.setText(""+jeopAve);
		lbl3.setText(""+jeopMax);
		lbl4.setText(""+jeopMin);
		
	}
	
	public void changeTxt4(ActionEvent event) throws IOException { 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("blackjack.txt"));
			
			jeopScore = (int) Double.parseDouble(br.readLine());
			br.readLine();
			jeopAve = Double.parseDouble(br.readLine());
			jeopMax = (int) Double.parseDouble(br.readLine());
			jeopMin = (int) Double.parseDouble(br.readLine());
			counter = Integer.parseInt(br.readLine()); 
			
			br.close();
			
		} catch(Exception e) {
			
		}
		lbl.setText(""+jeopScore);
		lbl2.setText(""+jeopAve);
		lbl3.setText(""+jeopMax);
		lbl4.setText(""+jeopMin);
		
	}
	
	//
	
	public void newPlayer(ActionEvent event) throws IOException {
		FileWriter wr = new FileWriter("jeop.txt");
		
		wr.write(Integer.toString(0) + "\n");
		wr.write(Double.toString(0) + "\n");
		wr.write(Double.toString(0) + "\n");
		wr.write(Integer.toString(0) + "\n");
		wr.write(Integer.toString(Integer.MAX_VALUE) + "\n");
		wr.write(Integer.toString(0));
		
		wr.close();
		
		FileWriter wr1 = new FileWriter("Asteroid.txt");
		
		wr1.write(Integer.toString(0) + "\n");
		wr1.write(Double.toString(0) + "\n");
		wr1.write(Double.toString(0) + "\n");
		wr1.write(Integer.toString(0) + "\n");
		wr1.write(Integer.toString(Integer.MAX_VALUE) + "\n");
		wr1.write(Integer.toString(0));
		
		wr1.close();
		
		FileWriter wr2 = new FileWriter("mat.txt");
		
		wr2.write(Integer.toString(0) + "\n");
		wr2.write(Double.toString(0) + "\n");
		wr2.write(Double.toString(0) + "\n");
		wr2.write(Integer.toString(0) + "\n");
		wr2.write(Integer.toString(Integer.MAX_VALUE) + "\n");
		wr2.write(Integer.toString(0));
		
		wr2.close();
		
		FileWriter wr3 = new FileWriter("blackjack.txt");
		
		wr3.write(Integer.toString(0) + "\n");
		wr3.write(Double.toString(0) + "\n");
		wr3.write(Double.toString(0) + "\n");
		wr3.write(Integer.toString(0) + "\n");
		wr3.write(Integer.toString(Integer.MAX_VALUE) + "\n");
		wr3.write(Integer.toString(0));
		
		wr3.close();
		
		FileWriter wr4 = new FileWriter("tbd.txt");
		
		wr4.write(Integer.toString(0) + "\n");
		wr4.write(Double.toString(0) + "\n");
		wr4.write(Double.toString(0) + "\n");
		wr4.write(Integer.toString(0) + "\n");
		wr4.write(Integer.toString(Integer.MAX_VALUE) + "\n");
		wr4.write(Integer.toString(0));
		
		wr4.close();
	}
	
	public void mainReturn(ActionEvent event) throws IOException {
		Parent mainRe = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene mainReScene = new Scene(mainRe);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainReScene);
		window.setResizable(false);
		window.show();
		
	}
	
	public void close(ActionEvent event) throws IOException {
		Parent mainRe = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene mainReScene = new Scene(mainRe);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainReScene);
		window.setResizable(false);
		window.close();
		
	}
	
	public void jeop(ActionEvent event) throws IOException{
		Parent mainRe = FXMLLoader.load(getClass().getResource("jeopardy.fxml"));
		Scene mainReScene = new Scene(mainRe);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainReScene);
		window.setResizable(false);
		window.show();
	}
	
	public void Match(ActionEvent event) throws IOException{
		Parent mainRe = FXMLLoader.load(getClass().getResource("Game.fxml"));
		Scene mainReScene = new Scene(mainRe);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainReScene);
		window.setResizable(false);
		window.show();
	}
	
	public void Cookie(ActionEvent event) throws IOException{
		Parent mainRe = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene mainReScene = new Scene(mainRe);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainReScene);
		window.setResizable(false);
		window.show();
	}
	
	public void ast(ActionEvent event) throws Exception {
		

	    int WIDTH = 700;
	    int HEIGHT = 450;
		
		Stage window = new Stage();
		Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);

        //Add ship to the stage to the middle of the screen.
        Ship ship = new Ship(WIDTH/2, HEIGHT/2);
        pane.getChildren().add(ship.getCharacter());

    	AsteroidsApplication h = new AsteroidsApplication();
    	
    	Scene scene = new Scene(pane);
        Image img = new Image("/spacebackground.png");
        scene.setFill(new ImagePattern(img));
        window.setScene(scene);
        window.setTitle("AsteroidsFX");
		window.setResizable(false);
        window.show();
		
		h.start(window);
	}

	public void slots(ActionEvent event) throws Exception {
		

		Stage window = new Stage();
		Pane pane = new Pane();
		
    	Slot h = new Slot();
    	
    	h.start(window);
	}
	
	
	public void astReturn(ActionEvent event) throws IOException {
		Parent mainRe = FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene mainReScene = new Scene(mainRe);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainReScene);
		window.setResizable(false);
		window.close();
		
	}
	

	
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
}
