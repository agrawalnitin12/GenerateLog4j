package log4jTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/");
	}

	@Test
	public void freeCRMtitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("CRMPRO  - CRM software for customer relationship management, sales, and support.", title);
	}

	@Test
	public void freeCRMLogoTest() {
		boolean logo = driver.findElement(By.xpath("//a[@class='navbar-brand']/img")).isDisplayed();
		Assert.assertTrue(logo);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
