package readingFromFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class hangman extends Application {

	
	private static final int hangW = 900;
	private static final int hangH = 500;
	private static final Font defaultF = new Font("Arial", 30);
	
	// Word being guessed
	private SimpleStringProperty wordBeingGuessed = new SimpleStringProperty();
	// How many letters left to guess
	private SimpleIntegerProperty lettersLeft = new SimpleIntegerProperty();
    // Is game playable
	private SimpleBooleanProperty playable = new SimpleBooleanProperty();
	// List of letters in the word
	private ObservableList<Node> letters;
	// Characters
	private HashMap<Character, Text> alphabet = new HashMap<Character, Text>();
	
	private HangmanImage hangman = new HangmanImage(); 
	
	private readTxt readTxt = new readTxt();
	private readTxt2 readTxt2 = new readTxt2();
	private readTxt3 readTxt3 = new readTxt3();
	private readTxt4 readTxt4 = new readTxt4();
	
	    
	    
	public Parent createContent(){
		
		
		RadioButton para = new RadioButton();
		RadioButton sequential = new RadioButton();
		Label label = new Label("Please choose which mode you wish to choose words from");
		
		para.setText("Parallel");
		sequential.setText("Sequential");
		
		
		Pane pane = new Pane();
		pane.setPrefHeight(154);
		pane.setPrefWidth(437);
		pane.getChildren().add(para);
		para.setLayoutX(95);
		para.setLayoutY(59);
		pane.getChildren().add(sequential);
		sequential.setLayoutX(241);
		sequential.setLayoutY(59);
		pane.getChildren().add(label);
		label.setLayoutX(30);
		label.setLayoutY(23);
		
		
		
		
		HBox rowLts = new HBox();
		rowLts.setAlignment(Pos.CENTER);
		letters = rowLts.getChildren();
		
		
		playable.bind(hangman.livesLeft.greaterThan(0).and(lettersLeft.greaterThan(0)));
		playable.addListener((obs, old, newValue) -> {
			if (!newValue.booleanValue())
				finish();
		});
		
		Button easy = new Button("Easy");
		easy.disableProperty().bind(playable);
		easy.setOnAction(event -> start());
		
		
		Button medium = new Button("Medium");
		medium.disableProperty().bind(playable);
		medium.setOnAction(event -> start2());
		
		Button hard = new Button("Hard");
		hard.disableProperty().bind(playable);
		hard.setOnAction(event -> start3());
		
		Button advanced = new Button("Advanced");
		advanced.disableProperty().bind(playable);
		advanced.setOnAction(event -> start4());
		
		
		
		Button saveGame = new Button("Save Game");
		saveGame.setOnAction(event -> {
			saveData data = new saveData();
			data.word = wordBeingGuessed;
			//data.lettersToGuess = lettersLeft;
			//data.letters = letters;
			
		try{
			resourcesManager.save(data,"1.save");
		}
		catch (Exception e){
			System.out.println("Couldn't save: " + e.getMessage());
		}
		});
		
		Button loadGame = new Button("Load Game");
		loadGame.setOnAction(event -> {
			try{
				saveData data = (saveData) resourcesManager.load("1.save");
				wordBeingGuessed = data.word;
			//	lettersLeft = data.lettersToGuess;
				//letters = data.letters;
				
				
			}
			catch (Exception e){
				System.out.println("Couldn't load save data: " + e.getMessage());
			}
		});
		
		
		//layout
		HBox r1 = new HBox();
		HBox r3 = new HBox();
	    r1.setAlignment(Pos.CENTER);
		r3.setAlignment(Pos.CENTER);
		for( int i = 0; i<20; i++){
			r1.getChildren().add(new Letter(' '));
			r3.getChildren().add(new Letter(' '));
		}
		
		HBox rowA = new HBox(5);
		rowA.setAlignment(Pos.CENTER);
		for(char c = 'A'; c <= 'Z'; c++){
			Text t = new Text(String.valueOf(c));
			t.setFont(defaultF);
			alphabet.put(c, t);
			rowA.getChildren().add(t);
		}
		
		HBox rowH = new HBox(10, easy, medium, hard, advanced, hangman);
		rowH.setAlignment(Pos.CENTER);
		
		HBox rowS = new HBox(saveGame, loadGame);
		rowS.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox(10);
		//vertical layout
		vBox.getChildren().addAll(r1,rowLts,r3,rowA,rowH, rowS);
		return vBox;
		}
		
		
	
	
	public Parent createContent2(){

		RadioButton para = new RadioButton();
		RadioButton sequential = new RadioButton();
		Label label = new Label("Please choose which mode you wish to choose words from");
		
		para.setText("Parallel");
		sequential.setText("Sequential");
		
		
		Pane pane = new Pane();
		pane.setPrefHeight(154);
		pane.setPrefWidth(437);
		pane.getChildren().add(para);
		para.setLayoutX(95);
		para.setLayoutY(59);
		pane.getChildren().add(sequential);
		sequential.setLayoutX(241);
		sequential.setLayoutY(59);
		pane.getChildren().add(label);
		label.setLayoutX(30);
		label.setLayoutY(23);
	
				
		
		
		
		return pane;
	}
	
	
	
	
	
	
	private void finish(){
		for (Node n : letters){
			Letter letter = (Letter) n;
			letter.show();
		}
	}
	
		
	private void start(){
		for (Text t : alphabet.values()){
			t.setStrikethrough(false);
			t.setFill(Color.BLACK);
		}
		
		hangman.reset();
		wordBeingGuessed.set(readTxt.parralel());
		System.out.println(wordBeingGuessed);
		lettersLeft.set(wordBeingGuessed.length().get());
		
		letters.clear();
	        for (char c : wordBeingGuessed.get().toCharArray()) {
	            letters.add(new Letter(c));
	            }
	}
	
	private void start2(){
		for (Text t : alphabet.values()){
			t.setStrikethrough(false);
			t.setFill(Color.BLACK);
		}
		
		hangman.reset();
		wordBeingGuessed.set(readTxt2.getRandomWord());
		System.out.println(wordBeingGuessed);
		lettersLeft.set(wordBeingGuessed.length().get());
		
		letters.clear();
	        for (char c : wordBeingGuessed.get().toCharArray()) {
	            letters.add(new Letter(c));
	            }
	}
	
	private void start3(){
		for (Text t : alphabet.values()){
			t.setStrikethrough(false);
			t.setFill(Color.BLACK);
		}
		
		hangman.reset();
		wordBeingGuessed.set(readTxt3.getRandomWord());
		System.out.println(wordBeingGuessed);
		lettersLeft.set(wordBeingGuessed.length().get());
		
		letters.clear();
	        for (char c : wordBeingGuessed.get().toCharArray()) {
	            letters.add(new Letter(c));
	            }
	}
	
	private void start4(){

		for (Text t : alphabet.values()){
			t.setStrikethrough(false);
			t.setFill(Color.BLACK);
		}
		
		hangman.reset();
		wordBeingGuessed.set(readTxt4.getRandomWord());
		System.out.println(wordBeingGuessed);
		lettersLeft.set(wordBeingGuessed.length().get());
		
		letters.clear();
	        for (char c : wordBeingGuessed.get().toCharArray()) {
	            letters.add(new Letter(c));
	            }
	}
	
	private static class HangmanImage extends Parent{
		private static final int startX = 100;
		private static final int startY = 20;
		private static final int endX = startX;
		private static final int endY = startY + 50;
	
	
	private SimpleIntegerProperty livesLeft = new SimpleIntegerProperty();
	
	public HangmanImage(){
		Circle head = new Circle(20);
		head.setTranslateX(startX);
		
		Line base = new Line();
		base.setStartX(startX);
		base.setStartY(startY);
		base.setEndX(endX);
		base.setEndY(endY);
		
		Line armLeft = new Line();
		armLeft.setStartX(startX);
		armLeft.setStartY(startY);
		armLeft.setEndX(startX + 40);
		armLeft.setEndY(startY + 10);
		
		Line armRight = new Line();
		armRight.setStartX(startX);
		armRight.setStartY(startY);
		armRight.setEndX(startX - 40);
		armRight.setEndY(startY + 10);
		
		Line legLeft = new Line();
		legLeft.setStartX(endX);
		legLeft.setStartY(endY);
		legLeft.setEndX(endX + 25);
		legLeft.setEndY(endY + 50);
		
		Line legRight = new Line();
		legRight.setStartX(endX);
		legRight.setStartY(endY);
		legRight.setEndX(endX - 25);
		legRight.setEndY(endY + 50);
		
		getChildren().addAll(head, base, armLeft, armRight, legLeft, legRight);
		livesLeft.set(getChildren().size());
		
		
	}
	
	
	public void reset(){
		getChildren().forEach(node -> node.setVisible(false));
		livesLeft.set(getChildren().size());
	}
	
	public void minusLife(){
		for(Node n : getChildren()){
			if (!n.isVisible()){
				n.setVisible(true);
				livesLeft.set(livesLeft.get() - 1);
				break;
			}
		}
		
	}
	}
	
	private static class Letter extends StackPane{
		private Rectangle Rc = new Rectangle(40, 60);
		private Text text;
		
		public Letter(char letter){
			Rc.setFill(letter == ' ' ? Color.BEIGE : Color.WHITE);
			Rc.setStroke(Color.RED);
			
			text = new Text(String.valueOf(letter).toUpperCase());
			text.setFont(defaultF);
			text.setVisible(false);
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(Rc, text);
		}
		
		public void show(){
			RotateTransition rotate = new RotateTransition(Duration.seconds(1), Rc);
			rotate.setAxis(Rotate.Y_AXIS);
			rotate.setToAngle(180);
			rotate.setOnFinished(event -> text.setVisible(true));
			rotate.play();		
		}
		
		public boolean equalTo(char other){
			return text.getText().equals(String.valueOf(other).toUpperCase());
		}
		
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Scene scene = new Scene(createContent());
		RadioButton para = new RadioButton();
		RadioButton sequential = new RadioButton();
		Label label = new Label("Please choose which mode you wish to choose words from");
		
		para.setText("Parallel");
		sequential.setText("Sequential");
		
		
		Pane pane = new Pane();
		pane.setPrefHeight(154);
		pane.setPrefWidth(437);
		pane.getChildren().add(para);
		para.setLayoutX(95);
		para.setLayoutY(59);
		pane.getChildren().add(sequential);
		sequential.setLayoutX(241);
		sequential.setLayoutY(59);
		pane.getChildren().add(label);
		label.setLayoutX(30);
		label.setLayoutY(23);
		Scene scene1 = new Scene(pane, 154, 437);
		
		para.setOnAction(event -> primaryStage.setScene(scene));
		sequential.setOnAction(event -> primaryStage.setScene(scene));
			
		
		
	
	
		
	scene.setOnKeyPressed((KeyEvent event) -> {
		if (event.getText().isEmpty())
			return;
	
	char pressed = event.getText().toUpperCase().charAt(0);
	if((pressed < 'A' || pressed > 'Z') && pressed != '-')
		return;
	
	if(playable.get()) {
		Text t = alphabet.get(pressed);
		if(t.isStrikethrough())
			return;
		
		t.setFill(Color.BLUE);
		t.setStrikethrough(true);
		
		boolean found = false;
		
		
		for (Node n : letters){
			Letter letter = (Letter) n;
			if (letter.equalTo(pressed)){
				found = true;
				lettersLeft.set(lettersLeft.get() - 1);
				letter.show();
				
			}
		}
		
		if (!found){
			hangman.minusLife();
		}
	}
});
	
	primaryStage.setResizable(false);
	primaryStage.setWidth(hangW);
	primaryStage.setHeight(hangH);
	primaryStage.setTitle("Hangman");
	primaryStage.setScene(scene1);
	primaryStage.show();
	//start();
	
	

	}

	public static void main(String[] args){
		launch(args);
		
	}
	
	
	
}
	