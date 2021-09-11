package tutorials.section07.ecommerce;



import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tutorials.section04.Base;

public class RealDevice extends tutorials.section06.HybridBase {


	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabitities("emulator-5554");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

		WebElement dragDrop_01 = driver.findElementsByClassName("android.view.View").get(0);
		WebElement dragDrop_02 = driver.findElementsByClassName("android.view.View").get(1);

		TouchAction action = new TouchAction(driver);
		action.longPress(element(dragDrop_01))
		.moveTo(element(dragDrop_02))
		.release()
		.perform();



	}


}
