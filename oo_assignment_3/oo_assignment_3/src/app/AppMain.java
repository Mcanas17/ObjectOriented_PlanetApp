package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import planet.detail.PlanetController;

public class AppMain extends Application {
	public AppMain() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("test");
		
	}
	
	//FXML startup method
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		PlanetController controller = new PlanetController();

		FXMLLoader loader = new FXMLLoader(controller.getClass().getResource("PlanetView.fxml"));
		loader.setController(controller);
		
		Pane pane = (Pane) loader.load();

		Scene scene = new Scene(pane, 650, 450);
		primaryStage.setTitle("CS 4773 Assignment 3 by DM/MC");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}