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

public class ValidateNavBar extends base{//inherit base class properties
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void startUp() throws IOException {
		driver=initializeDriver();
		//driver.get("http://www.qaclickacademy.com");
		
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	
	public void basePageNavigation() throws IOException {
		LandingPage l=new LandingPage(driver);//creating object of the class to access methods
		
	  //check navigation bar is present
	    Assert.assertTrue(l.CheckNavigationBar().isDisplayed());
	    log.info("Displayed");
	    	
		
		
	}
	@AfterTest
	public void cleanUp() {
		
		driver.close();
		driver.quit();
	}

}
