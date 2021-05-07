package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import data.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import testBase.TestBase;

public class F01_RegistrationAndLogin extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	// User will Register
	
	
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Registration Test Case")
	@Link(name = "Registeration Page",url = "https://demo.nopcommerce.com/register?returnUrl=%2F")
	
	@Given("The user in main home page")
	public void the_user_in_home_page() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("I get user info from excelsheet {string} , {int}")
	public void i_get_user_info_from_excelsheet(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String firstName = testData.get(rowNumber).get("FirstName");
		String lastName = testData.get(rowNumber).get("LastName");
		String email = testData.get(rowNumber).get("Email");
		String password = testData.get(rowNumber).get("Password");
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstName, lastName, "7", "4", "1996", email, password);
	}

	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() throws InterruptedException {
		Thread.sleep(500);
		registerObject.userLogout();
	}
	
	// User will Login
		
	@Given("click on login link")
	public void click_on_login_link() throws InterruptedException {
		Thread.sleep(500);
		homeObject.openLoginPage();
	}
	
	@When("I entered login info from excelsheet {string} , {int}")
	public void i_entered_login_info_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String email = testData.get(rowNumber).get("Email");
		String password = testData.get(rowNumber).get("Password");
		
		loginObject = new LoginPage(driver);
		Thread.sleep(500);
		loginObject.userCanLogin(email, password);
	}
	
	@Then("User can logout")
	public void user_can_logout() throws InterruptedException {
		Thread.sleep(500);
		registerObject.userLogout();
	}


}
