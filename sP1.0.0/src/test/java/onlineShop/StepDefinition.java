package onlineShop;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onlineShopPageObject.LoginPagePageObj;

public class StepDefinition {
WebDriver driver;
	
	@Given("^I have check url working$")
	public void checkUrlLoading() {
		
		driver = new FirefoxDriver();
		LoginPagePageObj lpp = new LoginPagePageObj(driver);
		lpp	.openUrl("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	 @When("^I have check loggin page working&")
	public void loginPageWorkingFine() {	
		LoginPagePageObj lpp = new LoginPagePageObj(driver);
		lpp.loginApplication("admin12345@gmail.com", "Admin@123");
	}
	@Then("^I have check dashboard page working&")
	public void dashBoardWorkingFine() {
		LoginPagePageObj lpp = new LoginPagePageObj(driver);
		boolean isTrue = lpp.dashBoardLoadingFine();
		if(isTrue==true) System.out.println("Good"); else
			System.out.println("Bad");
		driver.close();
	}


}
