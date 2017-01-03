package readingFromFile;



 import readingFromFile.readTxt;
 import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.*;


public class GUI extends Application implements EventHandler<ActionEvent>{
	
	RadioButton para = new RadioButton();
	RadioButton sequential = new RadioButton();
	Button submit = new Button();
	Label label = new Label("Please choose which mode you wish to choose words from");
	
	
	
	private Parent createContent(){
		para.setText("Parallel");
		sequential.setText("Sequential");
		submit.setText("submit");
	 
		
		Pane pane = new Pane();
		pane.setPrefHeight(154);
		pane.setPrefWidth(437);
		pane.getChildren().add(para);
		para.setLayoutX(95);
		para.setLayoutY(59);
		pane.getChildren().add(sequential);
		sequential.setLayoutX(241);
		sequential.setLayoutY(59);
		pane.getChildren().add(submit);
		submit.setLayoutX(174);
		submit.setLayoutY(96);
		pane.getChildren().add(label);
		label.setLayoutX(30);
		label.setLayoutY(23);
		
	
		
		Scene scene = new Scene(pane, 437, 154);
		
		para.setOnAction(event -> {
			try{
				hangman hangman = new 
			}
			
			
			
			
			
			
		})
		
		
		
	


	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Hangman word chooser");
		primaryStage.show();
		
		
		
	}

	@Override
	public void handle(ActionEvent event) {		
	    	
	    }
	

	
public static void main(String[]args){
	
	launch(args);	
	
	
}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}