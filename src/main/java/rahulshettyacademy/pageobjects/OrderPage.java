package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.abstractComponents.abstractComponents;

public class OrderPage extends abstractComponents {
	
	WebDriver driver;
	public OrderPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductNames;
	
	@FindBy(css=".totalRow button")
	WebElement CheckoutElement;
	
	
public Boolean  VerifyOrderDisplay(String Productname) {
		
		
	boolean match = ProductNames.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
	return match;
	
		
	}

	
}