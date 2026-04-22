package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.abstractComponents.abstractComponents;

public class CartPage extends abstractComponents {
	
	WebDriver driver;
	public CartPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> CartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement CheckoutElement;
	
	
public Boolean  VerifyProductDisplay(String Productname) {
		
		
	boolean match = CartProduct.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
	return match;
	
		
	}
public checkoutpage Checkout() {
	CheckoutElement.click();
	return new checkoutpage(driver);
}

	
}