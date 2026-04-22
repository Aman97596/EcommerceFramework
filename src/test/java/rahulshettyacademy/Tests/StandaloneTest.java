package rahulshettyacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Landingpage;

public class StandaloneTest {

	public static void main(String[] args) {
		String Productname = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client"); 
		driver.manage().window().maximize();
		Landingpage landingpage=new Landingpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("amanmunjal1990@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Aman.12345");
		driver.findElement(By.id("login")).click();
		
		
		
		List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement Product = Products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname)).findFirst().orElse(null);
		
		Product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ng-animating")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean Boolean = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(Boolean);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions action =new Actions(driver);
		
		action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String ConfirmMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary"))).getText();
		
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
