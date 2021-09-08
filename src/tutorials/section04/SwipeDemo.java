package tutorials.section04;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class SwipeDemo extends Base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabitities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc = '9']").click(); // * present for any type 
		AndroidElement firstElement = driver.findElementByXPath("//*[@content-desc = '15']");
		AndroidElement secondElement = driver.findElementByXPath("//*[@content-desc = '45']");
		
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(2))).moveTo(element(secondElement)).release().perform();




	}
}

