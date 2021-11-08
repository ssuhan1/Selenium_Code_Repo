package ffm.automation.aprilqe;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FFMLoginTest {
	
	WebDriver driver;
	String baseURL= "https://ffm-v2.techserve4u.com/";
	LoginPOM loginPOM;
	
	
 
  @BeforeClass
  public void beforeClass() {
	  //Initialize the driver
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(baseURL);
  }
  
  
  @Test
  public void f() {
	  loginPOM= new LoginPOM(driver);
	  loginPOM.loginFFM("ecom@example.com", "string");
	  loginPOM.validateLogin();
  }
  
  
  

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
