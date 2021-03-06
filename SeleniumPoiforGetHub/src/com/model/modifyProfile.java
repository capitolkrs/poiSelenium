package com.model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class modifyProfile {
	
	WebDriver driver=new FirefoxDriver();
	@Test(dataProvider="userInfo")
	public void changeProfile(String myName,String mypasswd){
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://wordpress.com/");
		driver.findElement(By.className("click-wpcom-login")).click();
		driver.findElement(By.id("user_login" )).clear();
		driver.findElement(By.id("user_login" )).sendKeys(myName);
		driver.findElement(By.id("user_pass" )).clear();
		driver.findElement(By.id("user_pass" )).sendKeys(mypasswd);
		driver.findElement(By.id("wp-submit" )).click();
		driver.close();
		
		
	}
	
	
	
	
	
	
	
	@DataProvider(name="userInfo")
	public Object [][] dataPasser(){
		StructureExcel myConfig=new StructureExcel("/Users/capiwega/gitHubRepo/PoiSelenium/SeleniumPoiforGetHub/testData/inputData.xlsx");
		int myRowCount=myConfig.myRowcnt(0);
		Object [][] dataGetter=new Object[myRowCount][2];//creating an instance of an array object 
														//to hold the excel values temporarily 
		for (int i=0;i<myRowCount;i++){
			dataGetter[i][0]=myConfig.fetchData(0, i, 0);
			dataGetter[i][1]=myConfig.fetchData(0, i, 1);
			
		}
		return dataGetter;
		
		
	}

}
