package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToShopingCartPage extends PageBase{

	
	public AddProductToShopingCartPage(WebDriver driver){
		super(driver);
	}

	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	
	@FindBy(css = "button.button-2.update-cart-button")
	WebElement updateBtn;
	
	@FindBy(id = "itemquantity11215")
	WebElement quantityTxt;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement totalLbl;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement agreementCheck;
	
	public void RemoveProduct()
	{
		clickButton(removeBtn);
		//clickButton(updateBtn);
	}
	
	public void UpdateProductQuantity(String quantity)
	{
		clearText(quantityTxt);
		setTextElemenet(quantityTxt, quantity);
		clickButton(updateBtn);
	}
	
	public void OpenCheckoutPage() 	
	{
		clickButton(agreementCheck);
		clickButton(checkoutBtn);
	}

}
