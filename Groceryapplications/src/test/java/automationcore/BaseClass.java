package automationcore;





import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import constands.Constants;
import utilities.ScreenShotUlility;

import org.testng.annotations.BeforeMethod;

public class BaseClass {
	Properties prop;
	FileInputStream fs;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initialisebrowser(String browser) throws Exception {
		prop=new Properties();
		fs=new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();	
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();	
		}
		else {
			throw new Exception("InvalidBrowser");
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult itestresult) throws IOException {
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			ScreenShotUlility screenshot=new ScreenShotUlility();
			screenshot.captureFailureScreenShot(driver,itestresult.getName());
		}
		//driver.quit();
	}
}

