package tutorials.section09.MobileChromeAutomationWithAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class example_01 extends tutorials.section07.ecommerce.HybridBase{


	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");



		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector(".navbar-toggler")).click();

		driver.findElement(By.cssSelector("a[href*='products']")).click();

		JavascriptExecutor js= (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,1000)", "");

		String text =driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();

		Assert.assertEquals(text, "Devops");
		
	}



}