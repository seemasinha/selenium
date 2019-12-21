package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	
 public WebDriver driver;
 By signIn=By.cssSelector("a[href*='sign_in']");
 By title=By.cssSelector("[id='content'] div div h2");
 By navigationbar=By.cssSelector(".nav.navbar-nav.navbar-right");
 
 By subbutton=By.xpath("//button[contains(text(),'NO THANKS')]");
 
 
 public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 this.driver=driver;
}

public WebElement getLogin() {
	 return driver.findElement(signIn);
	 
 }
public WebElement getTitle() {
	 return driver.findElement(title);
	 
}
public WebElement CheckNavigationBar() {
	 return driver.findElement(navigationbar);
	 
}
public WebElement getSubButton() {
	 return driver.findElement(subbutton);
	 
}
 
}
