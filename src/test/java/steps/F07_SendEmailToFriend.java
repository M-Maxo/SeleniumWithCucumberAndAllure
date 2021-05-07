package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SendEmailToFriendPage;
import testBase.TestBase;

public class F07_SendEmailToFriend extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	SendEmailToFriendPage emailObject;
	
	Faker fakeData = new Faker();
	String friendEmail = fakeData.internet().emailAddress();
	String message = "Good Product: https://demo.nopcommerce.com/apple-macbook-pro-13-inch";
	
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Send email to friend Test Case")
	@Link(name = "Send email to friend Page")
	@Given("iam in home page and search for product {string}")
	public void iam_in_home_page_and_search_for_product(String productName) throws InterruptedException {
		driver.navigate().to("https://demo.nopcommerce.com");
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(500);
		searchObject.ProductSearch(productName);
		Thread.sleep(500);
		searchObject.OpenProductDetailsPage();
	}
	
	@When("i click on friend email")
	public void i_click_on_friend_email() throws InterruptedException {
		Thread.sleep(500);
		detailsObject.SendEmailFriend();
	}
	
	@Then("fill out friend information and send the email")
	public void fill_out_friend_information_and_send_the_email() throws InterruptedException {
		emailObject = new SendEmailToFriendPage(driver);
		Thread.sleep(500);
		emailObject.sendEmail(friendEmail, message);
	}
	
	@Then("make sure email sent succefully {string}")
	public void make_sure_email_sent_succefully(String successMsg) throws InterruptedException {
		Assert.assertTrue(emailObject.successMsg.getText().equalsIgnoreCase(successMsg));
		
		
		driver.navigate().to("https://translate.google.com/");
		driver.findElement(By.cssSelector("textarea.er8xn")).sendKeys("Thanks For Watching <3...");
		Thread.sleep(4000);
	}

}
