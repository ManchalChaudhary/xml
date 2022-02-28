package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIFrame {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
	}

	@Test
	public void iFrameTest() {
		//driver.switchTo().frame(0);
		driver.switchTo().frame("packageListFrame");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("java.awt.color")).click();
		
		
		
		driver.switchTo().parentFrame();
		//driver.switchTo().frame("packageFrame");
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("ICC_ColorSpace")).click();
		
		driver.switchTo().parentFrame();
		//driver.switchTo().frame("classFrame");
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("java.lang.Object")).click();

	}

	@After
	public void tearDown() {
	//	driver.close();
		driver.quit();
	}
}
