package planet.detail;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoadPlanetPopUpController{
	static boolean answer;
	
	@FXML
	private Button yesButton = new Button();
	
	@FXML
	private Button noButton = new Button();
	
	@FXML 
	void yesButton(ActionEvent event) {
		answer = true;
	}
	
	@FXML
	void noButton(ActionEvent event) {
		answer = false;
	}
	
	public boolean show() throws Exception {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("loadPlanetPopUp.fxml"));
		loader.setController(this);
		
		Pane pane = (Pane) loader.load();

		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		yesButton.setOnAction(e->{
				//answer = true;
				primaryStage.close();
		});
		noButton.setOnAction(e-> {
			//answer = false;
			primaryStage.close();
		});
		return answer;
	}
	public boolean getAnswer(){
		return answer;
	}
	
}
