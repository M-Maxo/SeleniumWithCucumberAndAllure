package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> searchMenu;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		setTextElemenet(searchTxtBox,productName);
		clickButton(searchBtn);
	}
	
	public void OpenProductDetailsPage() 
	{
		clickButton(productTitle);
	}
	
	public void ProductSearchAutoSuggest(String searchTxt)
	{
		setTextElemenet(searchTxtBox, searchTxt);
		searchMenu.get(0).click();
	}

}
