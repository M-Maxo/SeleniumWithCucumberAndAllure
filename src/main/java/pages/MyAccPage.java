package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccPage extends PageBase {

	public MyAccPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePwLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPw;
	
	@FindBy(id = "NewPassword")
	WebElement newPw;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPw;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changeBtn;
	
	@FindBy(xpath = "/html/body/div[5]/div/p")
	public WebElement result;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	WebElement closeResult;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	public void changePwPage() 
	{
		clickButton(changePwLink);
	}
	
	public void changePassword(String OldPw , String NewPw) 
	{
		setTextElemenet(oldPw, OldPw);
		setTextElemenet(newPw, NewPw);
		setTextElemenet(confirmNewPw, NewPw);
		clickButton(changeBtn);
	}
	
	public void closeResultAfterChange()
	{
		clickButton(closeResult);
	}
}
