package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	          public WebDriver driver;
             public Properties prop;
    
	public   WebDriver initializeDriver() throws IOException {
		//Properties prop=new Properties();
		prop=new Properties();
		FileInputStream fis=new FileInputStream ("/Users/sinhapra/E2EProject/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		
		if( browserName.equals("chrome")) {//compare proprties use equals instead of ==
			//initialize chrome browser
			System.setProperty("webdriver.chrome.driver","/Users/sinhapra/Downloads/chromedriver");
			driver= new ChromeDriver();
			
		}
		
		else if( browserName=="firefox") {
			//initialize firefox browser
			
		}
		else if( browserName=="IE") {
			//initialize internet explorer browser
			
		}
		//wait 10 second for page to load before failing script
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;//return driver
		
			
	}

}
