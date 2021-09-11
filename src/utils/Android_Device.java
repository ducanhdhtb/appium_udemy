package utils;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import tutorial.excercies.Base;
import tutorial.excercies.Constant;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Android_Device extends Base{

	public static AndroidDriver<AndroidElement> driver;
	public final int timeOut = 40;
	
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

	/**
	 * method verify whether element is present on screen
	 *
	 * @param targetElement element to be present
	 * @return true if element is present else throws exception
	 * @throws InterruptedException Thrown when a thread is waiting, sleeping,
	 *                              or otherwise occupied, and the thread is interrupted, either before
	 *                              or during the activity.
	 */
	public Boolean isElementPresent(By targetElement) throws InterruptedException {
		Boolean isPresent = driver.findElements(targetElement).size() > 0;
		return isPresent;
	}

	public void hideKeyBoard() {
		driver.hideKeyboard();
		System.out.println("Hide KeyBoard");
	}

	/**
	 * method to go back by Android Native back click
	 */
	
	public void back() {
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	/**
	 * method to wait for an element to be visible
	 *
	 * @param targetElement element to be visible
	 * @return true if element is visible else throws TimeoutException
	 */
	public boolean waitForVisibility(By targetElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			throw e;

		}
	}

	  /**
     * method to tap on the screen on provided coordinates
     *
     * @param xPosition x coordinate to be tapped
     * @param yPosition y coordinate to be tapped
     */
    public void tap(double xPosition, double yPosition) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        js.executeScript("mobile: tap", tapObject);
    }
    
    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public WebElement findElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element;
        } catch (NoSuchElementException e) {
//            Log.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }
    }

    
    /**
     * method to find all the elements of specific locator
     *
     * @param locator element to be found
     * @return return the list of elements if found else throws NoSuchElementException
     */
    public List<AndroidElement> findElements(By locator) {
        try {
            List<AndroidElement> element = driver.findElements(locator);
            return element;
        } catch (NoSuchElementException e) {
//            Log.logError(this.getClass().getName(), "findElements", "element not found" + locator);
            throw e;
        }
    }

    
    /**
     * method to get message test of alert
     *
     * @return message text which is displayed
     */
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }

    /**
     * method to verify if alert is present
     *
     * @return returns true if alert is present else false
     */
    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }
    
    /**
     * method to click element by Xpath
     * @param xPath
     */
	public void clickByXpath(String xPath) {
		if(waitForElementByXpath(xPath)) {
			AndroidElement ele = driver.findElement(By.xpath(xPath));
			System.out.println(ele);
			System.out.println("Click : " + xPath + " Successfully!");
			ele.click();
		}else {
			System.out.println("Can't get element " + xPath);
			System.exit(0);
		}
	}
	
    /**
     * method to Accept Alert if alert is present
     */

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    
    /**
     * method to Dismiss Alert if alert is present
     */

    public void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }
    
    
    /**
     * method to get network settings
     */
    public void getNetworkConnection() {
        System.out.println(((AndroidDriver) driver).getConnection());
    }
    

    /**
     * method to set network settings
     *
     * @param airplaneMode pass true to activate airplane mode else false
     * @param wifi         pass true to activate wifi mode else false
     * @param data         pass true to activate data mode else false
     */
    public void setNetworkConnection(boolean airplaneMode, boolean wifi, boolean data) {

        long mode = 1L;

        if (wifi) {
            mode = 2L;
        } else if (data) {
            mode = 4L;
        }

        ConnectionState connectionState = new ConnectionState(mode);
        ((AndroidDriver) driver).setConnection(connectionState);
        System.out.println("Your current connection settings are :" + ((AndroidDriver) driver).getConnection());
    }

    
    /**
     * method to get all the context handles at particular screen
     */
    public void getContext() {
        ((AppiumDriver) driver).getContextHandles();
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {

        Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();

        if (contextNames.contains(context)) {
            ((AppiumDriver) driver).context(context);
            System.out.println("Context changed successfully");
        } else {
        	System.out.println(context + "not found on this page");
        }

        System.out.println("Current context" + ((AppiumDriver) driver).getContext());
    }


    /**
     * method to long press on specific element by passing locator
     *
     * @param locator element to be long pressed
     */
    public void longPress(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touch = new TouchAction((MobileDriver) driver);
            LongPressOptions longPressOptions = new LongPressOptions();
            longPressOptions.withElement(ElementOption.element(element));
            touch.longPress(longPressOptions).release().perform();
            System.out.println("Long press successful on element: " + element);
        } catch (NoSuchElementException e) {
//        	System.out.println(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }

    }
    
    /**
     * method to long press on specific x,y coordinates
     *
     * @param x x offset
     * @param y y offset
     */
    public void longPress(int x, int y) {
        TouchAction touch = new TouchAction((MobileDriver) driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(x, y);
        touch.longPress(pointOption).release().perform();
        System.out.println("Long press successful on coordinates: " + "( " + x + "," + y + " )");
    }
    
    /**
     * method to long press on element with absolute coordinates.
     *
     * @param locator element to be long pressed
     * @param x       x offset
     * @param y       y offset
     */
    public void longPress(By locator, int x, int y) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touch = new TouchAction((MobileDriver) driver);
            LongPressOptions longPressOptions = new LongPressOptions();
            longPressOptions.withPosition(new PointOption().withCoordinates(x, y)).withElement(ElementOption.element(element));
            touch.longPress(longPressOptions).release().perform();
            System.out.println("Long press successful on element: " + element + "on coordinates" + "( " + x + "," + y + " )");
        } catch (NoSuchElementException e) {
//            Log.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }

    }
    
    /**
     * method to swipe on the screen on provided coordinates
     *
     * @param startX   - start X coordinate to be tapped
     * @param endX     - end X coordinate to be tapped
     * @param startY   - start y coordinate to be tapped
     * @param endY     - end Y coordinate to be tapped
     * @param duration duration to be tapped
     */

    public void swipe(double startX, double startY, double endX, double endY, double duration) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        // swipeObject.put("touchCount", 1.0);
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", duration);
        js.executeScript("mobile: swipe", swipeObject);
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

	/**
	 * Method to Click Element
	 * @param attribute : attribute of Element
	 * @param value : value of Element
	 */
	public void clickElement(String attribute ,String value) {
		String formatted = String.format("//*[@%s = '%s']", attribute,value);
		driver.findElement(By.xpath(formatted)).click();

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
	/**
	 * method to wait elemnt for xpath 
	 */
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
			System.out.println("Exception : " + e.getMessage());
			return isElementPresent;
		}
	}

	/**
	 * method to click on Element By Name
	 *
	 * @param elementByName - String element name to be clicked
	 */

	public void click(String elementByName) {
		((AppiumDriver) driver).findElementByName(elementByName).click();
	}

	/**
	 * method to scroll down on screen from java-client 6
	 *
	 * @param swipeTimes       number of times swipe operation should work
	 * @param durationForSwipe time duration of a swipe operation
	 */
	public void scrollDown(int swipeTimes, int durationForSwipe) {
		Dimension dimension = driver.manage().window().getSize();
		System.out.println("demension:" + dimension);

		for (int i = 0; i <= swipeTimes; i++) {
			int start = (int) (dimension.getHeight() * 0.5);
			int end = (int) (dimension.getHeight() * 0.3);
			int x = (int) (dimension.getWidth() * .5);


			new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
			.release().perform();
		}
	}


	/**
	 * method to swipe on the screen on provided coordinates
	 *
	 * @param startX   - start X coordinate to be tapped
	 * @param endX     - end X coordinate to be tapped
	 * @param startY   - start y coordinate to be tapped
	 * @param endY     - end Y coordinate to be tapped
	 * @param duration duration to be tapped
	 */

	public void swipe_generic(double startX, double startY, double endX, double endY, double duration) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		// swipeObject.put("touchCount", 1.0);
		swipeObject.put("startX", startX);
		swipeObject.put("startY", startY);
		swipeObject.put("endX", endX);
		swipeObject.put("endY", endY);
		swipeObject.put("duration", duration);
		js.executeScript("mobile: swipe", swipeObject);
	}

	static String UiScrollable(String uiSelector) {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ".instance(0));";
    }

	/**
	 * method to launchApp
	 */
	public void launchApp() {
		((AppiumDriver) driver).launchApp();
	}


	/**
	 * method to scroll up on screen from java-client 6
	 *
	 * @param swipeTimes       number of times swipe operation should work
	 * @param durationForSwipe time duration of a swipe operation
	 */
	public void scrollUp(int swipeTimes, int durationForSwipe) {
		Dimension dimension = driver.manage().window().getSize();

		for (int i = 0; i <= swipeTimes; i++) {
			int start = (int) (dimension.getHeight() * 0.3);
			int end = (int) (dimension.getHeight() * 0.5);
			int x = (int) (dimension.getWidth() * .5);


			new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
			.release().perform();
		}
	}



	/**
	 * method to open notifications on Android
	 */
	public void openNotifications() {
		((AndroidDriver) driver).openNotifications();
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
		Thread.sleep(7000);
	}

	public void runApplicationByMonkeyTools(String appPackage) throws IOException, InterruptedException {
		executeCommand("adb shell monkey -p " +  appPackage + " -c android.intent.category.LAUNCHER 1");
		Thread.sleep(7000);
	}

	public void executeCommand(String cmd) throws IOException {
		Process p = Runtime.getRuntime().exec(cmd);
		System.out.println("Command line : " + cmd);
	}

	public static AndroidElement scrollToAnElementByText(AndroidDriver<AndroidElement> driver, String text) throws InterruptedException {
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public static void scrollToAnElementAndClickByText(String text) throws InterruptedException {
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
