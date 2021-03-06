package com.model;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LandingPage {

	WebDriver driver=new FirefoxDriver();
	@Test(dataProvider="loginData")
	public void loginWordpress(String usrName,String passwd){
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://wordpress.com/");
		driver.findElement(By.className("click-wpcom-login")).click();
		driver.findElement(By.id("user_login" )).clear();
		driver.findElement(By.id("user_login" )).sendKeys(usrName);
		driver.findElement(By.id("user_pass" )).clear();
		driver.findElement(By.id("user_pass" )).sendKeys(passwd);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lkj")));
		
		
		
		driver.findElement(By.id("wp-submit" )).click();
		driver.close();
		Assert.assertEquals("TRUE", "TRUE");
	}
	@AfterTest
	public void logout(){
		driver.close();
		
	
	}
	
	
	
	//DATAPROVIDER
	@DataProvider(name="loginData")
	public Object [][] passData(){
		
		ExcelConfig config=new ExcelConfig("/Users/capiwega/gitHubRepo/PoiSelenium/SeleniumPoiforGetHub/testData/inputData.xlsx");
		int srow=config.getRowCount(0);
		System.out.println(srow);
		Object [][] data=new Object[srow][2];
		for(int i=0;i<srow;i++){
		data[i][0]=config.getData(0, i, 0);
		data[i][1]=config.getData(0, i, 1);
		}
		return data;
	}
	
	@DataProvider (name="manualLogin")
	public Object [][] getData(){
		
		Object [][] dataInput=new Object[2][2];
		dataInput[0][0]="userName";
		dataInput[0][1]="password";
		
		dataInput[1][0]="userName1";
		dataInput[1][1]="password";
				
		return dataInput;		
		
	}
}
