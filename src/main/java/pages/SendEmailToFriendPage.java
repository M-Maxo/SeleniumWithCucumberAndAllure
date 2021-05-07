package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailToFriendPage extends PageBase{

	public SendEmailToFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id = "YourEmailAddress")
	public WebElement yourEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMsgTxt;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void sendEmail(String friendEmail , String personalMsg)
	{
		setTextElemenet(friendEmailTxt, friendEmail);
		setTextElemenet(personalMsgTxt, personalMsg);
		clickButton(sendEmailBtn);
		
	}

}
