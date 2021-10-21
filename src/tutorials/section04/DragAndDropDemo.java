package tutorials.section04;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDropDemo extends Base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabitities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

		WebElement dragDrop_01 = driver.findElementsByClassName("android.view.View").get(0);
		WebElement dragDrop_02 = driver.findElementsByClassName("android.view.View").get(1);

		TouchAction action = new TouchAction(driver);
		// LongPress/Move/Relase/Perform
//		action.longPress( longPressOptions().withElement(element(dragDrop_01)).withDuration(ofSeconds(2)) )
//		.moveTo(element(dragDrop_02))
//		.release()
//		.perform();
		action.longPress(element(dragDrop_01))
		.moveTo(element(dragDrop_02))
		.release()
		.perform();

	}

}
