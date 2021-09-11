package tutorial.excercies;

import java.io.IOException;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Android_Device;

public class ecommerce_01 extends Base {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("START");
		AndroidDriver<AndroidElement> driver = capabitities();
		Android_Device emulator = new Android_Device(driver);
		emulator.runApplicationByMonkeyTools("com.androidsample.generalstore");
		emulator.hideKeyBoard();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		emulator.clickElement("text", "Female");
		driver.findElement(By.id("android:id/text1")).click();
		emulator.scrollToAnElementAndClickByText("Argentina");
		emulator.clickElement("resource-id", "com.androidsample.generalstore:id/btnLetsShop");



	}

}
