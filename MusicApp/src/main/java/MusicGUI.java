//created by Zohar Sajith and Jae Kim
//Started May 9th, 2020

package main.java;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MusicGUI extends Application{

	
	public static void main(String[] args) {	
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Text fields for displaying information
		Text intro = new Text("Welcome to MusicApp");
		Text info = new Text("Info goes here\n test");
		intro.setFont(Font.font("Corbel", FontWeight.BOLD, FontPosture.REGULAR, 20));
		info.setFont(Font.font("Corbel",  FontPosture.REGULAR, 16));
		
		//Create buttons to press for commands
		Button Spotify = new Button("Transfer Music to Spotify");
		Spotify.setFont(Font.font("Corbel", FontWeight.BOLD, FontPosture.REGULAR, 12));
		Spotify.setPrefHeight(30);
		
		Button Tidal = new Button("Transfer Music to Tidal");
		Tidal.setFont(Font.font("Corbel", FontWeight.BOLD, FontPosture.REGULAR, 12));
		Tidal.setPrefHeight(30);
		
		Button exit = new Button("Exit");
		exit.setFont(Font.font("Corbel", FontWeight.BOLD, FontPosture.REGULAR, 12));
		exit.setPrefHeight(30);
		
		
		
		//create container for buttons
		HBox buttonBox = new HBox(Spotify, Tidal, exit);
		buttonBox.setSpacing(50);
		
		//create container for texts
		VBox introBox = new VBox(intro);
		VBox infoBox = new VBox(info);
		VBox textCombined = new VBox(introBox, infoBox);
		
		//create BorderPane to hold all assets
		BorderPane pane = new BorderPane();
		pane.setTop(textCombined);
		pane.setBottom(buttonBox);
		pane.setPadding((new Insets(30)));
		
		//add css
		pane.setStyle("-fx-background-color: WHITE");
		infoBox.setStyle("-fx-border-color: rgb(189, 189, 189)");		
		
		//set up listeners to handle button inputs
		Spotify.setOnAction(e->{
			//execute python script to transfer songs from spotify to tidal
			try {
				PythonInterpreter inter = new PythonInterpreter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Tidal.setOnAction(e->{
			//execute python script to transfer songs from spotify to tidal
		});
		
		exit.setOnAction(e-> {
			primaryStage.close();
		});
		
		primaryStage.setTitle("Music Transfer");
		Scene scene = new Scene(pane, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
}
