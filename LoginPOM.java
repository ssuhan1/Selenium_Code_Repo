package ffm.automation.aprilqe;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	
	WebDriver driver;
	
	
	//Inspect the email field
	@FindBy(id="basic_email")
	WebElement emailField;
	
	//Inspect the password field
	@FindBy(id="basic_password")
	WebElement passField;
	
	//Inspect the login button
	@FindBy(xpath="//*[@id=\"basic\"]/div[3]/button/span")
	WebElement loginBtn;
	
	//Inspect the FFM platform text
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div/div[1]/div")
	WebElement ffmplatformText;
	
	//Initialize the objects
	public LoginPOM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Login actions
	public void loginFFM(String email, String password) {
		emailField.sendKeys(email);
		passField.sendKeys(password);
		loginBtn.click();
	}
	
	//Assertion
	public void validateLogin() {
		String expectedText= ffmplatformText.getText();
		Assert.assertEquals(expectedText, "FFM platform");
	}

}
