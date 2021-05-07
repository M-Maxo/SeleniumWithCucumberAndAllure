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
import pages.ProductDetailsPage;
import pages.SearchPage;
import testBase.TestBase;

public class F03_SearchForProduct extends TestBase {
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	LoginPage loginObject;
	SearchPage searchObject;
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Search for product Test Case")
	@Link(name = "Search for product Page")
	
	@Given("i write name of product in search from excelsheet {string} , {int}")
	public void i_write_name_of_product_in_search_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String productName = testData.get(rowNumber).get("productName");
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest(productName);
	}
	
	@Then("guest user can show  product info {string} , {int}")
	public void guest_user_can_show_product_info(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String productName = testData.get(rowNumber).get("productName");
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(detailsObject.productNameAppear.getText().contains(productName));
	}
	
	@Given("registered user need to login")
	public void registered_user_need_to_login() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
	}
	
	@When("user enter his credential from excelsheet {string} , {int}")
	public void user_enter_his_credential_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String email = testData.get(rowNumber).get("Email");
		String newPassword = testData.get(rowNumber).get("newPassword");
		loginObject = new LoginPage(driver);
		Thread.sleep(500);
		loginObject.userCanLogin(email, newPassword);
	}
	
	@When("write product name and search from excelsheet {string} , {int}")
	public void write_product_name_and_search_from_excelsheet(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String productName = testData.get(rowNumber).get("productName");
		
		Thread.sleep(500);
		searchObject.ProductSearchAutoSuggest(productName);
	}
	
	@Then("registered user can show product info {string} , {int}")
	public void registered_user_can_show_product_info(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData=reader.getData(excelSheetPath, sheetName);
		String productName = testData.get(rowNumber).get("productName");
		
		Thread.sleep(500);
		Assert.assertTrue(detailsObject.productNameAppear.getText().contains(productName));
	}

}
