import org.openqa.selenium.WebDriver;


public class MyFirstTest {
@test
public void tester(){
	System.out.println("test import");
	WebDriver driver=new firefoxDriver();
	driver.get("http//www.google.com");
	
}
}
