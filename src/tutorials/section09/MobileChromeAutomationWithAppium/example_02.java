package tutorials.section09.MobileChromeAutomationWithAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class example_02 extends tutorials.section07.ecommerce.HybridBase{
	AndroidDriver<AndroidElement> driver;
	String baseUrl = "http://demo.guru99.com/v4/index.php";
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		String urlRemote = "http://127.0.0.1:4723/wd/hub";
		
		driver = new AndroidDriver<>(new URL(urlRemote), capabilities);
	}

	@Test(priority = 1)
	public void checkUserEmpty() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@name = 'uid']")).click();
		driver.findElement(By.xpath("//*[@name = 'password']")).click();
		String expectedResult = "User-ID must not be blank";
		String actualResult = driver.findElement(By.xpath("//*[@id='message23']")).getText();
		Assert.assertEquals(expectedResult, actualResult);
		
		
	}
	
	@Test(priority = 2)
	public void checkPassworkdEmpty() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@name = 'password']")).click();
		driver.findElement(By.xpath("//*[@name = 'uid']")).click();
		String expectedResult = "Password must not be blank";
		String actualResult = driver.findElement(By.xpath("//*[@id='message18']")).getText();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test(priority = 3)
	public void checkOther() {
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.findElement(By.cssSelector(".navbar-toggler")).click();
			driver.findElement(By.cssSelector("a[href*='products']")).click();
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			String text =driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
			Assert.assertEquals(text, "Devops");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}