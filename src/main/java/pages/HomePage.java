package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver){
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;

	@FindBy(id = "customerCurrency")
	WebElement selectCurrencyList;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computerMenu;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebooksMenu;

     
	public void openRegPage()
	{
		clickButton(registerLink);
	}

	public void openLoginPage()
	{
		clickButton(loginLink);
	}

	public void openContactUsPage()
	{
		scrollToButtom();
		clickButton(contactUsLink);
	}

	public void changeCurrency()
	{
		select = new Select(selectCurrencyList);
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu()
	{
		action
		.moveToElement(computerMenu)
		.moveToElement(notebooksMenu)
		.click()
		.build()
		.perform();
	}


}
