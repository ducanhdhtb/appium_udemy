package tutorial.excercies;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Android_Device;


public class ecommerce_03 extends Base{
	Android_Device emulator;
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		try {
			driver = capabitities();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.driver = driver;
		Android_Device emulator = new Android_Device(driver);
		this.emulator = emulator;
	}

	@Test
	public void f1() throws IOException, InterruptedException {
		emulator.runApplicationByMonkeyTools("com.androidsample.generalstore");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0))"));
		//   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}
	@Test
	public void f2() {
		emulator.scrollToText("Jordan 6 Rings");
		int count=    driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(text.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		emulator.sleepFor(25);
		String actualResult = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		assertEquals(actualResult, "Jordan 6 Rings");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.quit();
	}
}
