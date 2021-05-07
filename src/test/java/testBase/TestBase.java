package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public String excelSheetPath = System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional ("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshots......");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}

}
