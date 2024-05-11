package onlineShop;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onlineShopPageObject.LoginPagePageObj;

public class LoginPages {
	
		
	
	WebDriver driver;
	@BeforeClass
	public void checkUrlLoading() {
		driver = new FirefoxDriver();
		LoginPagePageObj lpp = new LoginPagePageObj(driver);
		lpp	.openUrl("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	 @Test
	public void loginPageWorkingFine() {	
		LoginPagePageObj lpp = new LoginPagePageObj(driver);
		lpp.loginApplication("admin12345@gmail.com", "Admin@123");
	}
	@Test
	public void dashBoardWorkingFine() {
		LoginPagePageObj lpp = new LoginPagePageObj(driver);
		boolean isTrue = lpp.dashBoardLoadingFine();
		if(isTrue==true) System.out.println("Good"); else
			System.out.println("Bad");
		driver.close();
	}
		public static void main(String[] args) {
			LoginPages lg = new LoginPages();
			lg.checkUrlLoading();
			lg.loginPageWorkingFine();
			lg.dashBoardWorkingFine();
	}
	
	



}