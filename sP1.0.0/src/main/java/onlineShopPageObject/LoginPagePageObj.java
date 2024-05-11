package onlineShopPageObject;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstraction.AbstractionComponents;

public class LoginPagePageObj extends AbstractionComponents  {

	WebDriver driver;

	public LoginPagePageObj(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	@FindBy(id="userEmail")
	WebElement userNameField;

	@FindBy(id = "userPassword")
	WebElement passwordField;

	@FindBy(id = "login")
	WebElement loginButton;

	@FindBy(className = "card-img-top")
	List<WebElement> DashBoardMList;

	By dashBoardMenuList = By.className("card-img-top");

	public void openUrl(String url) {

		driver.get(url);
		driver.manage().window().maximize();
	}

	public  void loginApplication(String email,String password) {
		userNameField.sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//	WebDriverWait wait = new WebDriverWait(driver,10);
		//WebElement element= .until(ExceptedConditions.visiblityOfElementLocated(By.id(password)));
		
		passwordField.sendKeys(password);
		loginButton.click();
	}
	public List<WebElement> dashBoardList() {
		waitForElementToAppear(dashBoardMenuList);
		for(int i=0; i<DashBoardMList.size(); i++) {
		}
		return DashBoardMList;
	}

	public boolean dashBoardLoadingFine() {
		List<WebElement> actualStringForDash = dashBoardList();
		List<String> expectedStringForDash = dashBoardtestData();
		int sizeOfAcDash = actualStringForDash.size();
		int sizeOfExpectedStringForDash = expectedStringForDash.size();
		int count=0;
			for(int i=0; i<sizeOfAcDash; i++) {
				if(actualStringForDash.get(i).getText().equals(expectedStringForDash.get(i))) {
					count++;
				}
			}
		if(count==sizeOfExpectedStringForDash)return true;
		return false;

	}
	public List<String> dashBoardtestData(){

		List<String> dashboardTestData = Arrays.asList("Admin",
				"PIM",
				"Leave",
				"Time",
				"Recruitment",
				"My Info",
				"Performance",
				"Dashboard",
				"Directory",
				"Maintenance",
				"Claim",
				"Buzz"
				);
		return dashboardTestData;
	}
}
