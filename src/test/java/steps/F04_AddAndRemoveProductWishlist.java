package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.AddProductToWishlistPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testBase.TestBase;

public class F04_AddAndRemoveProductWishlist extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToWishlistPage wishlistObject;
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Wishlist Test Case")
	@Link(name = "Wishlist Page")
	@Given("user search for product {string}")
	public void user_search_for_product(String productName) throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest(productName);
	}
	
	@When("user in product details page click on add to wishlist button")
	public void user_in_product_details_page_click_on_add_to_wishlist_button() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(1000);
		detailsObject.AddProductToWishlist();
	}
	
	@When("click on remove button")
	public void click_on_remove_button() throws InterruptedException {
		wishlistObject = new AddProductToWishlistPage(driver);
		Thread.sleep(500);
		wishlistObject.RemoveProduct();
	}
	
	@Then("make sure wishlist is empty {string}")
	public void make_sure_wishlist_is_empty(String emptyTxt) {
		Assert.assertEquals(wishlistObject.removeMsg.getText(),emptyTxt);
	}

}
