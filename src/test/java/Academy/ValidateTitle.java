package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{//inherit base class properties
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void startUp() throws IOException {
		driver=initializeDriver();
		//driver.get("http://www.qaclickacademy.com");
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		
		
		//creating object of the class to access methods
		LandingPage l=new LandingPage(driver);
		//compare the text with actual text
	    Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
	    log.info("Successfully validated Title");
	    	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
	

}
