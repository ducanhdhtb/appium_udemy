package tutorial.excercies;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.Android_Device;


public class ecommerce_05 extends Base{
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
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f1() throws IOException, InterruptedException {
		System.out.println("Run f1");
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
	public void f2() throws IOException, InterruptedException {
		System.out.println("Run f2");
		emulator.goHome();
		emulator.runApplicationByMonkeyTools("com.androidsample.generalstore");
		emulator.clickElementById("com.androidsample.generalstore:id/productAddCart", 0);
		emulator.clickElementById("com.androidsample.generalstore:id/productAddCart", 1);
		emulator.clickElementById("com.androidsample.generalstore:id/appbar_btn_cart", 0);

		String productPrice_1 = emulator.uiGetObjectByAttributes(By.xpath("//*[@resource-id = 'com.androidsample.generalstore:id/productPrice']"), "text",0);
		String productPrice_2 = emulator.uiGetObjectByAttributes(By.xpath("//*[@resource-id = 'com.androidsample.generalstore:id/productPrice']"), "text",1);

		System.out.println(getAmount(productPrice_1));
		System.out.println(getAmount(productPrice_2));
		double productPrice_01after = getAmount(productPrice_1);
		double productPrice_02after = getAmount(productPrice_2);
		double actualResult = productPrice_01after + productPrice_02after;

		String total = emulator.uiGetObjectByAttributes(By.xpath("//*[@resource-id = 'com.androidsample.generalstore:id/totalAmountLbl']"), "text",0);
		double total_after = getAmount(total);
		double expectedResult = total_after;
		System.out.println("Expected : " + expectedResult);
		System.out.println("Actual : " + expectedResult);
		assertEquals(actualResult, expectedResult);
	}


	@Test
	public void f3() throws IOException, InterruptedException {
		System.out.println("Run f3");
		emulator.goHome();
		emulator.runApplicationByMonkeyTools("com.androidsample.generalstore");
		emulator.clickElement("class", "android.widget.CheckBox");
		emulator.longPress(By.id("com.androidsample.generalstore:id/termsButton"));
		emulator.clickElementByText("CLOSE", 0);
		emulator.clickElementByText("Visit to the website to complete purchase", 0);
		Thread.sleep(7000);
		


	}
	
	@Test
	public void f4() throws InterruptedException {
		System.out.println("Run f4");
		// Web Gestures
		Thread.sleep(15000);
		Set<String> contexts = driver.getContextHandles();
		for(String context : contexts) {
			System.out.println(context);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(15000);
		System.out.println("Get Currelt url : " + driver.getCurrentUrl());
		driver.findElementByXPath("//*[@name = 'q']").sendKeys("Hello Wolrd");
		driver.findElementByXPath("//*[@name = 'q']").sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public static double getAmount(String value)
	{
		value= value.substring(1);

		double amount2value=Double.parseDouble(value);

		return amount2value;

	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.quit();
	}
}
