package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractComponents.abstractComponents;

public class checkoutpage extends abstractComponents {

	WebDriver driver;
	public checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement Submit;

	By Selector=By.cssSelector(".ta-results");


public void SelectCountry(String CountrySelection) {
	Actions action =new Actions(driver);
	
	action.sendKeys(Country,CountrySelection).build().perform();
	
	waitForElementToAppear(Selector);
	
	SelectCountry.click();
	
	
}
public Confirmationpage SubmitOrder() {
	Submit.click();
	return new Confirmationpage(driver);
	
}
}
