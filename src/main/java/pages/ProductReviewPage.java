package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id = "addproductrating_3")
	WebElement reviewRate;
	
	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void productReview(String reviewTitle , String review) 
	{
		setTextElemenet(reviewTitleTxt, reviewTitle);
		setTextElemenet(reviewTxt, review);
		clickButton(reviewRate);
		clickButton(submitBtn);
	}

}
