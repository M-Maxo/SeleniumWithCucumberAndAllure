package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import testBase.TestBase;

public class F06_RegisteredUserAddProductReview extends TestBase {
	
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Add product review Test Case")
	@Link(name = "Add product review Page")
	@Given("R-user in home page")
	public void r_user_in_home_page() throws InterruptedException {
		Thread.sleep(500);
		driver.navigate().to("https://demo.nopcommerce.com");
	}
	
	@When("R-user can search for product {string}")
	public void r_user_can_search_for_product(String productName) throws InterruptedException {
		searchObject = new SearchPage(driver);
		Thread.sleep(500);
		searchObject.ProductSearchAutoSuggest(productName);
	}
	
	@When("R-user click on add review")
	public void r_user_click_on_add_review() throws InterruptedException {
		Thread.sleep(500);
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddUserReview();
	}
	
	@Then("R-user fill out review details")
	public void r_user_fill_out_review_details() throws InterruptedException {
		reviewObject = new ProductReviewPage(driver);
		Thread.sleep(500);
		reviewObject.productReview("My first Review", "Hello i am so happy........");
	}
	
	@Then("make sure the review successfully {string}")
	public void make_sure_the_review_successfully(String reviewSuccess) throws InterruptedException {
		Thread.sleep(500);
		Assert.assertEquals(reviewObject.successMsg.getText(), reviewSuccess);
	}

}
