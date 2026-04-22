package rahulshettyacademy.abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class abstractComponents {
	
	 WebDriver driver;
	public abstractComponents(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement CartHeader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrderHeader;

	public void waitForElementToAppear(By findby) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
		
	}
public void waitForWebElementToAppear(WebElement findby) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
		
		
	}

public void waitForElementToDisAppear(By findby) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
		
		
	}

public CartPage GoToCartPage() {
	  
	CartHeader.click();
	CartPage cartpage=new CartPage(driver);
	return cartpage;
	
}
public OrderPage GoToOrdersPage() {
	  
	OrderHeader.click();
	OrderPage orderpage=new OrderPage(driver);
	return orderpage;
	
}
}
