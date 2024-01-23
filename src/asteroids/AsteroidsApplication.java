package asteroids;
//David Grot CSI2999

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import application.Controller;
import application.astStatsCalc;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class AsteroidsApplication extends Application {
	//set width and height integers to 700 by 450.
    public static int WIDTH = 700;
    public static int HEIGHT = 450;
    //set a universal font
    Font font = Font.font("Verdana", FontWeight.BOLD, 25);
    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }
    //monitor game time
    long startTime = System.currentTimeMillis();

    Text ScoreText = new Text(20, 30, "SCORE: 0");
    
    @Override
    public void start(Stage window) throws Exception {
    	//Create hashmap for buttons
        Map<KeyCode, Boolean> keysPressed = new HashMap<>();
        //create arraylist for on-screen asteroids
        ArrayList<Character> asteroids = new ArrayList<>();
        //create arraylist for on-screen ammo
        List<Ammo> ammolist = new ArrayList<>();
        // Used to create window size using the integers we set.
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        //Set scene
        Scene scene = new Scene(pane);
        Image img = new Image("/spacebackground.png");
        scene.setFill(new ImagePattern(img));
        scene.setOnKeyPressed((event) -> {
            keysPressed.put(event.getCode(), true);
        });
        scene.setOnKeyReleased((event) -> {
            keysPressed.put(event.getCode(), false);
        });
        
        ImageView im = new ImageView(img);
        im.setLayoutX(0);
        im.setY(0);
        im.toBack();
        im.toBack();
        pane.getChildren().add(im);
        
        //Add ship to the stage to the middle of the screen.
        Ship ship = new Ship(WIDTH/2, HEIGHT/2);
        pane.getChildren().add(ship.getCharacter());


        //Add 10 random asteroids starting from 1 pixel and max height (sides of the screen).
        for (int i = 0; i < 10; i++) {
            Random rnd = new Random();
            asteroids.add(new Asteroid(rnd.nextInt(1), rnd.nextInt(HEIGHT)));
            pane.getChildren().add(asteroids.get(i).getCharacter());
        }

        
        //Add atomic integer for score onto the stage and set to 0
        AtomicInteger AsteroidScore = new AtomicInteger();
       // Text ScoreText = new Text(20, 30, "SCORE: 0");
        ScoreText.setFill(Color.WHITE);
        ScoreText.setFont(font);
        pane.getChildren().add(ScoreText);

        //add amimation timer. Add key pressed controls.
        new AnimationTimer() {
            @Override

            public void handle(long now) {
            	//if left arrow clicked turn left
                if (keysPressed.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                //if right arrow clicked turn right
                if (keysPressed.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                //if up arrow clicked, accelerate
                if (keysPressed.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();            
                }

                //if spacebar clicked
                if (keysPressed.getOrDefault(KeyCode.SPACE, false) && ammolist.size() < 5) {
                	System.out.println(System.currentTimeMillis() + " ");
                	//get character ship location and set ammo to that location
                    Ammo ammo = new Ammo((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    //get character ship rotation and set the ammo rotation
                    ammo.getCharacter().setRotate(ship.getCharacter().getRotate());
                    //add ammo to the array
                    ammolist.add(ammo);
                    //set ammo to accelerate
                    ammo.accelerate();
                    //set the ammo speed
                    ammo.setMovement(ammo.getMovement().normalize().multiply(3));
                    //add ammo to screen
                    pane.getChildren().add(ammo.getCharacter());
                }

                //move ship
                ship.move();
                //if asteroid array list is less than 1 stop the program because player cheated
                if(asteroids.size()<1){
                	stop();
                	ScoreText.setText("Cheater");
                	
                }
                //asteroid array for each move and if collide stop game and show game over and score
                asteroids.stream().forEach((asteroid) -> {
                    asteroid.move();
                    if (ship.collide(asteroid)) {
                        stop();
                        Text GameOver = new Text("GAME OVER");
                        GameOver.setFont(Font.font("Verdana", FontWeight.BOLD, 65));
                        GameOver.layoutXProperty().bind(scene.widthProperty().subtract(GameOver.prefWidth(-1)).divide(2));
                        GameOver.setY(250);
                        GameOver.setFill(Color.RED);
                        GameOver.setStroke(Color.BLACK);
                        GameOver.setStrokeWidth(1);
                        pane.getChildren().add(GameOver);
                        ScoreText.layoutXProperty().bind(scene.widthProperty().subtract(ScoreText.prefWidth(-1)).divide(2).subtract(25));
                        ScoreText.setY(150);
                        ScoreText.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
                        
                        
                        
                        //Brendon's Code
                        
                        Controller n = new Controller();
                        Button btn = new Button();
                        im.toBack();
                        btn.setText("Exit");
                        btn.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
                        btn.setLayoutY(275);
                        btn.setLayoutX(265);
                        btn.setTextFill(Color.RED);
                        btn.toFront();
                        
                        EventHandler<ActionEvent> event = new EventHandler<ActionEvent> () {
                        	public void handle(ActionEvent e) {
                        		try {
                        			
                        			rewriteFile();
                        			System.out.println(ScoreText.getText());
									n.astReturn((ActionEvent) e);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                        	}
                        }; 
                            
                        btn.setOnAction(event);
                        pane.getChildren().add(btn);
                        
                    }
                });
                
                //End of Brendon's Code
                
                
                //add 1 to the score every time the screen is refreshed
                ScoreText.setText("" + AsteroidScore.incrementAndGet());
                //ammo array list for each asteroid move
                ammolist.forEach(asteroid -> asteroid.move());
                //ammo array list for each ammo if collide set not alive and the asteroid not alive
                ammolist.forEach(ammo -> {
                    asteroids.forEach(asteroid -> {
                        if (ammo.collide(asteroid)) {
                            ammo.setAlive(false);
                            asteroid.setAlive(false);
                            //if ammo is hit add 500 points to asteroids score the score text.
                            if (!ammo.isAlive()) {
                                ScoreText.setText(""+AsteroidScore.addAndGet(500));
                                ScoreText.setFill(Color.WHITE);                                
                                ScoreText.setFont(font);
                            }
                        }
                    });
                });

                //ammo array list stream filter for not alive and remove
                ammolist.stream()
                        .filter(ammo -> !ammo.isAlive())
                        .forEach(ammo -> pane.getChildren().remove(ammo.getCharacter()));
                ammolist.removeAll(ammolist.stream()
                        .filter(ammo -> !ammo.isAlive())
                        .collect(Collectors.toList()));
                //asteroid array list filter for not alive and remove
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));

                //2.5% chance new asteroid will show up and add to scene
                if (Math.random() < 0.025) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }

                }

            }
        }.start();

        //start and set scene on the window screen and title and set so window can't be resized
        window.setScene(scene);
        window.setTitle("AsteroidsFX");
        window.show();
        window.setResizable(false);

    }
    
    //Statistics Code
    
    astStatsCalc player;

    private void rewriteFile() throws IOException{
    	
    	player = new astStatsCalc(Integer.parseInt(ScoreText.getText()));
    	int counter = 0;
	
    	double score1 = 0;
    	int prv =0;
    	double ave=0;
    	int h=0;
    	int l =0;
	
	try {
		BufferedReader br = new BufferedReader(new FileReader("Asteroid.txt"));
		
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
		
	FileWriter wr1 = new FileWriter("Asteroid.txt");
	
	wr1.write(ScoreText.getText() + "\n");
	wr1.write(ScoreText.getText() + "\n"); 
	wr1.write(ScoreText.getText() + "\n"); 
	wr1.write(ScoreText.getText() + "\n");
	wr1.write(ScoreText.getText() + "\n"); 
	wr1.write(Integer.toString(1));
	wr1.close();
	
	} else if (score1 != 0){
	
	FileWriter wr2 = new FileWriter("Asteroid.txt");
	
	wr2.write(ScoreText.getText() + "\n");
	double rpl = score1 + Double.parseDouble(ScoreText.getText());
	wr2.write(Double.toString(rpl) + "\n");
	wr2.write(Double.toString(ave) + "\n");
	wr2.write(Integer.toString(h) + "\n");
	wr2.write(Integer.toString(l) + "\n");
	wr2.write(counter += 1);
	wr2.close();
	
	System.out.println("current score: " + ScoreText.getText() + "\nHigh score: " + player.HighScore() + "\nAve score: " + player.AveScore());
	
	FileWriter wr = new FileWriter("Asteroid.txt");
	
	
	wr.write(ScoreText.getText()+ "\n");
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

