/**
 * @author Dominik Ciborowski
 */
package helpers;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumHelper {
	public static final String DEFAULT_URL = "http:\\java.pja.edu.pl";

	public static SeleniumHelper instance;

	private WebDriver webDriver;

	private SeleniumHelper() {
	}

	public static SeleniumHelper getInstance(DriverType driverType) {
		if (instance == null) {
			instance = new SeleniumHelper();
		}

		switch (driverType) {
		case FIREFOX:
			instance.initFirefoxDriver();
			break;
		}

		return instance;
	}

	private void initFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		webDriver = new FirefoxDriver();
	}

	public void openUrl(String url) {
		webDriver.get(url);
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public void verifyTitle(String expectedTitle) {
		String title = webDriver.getTitle();

		assertEquals(expectedTitle, title);
	}

	public void verifyTitleContains(String partOfExpectedTitle) {
		String title = webDriver.getTitle();

		System.out.println(title);
		
		assertTrue("Title does not contains: " + partOfExpectedTitle,
				title.toLowerCase().contains(partOfExpectedTitle));
	}
	
	public void verifyTextPresentOnPage() {
//		we
		
		
	}

	public void quitDriver() {
		webDriver.close();
		webDriver.quit();
	}
}
