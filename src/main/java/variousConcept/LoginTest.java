package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class LoginTest {

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
		By userNameLocator = By.xpath("//input[@id='username']");
		By passwordLocator = By.xpath("//input[@id='password']");
		By signInLocator = By.xpath("//button[@name = 'login']");
	//	By dashboardHeaderLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		By customersLocator = By.xpath("//span[text()= 'Customers']");
		By addcustomerLocator = By.xpath("//a[text()= 'Add Customer']");
		By companyLocator = By.xpath("//select[@id='cid']");
		
		driver.findElement(userNameLocator).sendKeys("demo@techfios.com");
		driver.findElement(passwordLocator).sendKeys("abc123");
		driver.findElement(signInLocator).click();
		driver.findElement(customersLocator).click();
		driver.findElement(addcustomerLocator).click();
		driver.findElement(companyLocator).click();
		
		Select sel = new Select(driver.findElement(companyLocator));
		sel.selectByVisibleText("Techfios");
			
		
//		Assert.assertTrue("Dashboard Page Not Found!!!", driver.findElement(By.xpath("//span[contains(text(), 'Customers')]")).isDisplayed());
//		System.out.println(driver.getTitle());
	
	}
//	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
