package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameAppear;
 	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement sendFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement productPrice;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewTxt;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addWishlistBtn;
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistTxt;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement compareTxt;
	
	@FindBy(linkText = "product comparison")
	WebElement comparisonTxt;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	
	
	
	public void SendEmailFriend()
	{
		clickButton(sendFriendBtn);
	}
	
	public void AddUserReview() 
	{
		clickButton(addReviewTxt);
	}
	
	public void AddProductToWishlist() 
	{
		clickButton(addWishlistBtn);
		clickButton(wishlistTxt);
	}
	
	public void AddToCompareList() 
	{
		clickButton(compareTxt);
	}
	
	public void GoToComparisonPage()
	{
		clickButton(comparisonTxt);
	}
	
	public void AddToCart() 
	{
		clickButton(AddToCartBtn);
	}
		
}
