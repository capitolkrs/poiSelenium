
package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://www.google.com");
		GoogleHomePageObjects page=new GoogleHomePageObjects(driver);
		page.txtSearch.sendKeys("Selenium");
		page.btnSearch.click();
	}

}
