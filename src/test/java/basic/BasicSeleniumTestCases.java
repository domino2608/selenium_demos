package basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import helpers.DriverType;
import helpers.SeleniumHelper;

public class BasicSeleniumTestCases {
	private SeleniumHelper helper;
	
	@Before
	public void setUp() {
		helper = SeleniumHelper.getInstance(DriverType.FIREFOX);
	}
	
	@Test
	public void testIfPageLoads() throws InterruptedException {
		helper.openUrl(SeleniumHelper.DEFAULT_URL);
		
		helper.verifyTitleContains("ko³o naukowe");
		Thread.sleep(1000);
	}
	
	@Test
	public void shouldGoToAboutPageThroughMenu() {
		helper.openUrl(SeleniumHelper.DEFAULT_URL);
		helper.
	}
	
	@After
	public void cleanUp() throws InterruptedException {
		helper.quitDriver();
	}
	
}
