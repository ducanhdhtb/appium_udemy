package tutorial.excercies;

import java.io.IOException;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Android_Device;

public class Demo_genericmethod extends Base {

	private static final boolean True = false;

	public static void main(String[] args) throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabitities();
		Android_Device emulator = new Android_Device(driver);
//		emulator.runApplicationByMonkeyTools("com.androidsample.generalstore");
//		emulator.openNotifications();
//		driver.findElement(By.id("android:id/text1")).click();
//		emulator.scrollDown(5,5000);
		emulator.getContext();



	}

}
