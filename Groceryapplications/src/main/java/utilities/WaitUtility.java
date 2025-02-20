package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static int WaitDuration=5;
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public static void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitForWebElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element to be clickable
	public void waitForElementToBeClickable(By locator, int timeout) {
		WebDriver driver = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForWebElementTextPresent(WebDriver driver, WebElement element, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitDuration));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, attribute));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitDuration));
	}
}
