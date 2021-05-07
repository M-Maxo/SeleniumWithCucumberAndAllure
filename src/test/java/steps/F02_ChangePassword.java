package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
import pages.MyAccPage;
import pages.UserRegistrationPage;
import testBase.TestBase;

public class F02_ChangePassword extends TestBase{
	
	HomePage homeObject;
	LoginPage loginObject;
	MyAccPage accObject;
	UserRegistrationPage registerObject;
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Change Password Test Case")
	@Link(name = "change password Page")
	@Given("I click on login link")
	public void i_click_on_login_link() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
	}
	
	
	@When("User enter login info from excelsheet {string} , {int}")
	public void user_enter_login_info_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String email = testData.get(rowNumber).get("Email");
		String password = testData.get(rowNumber).get("Password");
		
		loginObject = new LoginPage(driver);
		Thread.sleep(500);
		loginObject.userCanLogin(email, password);
	}
	
	@When("Click on my acc page")
	public void click_on_my_acc_page() throws InterruptedException {
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(500);
		registerObject.openMyAccPage();
		
	}
	
	@When("Click on change password")
	public void click_on_change_password() throws InterruptedException {
		accObject = new MyAccPage(driver);
		Thread.sleep(500);
		accObject.changePwPage();
	}
	
	@When("User entered passwords from excelsheet {string} , {int}")
	public void user_entered_passwords_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String password = testData.get(rowNumber).get("Password");
		String newPassword = testData.get(rowNumber).get("newPassword");
		
		Thread.sleep(500);
		accObject.changePassword(password, newPassword);
		accObject.closeResultAfterChange();
	}
	
	@Then("user click on logout")
	public void user_click_on_logout() throws InterruptedException {
		Thread.sleep(500);
		registerObject.userLogout();
	}
	
	@Given("i click Login link")
	public void i_click_login_link() throws InterruptedException {
		homeObject = new HomePage(driver);
		Thread.sleep(500);
		homeObject.openLoginPage();
	}
	
	@When("I enter login info from excelsheet {string} , {int}")
	public void i_enter_login_info_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String email = testData.get(rowNumber).get("Email");
		String newPassword = testData.get(rowNumber).get("newPassword");
		
		Thread.sleep(500);
	    loginObject.userCanLogin(email, newPassword);
	}
	
	@Then("user click logout link")
	public void user_click_logout_link() throws InterruptedException {
		Thread.sleep(500);
		registerObject.userLogout();
	}
	

}
