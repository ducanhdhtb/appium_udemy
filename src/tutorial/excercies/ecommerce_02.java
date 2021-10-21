package tutorial.excercies;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import junit.framework.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Android_Device;

public class ecommerce_02 extends Base{



	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabitities();
		Android_Device emulator = new Android_Device(driver);
		emulator.runApplicationByMonkeyTools("com.androidsample.generalstore");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0))"));

		//   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String alert = emulator.getAlertText();
		System.out.println(String.format("Alert text : %s", alert));
		String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		
		System.out.println(toastMessage);
		Assert.assertEquals("Please enter your name", toastMessage);//Actual validation

		//name attribute for toast messages will have content
	}
}
