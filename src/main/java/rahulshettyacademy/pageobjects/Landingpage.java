package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.abstractComponents;

public class Landingpage extends abstractComponents {
	
	WebDriver driver;
	public Landingpage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	

	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css="[class*='flyInOut'")
	WebElement ErrorMessage;

    public ProductCatalog loginapplication(String email , String Password) {
    	
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(Password);
    	Submit.click();
    	
    	return new ProductCatalog(driver);
    	
    }
    
    public String ErrorMessage() {
    	waitForWebElementToAppear(ErrorMessage);
    	return ErrorMessage.getText();
    	
    }
    public void Goto()
    {
    	driver.get("https://rahulshettyacademy.com/client"); 
    }
	
    }