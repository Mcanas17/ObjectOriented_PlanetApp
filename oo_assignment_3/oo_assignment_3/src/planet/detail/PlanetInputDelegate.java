package planet.detail;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import app.PlanetModel;
import javafx.scene.control.TextField;

public class PlanetInputDelegate{
	
	public static void storeInput(String input,String inputType, PlanetModel planet) {
		if(inputType.equals("planetName")) {
			planet.setPlanetName(input);
		}
		else if(inputType.equals("diameterKm")) {
			planet.setDiameterKm(Double.parseDouble(input));
			planet.setDiameterM(Double.parseDouble(input)*1000);
		}
		else if(inputType.equals("surfaceTempC")) {
			planet.setSurfaceTempC(Double.parseDouble(input));
			planet.setSurfaceTempF(Double.parseDouble((input))*(1.8)+32);
		}
		else if(inputType.equals("numberMoons")) {
			planet.setNumMoons(Integer.parseInt(input));
		}
		else if(inputType.equals("imageFileName")) {
			planet.setPlanetImageFile(input);
		}
		else {
			System.err.println("storeInput Error");
		}
	}

	public static void createFile(String name,PlanetModel planet) throws IOException {
		String path = "planets\\" + name + ".txt";

		File file = new File(path);

		file.getParentFile().mkdirs(); 
		file.createNewFile();
		
		String text = planet.getPlanetName() + "," + planet.getDiameterKm() + "," + planet.getDiameterM() +
					"," + planet.getSurfaceTempC() + "," + planet.getSurfaceTempF() + ","+ planet.getNumMoons() + "," + planet.getPlanetImageFile();
		Files.write(Paths.get(path), text.getBytes());
	}
}
