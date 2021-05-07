package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToWishlistPage extends PageBase{

	public AddProductToWishlistPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(css = "a.product-name")
	public WebElement productNameInWishlist;
	
	@FindBy(css = "button.remove-btn")
	WebElement removeProduct;
	
	@FindBy(css = "div.no-data")
	public WebElement removeMsg;
	
	public void RemoveProduct() 
	{
		clickButton(removeProduct);
	}

}
