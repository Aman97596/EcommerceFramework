package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.Confirmationpage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.pageobjects.checkoutpage;

public class StandalonetestUpdated extends BaseTest {
	String Productname = "ZARA COAT 3";
	@Test
	public void SubmitOrder() throws IOException
	{
		
		ProductCatalog productcatalog=landingpage.loginapplication("amanmunjal1990@gmail.com","Aman.12345");
		List<WebElement> products = productcatalog.GetProducts();
		productcatalog.AddProductToCart(Productname);
		CartPage cartpage=productcatalog.GoToCartPage();
		Boolean Boolean = cartpage.VerifyProductDisplay(Productname);
		List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(match);
		checkoutpage checkoutpage=cartpage.Checkout();	
	   checkoutpage.SelectCountry("india");
	   Confirmationpage Confirmationpage = checkoutpage.SubmitOrder();
	   String ConfirmationMessage = Confirmationpage.GetConfirmationMessage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

	@Test(dependsOnMethods = {"SubmitOrder"})
	public void OrderHistoryPage() throws IOException
	{
		
		ProductCatalog productcatalog=landingpage.loginapplication("amanmunjal1990@gmail.com","Aman.12345");
		OrderPage orderpage = productcatalog.GoToOrdersPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(Productname));
		
		
	}
	}


