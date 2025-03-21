package rahulshettyacademy.stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.LandingPage;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
	}
}
