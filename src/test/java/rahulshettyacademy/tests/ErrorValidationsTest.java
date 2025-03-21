package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		String expectedErrorMessage = "Incorrect email or password.";
		landingpage.loginApplication("sumitnegi2072002@gmail.com", "Sumit344");//invalid pass

		// Trim any extra spaces from actual error message before assertion
		String actualErrorMessage = landingpage.getErrorMessage().trim();
		System.out.println("Actual Error Message: [" + actualErrorMessage + "]");
		System.out.println("Expected Error Message: [" + expectedErrorMessage + "]");

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Login error message mismatch!");
	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "IPHONE 13 PRO";
		//use diff gmail acc
		ProductCatalogue productCatalogue = landingpage.loginApplication("random1344@gmail.com", "Sumit*@1344");
		List<WebElement> products = productCatalogue.getProductList();

		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		// Verify if the incorrect product is displayed
		Boolean match = cartPage.VerifyProductDisplay("IPHONE 15 PRO");
		Assert.assertFalse(match, "Unexpected product found in the cart!");
	}
}
