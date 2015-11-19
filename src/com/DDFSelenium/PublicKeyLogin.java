package com.DDFSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PublicKeyLogin {
 
	WebDriver driver;
	
	@Test(dataProvider="keyLogin")
	public void loginKey(String uName, String Pwd){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http//www.gmail.com);
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		@DataProvider(name="loginKey")
		Public Object
	}
	
}
