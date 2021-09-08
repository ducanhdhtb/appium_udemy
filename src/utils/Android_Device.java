package utils;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excercies.Base;
import excercies.Constant;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Android_Device extends Base{

	public static AndroidDriver<AndroidElement> driver;

	public Android_Device(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void setupCababilities() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver;
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Constant.DEVICE_NAME);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constant.AUTOMATION_NAME);//new step
		driver = new AndroidDriver<>(new URL(Constant.URL_SERVER), cap);
		System.out.println("Init Succesfully!!");
	}

	public void clickByXpath(String xPath) {
		if(waitForElementByXpath(xPath)) {
			AndroidElement ele = driver.findElement(By.xpath(xPath));
			System.out.println(ele);
			ele.click();
		}else {
			System.out.println("Can't get elemt " + xPath);
			System.exit(0);
		}
	}

	public void scrollToText(String visibleText) {
		try {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
			System.out.println("Click To Text: " + visibleText + " Successfully!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void clickElement(String attibute,String value) {
		//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		
		////		"text(\"OS\")"
		//		String sf1 = String.format("{}", attibute,value);
		//		driver.findElementByAndroidUIAutomator(sf1).click();
		//		driver.findElementByAndroidUIAutomator("text(\"Sensors\")").click();

	}

	public void clickElementById(String id,int occourence) throws InterruptedException {
		try {
			List<AndroidElement> mobileElement =  driver.findElements(By.id(id));
			mobileElement.get(occourence).click();
			System.out.println("Click " + mobileElement.get(occourence).getText() + "Success!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public String getTextById(String id,int occourence) {
		List<AndroidElement> mobileElement =  driver.findElements(By.id(id));
		String ele = mobileElement.get(occourence).getText();
		System.out.println("Get Text Attribute " + "[" + mobileElement.get(occourence).getText() + "]" + " From ResourceId: " + id );
		return ele;

	}
	public boolean waitForElementByXpath(String xPath) {
		boolean isElementPresent;
		try{
			AndroidElement mobileElement = driver.findElement(By.xpath(xPath));
			int timeLimitInSeconds = 15;
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;	
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}


	public boolean waitForElementById(String id) {
		boolean isElementPresent;
		try{
			AndroidElement mobileElement = driver.findElementById(id);
			int timeLimitInSeconds = 15;
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;	
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}


	public static void clickElementByID(String id) {
		driver.findElement(By.id(id)).click();
	}

	public static void clickElementByXpathAndTextAttribute(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void findElementByClassName(AndroidDriver<AndroidElement>driver,String className) {
		driver.findElementByClassName(className);
	}

	public static void clickElementByClassName(AndroidDriver<AndroidElement>driver,String className) {
		driver.findElementByClassName(className).click();
	}
	public void runApplication(String appPackage,String appActivy) throws IOException, InterruptedException {
		executeCommand("adb shell am start -n " + appPackage + "/" + appActivy + "\"" );
		System.out.println("Start AppPackage " + appPackage);
		System.out.println("Start AppActivity " + appActivy);
		Thread.sleep(5000);
	}


	public void executeCommand(String cmd) throws IOException {
		Process p = Runtime.getRuntime().exec(cmd);
		System.out.println("Command line : " + cmd);
	}

	public static AndroidElement scrollToAnElementByText(AndroidDriver<AndroidElement> driver, String text) throws InterruptedException {
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public static void scrollToAnElementAndClickByText(AndroidDriver<AndroidElement> driver, String text) throws InterruptedException {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));").click();;
	}

	public void dragAndDrop(WebElement drag, WebElement drop) {
		TouchAction action = new TouchAction(driver);
		action.longPress(element(drag))
		.moveTo(element(drop))
		.release()
		.perform();
	}
	
	public void swipe(WebElement from, WebElement to) {
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(from)).withDuration(ofSeconds(2))).moveTo(element(to)).release().perform();
	}


}
