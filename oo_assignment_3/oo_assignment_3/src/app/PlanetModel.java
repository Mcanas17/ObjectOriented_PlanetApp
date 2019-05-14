package app;

import java.io.IOException;
import java.io.Serializable;

import planet.detail.PlanetInputDelegate;

public class PlanetModel implements Serializable {
	public static String planetName;
	public static String planetImageFile;
	public static double diameterKm;
	public static double diameterM;
	public static double surfaceTempC;
	public static double surfaceTempF;
	public static int numMoons;
	String chars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 -.";

	public void storeInput(String input, String inputType) {
			PlanetInputDelegate.storeInput(input,inputType,this);
	}
	
	public boolean validatePlanetName(String name) {
		System.out.println("attempting to validate planet name");
		if(name.length()==0) return false;
		for(int i=0;i<name.length();i++) {
			if(chars.indexOf(name.charAt(i))==-1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validateDiameter(String diameter) {
		double diam=Double.parseDouble(diameter);
		return(diam>0 && diam < 200000.0);
	}
	
	public boolean validateTemperature(String temperature) {
		double temp=Double.parseDouble(temperature);
		return (temp>-273.15 && temp < 500.0);
	}
	
	public boolean validateMoons(String moons) {
		int m=Integer.parseInt(moons);
		return (m>=0 && m <=1000);
	}
	
	public void createFile(String fileName) throws IOException {
		PlanetInputDelegate.createFile(fileName,this);
	}
	
	public void loadPlanet() {
		
	}

	
	// Accessors
	public static String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		PlanetModel.planetName = planetName;
	}

	public String getPlanetImageFile() {
		return planetImageFile;
	}

	public void setPlanetImageFile(String planetImageFile) {
		PlanetModel.planetImageFile = planetImageFile;
	}

	public double getDiameterKm() {
		return diameterKm;
	}

	public void setDiameterKm(Double diameterKm) {
		PlanetModel.diameterKm = diameterKm;
	}

	public double getDiameterM() {
		return diameterM;
	}

	public void setDiameterM(Double diameterM) {
		PlanetModel.diameterM = diameterM;
	}

	public double getSurfaceTempC() {
		return surfaceTempC;
	}

	public void setSurfaceTempC(Double surfaceTempC) {
		PlanetModel.surfaceTempC = surfaceTempC;
	}

	public double getSurfaceTempF() {
		return surfaceTempF;
	}

	public void setSurfaceTempF(Double surfaceTempF) {
		PlanetModel.surfaceTempF = surfaceTempF;
	}

	public int getNumMoons() {
		return numMoons;
	}

	public void setNumMoons(int numMoons) {
		PlanetModel.numMoons = numMoons;
	}
	
	
}
