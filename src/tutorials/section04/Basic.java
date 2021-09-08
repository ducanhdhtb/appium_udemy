package tutorials.section04;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basic extends Base {
	public static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		driver = capabitities();
		clickElementByXpathAndTextAttribute("//android.widget.ListView//android.widget.TextView[@text = 'Preference']"); // Lession 15 
		clickElementByXpathAndTextAttribute("//android.widget.ListView//android.widget.TextView[@text = '3. Preference dependencies']");  // Lession 15
		clickElementByID("android:id/checkbox");  // Lession 16
		clickElementByXpathAndClassAttribute("//android.widget.LinearLayout[2]");// Lession 16
		driver.findElementById("android:id/edit").sendKeys("ducanh123");// Lession 16
		clickElementByXpathAndTextAttribute("//android.widget.LinearLayout//android.widget.Button[@text = \"OK\"]");// Lession 16


		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click(); // Lession 17
		driver.findElementByClassName("android.widget.EditText").sendKeys("ducanh123");// Lession 17
		driver.findElementsByClassName("android.widget.Button").get(1).click(); // Lession 17
	}
	
	

	// SUPPORTED FUNCTION
	public static void findElementByClassName(String className) {
		driver.findElementByClassName(className);
	}
	
	public static void clickElementByXpathAndClassAttribute(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void clickElementByXpathAndTextAttribute(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	public static void clickElementByID(String id) {

		driver.findElement(By.id(id)).click();
	}

}
