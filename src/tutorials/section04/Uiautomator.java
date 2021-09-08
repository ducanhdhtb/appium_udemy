package tutorials.section04;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Uiautomator extends Base {
	public static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		driver = capabitities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElementByAndroidUIAutomator("attribute("value")")
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//  Validate clickable feature for all options
		int total = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		System.out.println(total);


	}
}



