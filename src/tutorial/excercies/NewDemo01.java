package tutorial.excercies;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Android_Device;

public class NewDemo01 extends Base {

	public static void main(String[] args) throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabitities();
		Android_Device emulator = new Android_Device(driver);
		
		emulator.runApplication("io.appium.android.apis","io.appium.android.apis.ApiDemos");
//		emulator.clickByXpath(driver,"//android.widget.TextView[@content-desc=\"Accessibility\"]");

//		emulator.scrollToText("Preference");
//		emulator.getTextById( "android:id/text1", 0);

		// #2.Example Swipe
//		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
//		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
//		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
//		driver.findElementByXPath("//*[@content-desc = '9']").click(); // * present for any type 
//		AndroidElement fromElement = driver.findElementByXPath("//*[@content-desc = '15']");
//		AndroidElement toElement = driver.findElementByXPath("//*[@content-desc = '45']");
//		emulator.swipe(fromElement, toElement);
		
		
		// #3.Example Scroll
//		emulator.clickElementById(driver, "android:id/text1", 8);
//		emulator.scrollToAnElementAndClickByText(driver, "Views");
//		emulator.scrollToAnElementAndClickByText(driver, "WebView");
		
		
		// #4.Examle Drag and Drop
//		emulator.scrollToAnElementAndClickByText(driver, "Views");
//		emulator.scrollToAnElementAndClickByText(driver, "Drag and Drop");
//		WebElement dragDrop_01 = driver.findElementsByClassName("android.view.View").get(0);
//		WebElement dragDrop_02 = driver.findElementsByClassName("android.view.View").get(1);
//		emulator.dragAndDrop(dragDrop_01, dragDrop_02);
//		
		
		
	}

}
