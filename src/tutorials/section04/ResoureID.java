package tutorials.section04;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ResoureID extends Base {
	public static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		driver = capabitities();
		driver.findElementByXPath("//android.widget.ListView//android.widget.TextView[@text = 'Preference']"); // Lession 15 
		driver.findElementByXPath("//android.widget.ListView//android.widget.TextView[@text = '3. Preference dependencies']");  // Lession 15
		driver.findElementById("android:id/checkbox").click();  // Lession 16

	}
	
	

}
