package planet.detail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.util.Scanner;

import app.PlanetModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlanetController {
	
	ObservableList<String> selectImageList = FXCollections.observableArrayList("");
	ObservableList<String> loadPlanetList = FXCollections.observableArrayList("");
	public boolean popUpAnswer;
	@FXML
	private ChoiceBox<String> selectImageBox;
	
	@FXML
	private ChoiceBox<String> loadPlanetBox;

    @FXML
    private ImageView planetImage;

    @FXML
    private Button selectImageButton;

    @FXML
    private TextField planetName;

    @FXML
    private TextField planetDiameterKM;
    
    @FXML
    private TextField planetDiameterM;

    @FXML
    private TextField planetMeanSurfaceTempC;

    @FXML
    private TextField planetMeanSurfaceTempF;

    @FXML
    private TextField planetNumberOfMoons;

    @FXML
    private Label fancyPlanetName;
    private Format fmt;
    
    @FXML
    void selectImage(ActionEvent event) {
    	String choice=selectImageBox.getSelectionModel().getSelectedItem();
    	String imagePath="images\\"+choice;
    	File ip=new File(imagePath);
    	Image image = new Image(ip.toURI().toString());
    	//System.out.println(imagePath);
    	planetImage.setImage(image);
    }

    @FXML
    void loadPlanet(ActionEvent event) throws Exception {
    	String selectedChoice = loadPlanetBox.getSelectionModel().getSelectedItem();
    	LoadPlanetPopUpController popUp = new LoadPlanetPopUpController();
    	
		//popUpAnswer = popUp.show();

    	if(popUpAnswer = true) {
    		readPlanetFile(selectedChoice);
    	}
    }
    
    @FXML
    private void initialize() {
    	selectImageList.clear();
    	loadImageList();
    	selectImageBox.setItems(selectImageList);
    	loadPlanetList.clear();
    	loadPlanetList();
    	loadPlanetBox.setItems(loadPlanetList);
    }
    
    
	@FXML
    void savePlanet(ActionEvent event) throws IOException {
    	try{
    		PlanetModel planet = new PlanetModel();
    		if(planet.validatePlanetName(planetName.getText())){
    			planet.storeInput(planetName.getText(),"planetName");
    		}
    		if(planet.validateDiameter(planetDiameterKM.getText())) {
    			planet.storeInput(planetDiameterKM.getText(),"diameterKm");
    		}
    		if(planet.validateTemperature(planetMeanSurfaceTempC.getText())) {
    			planet.storeInput(planetMeanSurfaceTempC.getText(),"surfaceTempC");
    		}
    		if(planet.validateMoons(planetNumberOfMoons.getText())) {
    			planet.storeInput(planetNumberOfMoons.getText(),"numberMoons");
    		}
        	
        	
        	String selectedChoice = selectImageBox.getSelectionModel().getSelectedItem();
        	planet.storeInput(selectedChoice,"imageFileName");
        	planet.createFile(planetName.getText());
        	initialize();
    	} catch (Exception e){
    		System.out.println(e);
    	}
    	
    }
	@FXML
    void convertCtoF() {
		System.out.println("converting from c to f");
		double temp=Double.parseDouble(planetMeanSurfaceTempC.getText());
		temp=temp*(9.0/5.0)+32;
		String t=""+temp;
		planetMeanSurfaceTempF.setText(t);

    }
	@FXML
	void convertKilometersToMiles() {
		System.out.println("converting from km to mi");
		double miles=Double.parseDouble(planetDiameterKM.getText());
		miles=miles/1.6;
		String m=""+miles;
		planetDiameterM.setText(m);
	}
    void loadImageList() {
    	File imageFolder = new File("images\\");
    	File[] listOfFiles = imageFolder.listFiles();
    	for(File file: listOfFiles) {
        	selectImageList.add(file.getName());
    	}
    }
    void loadPlanetList() {
    	File imageFolder = new File("planets\\");
    	File[] listOfFiles = imageFolder.listFiles();
    	for(File file: listOfFiles) {
        	loadPlanetList.add(file.getName());
    	}
    }
    boolean checkForEmptyTextFields() {
    	if(planetName.getText().isEmpty() && planetNumberOfMoons.getText().isEmpty() && planetMeanSurfaceTempC.getText().isEmpty() && planetDiameterKM.getText().isEmpty()) {
    		
    	}
    	return false;
    }
    void readPlanetFile(String fileName) throws IOException {
    	
    	Path filePath = Paths.get("planets\\" + fileName);
    	Scanner scanner = new Scanner(filePath).useDelimiter(",");
    	while(scanner.hasNext()) {
    		planetName.setText(scanner.next());
    		planetDiameterKM.setText(scanner.next());
    		planetDiameterM.setText(scanner.next());
    		planetMeanSurfaceTempC.setText(scanner.next());
    		planetMeanSurfaceTempF.setText(scanner.next());
    		planetNumberOfMoons.setText(scanner.next());
            File file = new File("images\\" + scanner.next());
            Image image = new Image(file.toURI().toString());
            planetImage.setImage(image);
    	}
    	fancyPlanetName.setText(planetName.getText());
    }
    
    
}