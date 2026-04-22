package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.abstractComponents;

public class Confirmationpage extends abstractComponents {
    WebDriver driver; 
	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement ConfirmationMessage;
	
	public String GetConfirmationMessage() {
	   return ConfirmationMessage.getText();
		
	}
}
