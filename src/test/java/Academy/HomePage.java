package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{//inherit base class properties
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void startUp() throws IOException {
		driver=initializeDriver();
		//driver.get("http://www.qaclickacademy.com");
		
		
		
	}
	
	@Test(dataProvider="getData")
	
	public void basePageLogin(String username,String password,String text) throws IOException, InterruptedException {
		
		//driver.get("http://www.qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		//creating object of the class to access methods
		LandingPage l=new LandingPage(driver);
		
		
		l.getLogin().click();//same as driver.getelementby(by.xpath='')
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		log.info("Login test "+text);
		lp.getlogin().click();
		
		
	}
	@DataProvider
	public Object[][] getData() {
		//row stands for how many different sets of data to be used
		Object[][] data =new Object[2][3];//Size of array
		//0 th row
		data[0][0]="non-restricted@user";
		data[0][1]="nrpassword";
		data[0][2]="NR";
		//1st row
		data[1][0]="restricted@user";
		data[1][1]="rpassword";
		data[1][2]="R"	;
		return data;
			
	}
	@AfterTest
   public void cleanUp() {
		driver.close();
		driver=null;
		
	}
	

}
