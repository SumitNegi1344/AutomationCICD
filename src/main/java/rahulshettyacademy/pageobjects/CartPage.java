package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	
	
	 @FindBy(css=".totalRow button")
	 WebElement checkoutEle;
	
	 
	 @FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	public Boolean VerifyProductDisplay(String productName)  {
		Boolean match=cartProducts.stream()	.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
				
	}
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
}
























//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

//Boolean match = cartProducts.stream()
	//	.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
//Assert.assertTrue(match);
//driver.findElement(By.cssSelector(".totalRow button")).click();

