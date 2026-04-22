package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class ErrorValidations extends BaseTest {
	
	@Test
	public void ErrorValidationofLogin() throws IOException
	{
		String Productname = "ZARA COAT 3";
		
		
		ProductCatalog productcatalog=landingpage.loginapplication("amanmunjal199@gmail.com","Aman.12345");
		landingpage.ErrorMessage();
		Assert.assertEquals("Incorrect email or password.", landingpage.ErrorMessage());

}
	@Test
	public void ErrorValidationofSubmitOrder() throws IOException
	{
		String Productname = "ZARA COAT 3";
		
		
		ProductCatalog productcatalog=landingpage.loginapplication("amanmunjal1990@gmail.com","Aman.12345");
		List<WebElement> products = productcatalog.GetProducts();
		productcatalog.AddProductToCart(Productname);
		
		CartPage cartpage=productcatalog.GoToCartPage();
		
		
		 Boolean Boolean = cartpage.VerifyProductDisplay(Productname);
		
		
		List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(match);
}
}