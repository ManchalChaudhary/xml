package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvents {
WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}
	
	@Test
	public void loginTest() {
	//storing webElements by using By class
		By userNameLocator = By.xpath("//*[@id=\"username\"]");
		By passwordLocator = By.xpath("//*[@id=\"password\"]");
	//	By signInLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
		
		driver.findElement(userNameLocator).sendKeys("demo@techfios.com");
		driver.findElement(passwordLocator).sendKeys("abc123");
	//	driver.findElement(signInLocator).click();
		
		Actions action = new Actions(driver);
	//	action.sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.RETURN).build().perform();

	}
//	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
