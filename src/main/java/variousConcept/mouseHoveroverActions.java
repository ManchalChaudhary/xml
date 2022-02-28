package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class mouseHoveroverActions {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.dell.com/en-us");
	}

	@Test
	public void mouseHoverTest() {
		// save locators first in By class.....................

		By productsLocator = By.xpath("//span[text()='Products']");
		By monitorssLocator = By.xpath("//a[contains(text(), 'Monitors')]");
		By monitorsForHomeLocator = By.xpath("//a[contains(text(), 'Monitors')]/parent::li[1]/descendant::a[3]");
		By monitorsAndMonitorAccessariesLocator = By.xpath("//h1[contains(text(), 'Monitors & Monitor Accessories')]");
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(productsLocator)).build().perform();
		action.moveToElement(driver.findElement(monitorssLocator)).build().perform();
		driver.findElement(monitorsForHomeLocator).click();
		
		Assert.assertTrue("monitor home page not found", driver.findElement(monitorsAndMonitorAccessariesLocator).isDisplayed());
		System.out.println(driver.findElement(monitorsAndMonitorAccessariesLocator).getText());
	}

//	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
