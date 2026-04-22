package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.abstractComponents;

public class ProductCatalog extends abstractComponents {
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	By Productsby=By.cssSelector(".mb-3");
	By SelectProduct=By.cssSelector(".card-body button:last-of-type");
	By ToastMessage=By.cssSelector("#toast-container");
	By Spinner=By.cssSelector("#ng-animating");
	
	public List<WebElement> GetProducts() {
		
		waitForElementToAppear(Productsby);
		return Products;
		
	}
	public WebElement GetProductByProductName(String Productname)
	{
		WebElement Product = GetProducts().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname)).findFirst().orElse(null);
		return Product;
   
    }
	public void AddProductToCart(String Productname) {
		
		WebElement Product = GetProductByProductName(Productname);
		Product.findElement(SelectProduct).click();
		waitForElementToAppear(ToastMessage);
		waitForElementToDisAppear(Spinner);
		
		
		
		
		
		
		
		
	}
}