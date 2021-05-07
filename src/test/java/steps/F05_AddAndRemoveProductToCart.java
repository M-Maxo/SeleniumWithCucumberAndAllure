package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.AddProductToShopingCartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import testBase.TestBase;

public class F05_AddAndRemoveProductToCart extends TestBase {
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToShopingCartPage cartObject;
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Add To Cart Test Case")
	@Link(name = "Add to cart Page")
	
	@Given("user can search for product {string}")
	public void user_can_search_for_product(String productName) throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest(productName);
		
	}
	
	@When("after redirect to product details i click on add to cart")
	public void after_redirect_to_product_details_i_click_on_add_to_cart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(500);
		detailsObject.AddToCart();
	}
	
	@When("make sure about product price {string}")
	public void make_sure_about_product_price(String productPrice) throws InterruptedException {
		cartObject = new AddProductToShopingCartPage(driver);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(500);
		Assert.assertTrue(cartObject.totalLbl.getText().contains(productPrice));
	}
	
	@Then("i click on remove label")
	public void i_click_on_remove_label() throws InterruptedException {
		cartObject = new AddProductToShopingCartPage(driver);
		cartObject.RemoveProduct();
	}
	

}
