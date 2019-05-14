package app;
import java.io.IOException;

import org.junit.Ignore;

import java.io.File;

import junit.framework.*;

public class TestCases extends TestCase {
	
	PlanetModel testPlanet=new PlanetModel();
	
	public void testPlanetName() {
		assertEquals("Testing planet name validation 1",testPlanet.validatePlanetName("bananas"),true);
		assertEquals("Testing planet name validation 2",testPlanet.validatePlanetName("asdfasdf- ."),true);
		assertEquals("Testing planet name validation 3",testPlanet.validatePlanetName("asdfas%f- ."),false);
	}
	
	
	public void testPlanetDiameter() {
		double diam=-94;
		assertEquals("Testing diameter validation 1",testPlanet.validateDiameter(""+diam),false);
		diam=1;
		assertEquals("Testing diameter validation 2",testPlanet.validateDiameter(""+diam),true);
		diam=220893422;
		assertEquals("Testing diameter validation 3",testPlanet.validateDiameter(""+diam),false);
		diam=193000;
		assertEquals("Testing diameter validation 3",testPlanet.validateDiameter(""+diam),true);
	}
	
	public void testMoons() {
		int moons=0;
		assertEquals("Testing moon validation",testPlanet.validateMoons(""+moons),true);
		moons=1001;
		assertEquals("Testing moon validation",testPlanet.validateMoons(""+moons),false);
		moons=-10;
		assertEquals("Testing moon validation",testPlanet.validateMoons(""+moons),false);
		moons=40;
		assertEquals("Testing moon validation",testPlanet.validateMoons(""+moons),true);
		
	}
	
	public void testPlanetTemperature() {
		double temp=30;
		assertEquals("Testing temp validation",testPlanet.validateTemperature(""+temp),true);
		temp=-500;
		assertEquals("Testing temp validation",testPlanet.validateTemperature(""+temp),false);
		temp=10000;
		assertEquals("Testing temp validation",testPlanet.validateTemperature(""+temp),false);
	}
	
	public void testSave() {
		try{
			testPlanet.createFile("Test Planet");
		} catch (IOException e){
				System.out.println(e);
		}
		boolean success1=false;
		boolean success2=false;
		File imageFolder = new File("planets\\");
    	File[] listOfFiles = imageFolder.listFiles();
    	for(File file: listOfFiles) {
        	if(file.getName().equals("Test Planet.txt"))
        		success1=true;
        	if(file.getName().equals("potatoes.txt"))
        		success2=true;
    	}
    	
    	assertEquals("testing file creation",success1,true);
    	assertEquals("testing file creation",success2,false);
	}

}
