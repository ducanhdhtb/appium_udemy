package tutorials.section04;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll extends Base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabitities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		AndroidElement a = scrollToAnElementByText(driver,"WebView");

	}

	public static AndroidElement scrollToAnElementByText(AndroidDriver<AndroidElement> driver, String text) {
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");

	}


}
