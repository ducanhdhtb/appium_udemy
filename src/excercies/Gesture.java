package excercies;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Gesture extends tutorials.section04.Base {

	public static void main(String[] args) throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabitities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		WebElement expandList=	driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		TouchAction action = new TouchAction(driver);		
		action.tap(tapOptions().withElement(element(expandList))).perform();
		WebElement customAdaptor =	driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
		customAdaptor.click();
		WebElement peopleName =	driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		action.longPress(longPressOptions().withElement(element(peopleName)).withDuration(ofSeconds(2)))
		.release()
		.perform();

	}
}
