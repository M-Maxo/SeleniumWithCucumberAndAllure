package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderBtn;
	
	@FindBy(id="FirstName")
	WebElement fnTxtBtn;
	
	@FindBy(id="LastName")
	WebElement lnTxtBtn;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement day;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement month;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement year;
	
	@FindBy(id="Email")
	WebElement emailTxt;
	
	@FindBy(id="Password")
	WebElement pwTxt;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPwTxt;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	public WebElement myAccLink;
	public void userRegistration(String firstName , String lastName , String Day , String Month , String Year , String email , String pw)
	{	
		clickButton(genderBtn);
		setTextElemenet(fnTxtBtn, firstName);
		setTextElemenet(lnTxtBtn, lastName);
		setTextElemenet(day, Day);
		setTextElemenet(month, Month);
		setTextElemenet(year, Year);
		setTextElemenet(emailTxt, email);
		setTextElemenet(pwTxt, pw);
		setTextElemenet(confirmPwTxt, pw);
		clickButton(registerBtn);
	}
	
	public void userLogout()
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccPage() 
	{
		clickButton(myAccLink);
	}
	
}
