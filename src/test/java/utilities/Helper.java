package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	// Method to take screenshot when test case fail
	public static void captureScreenshot(WebDriver driver , String screenshotName) throws IOException
	{
		Path dest = Paths.get("./Screenshots" , screenshotName+".png");
		Files.createDirectories(dest.getParent());
		FileOutputStream out = new FileOutputStream(dest.toString());
		out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		out.close();
	}

}
