package tutorial.excercies;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static  AndroidDriver<AndroidElement> capabitities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = null;
		try {
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, Constant.DEVICE_NAME);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constant.AUTOMATION_NAME);//new step
			driver = new AndroidDriver<>(new URL(Constant.URL_SERVER), cap);
			System.out.println("Init Appium Server Succesfully!!");
			return driver;
		}
		catch(Exception e) {
			System.out.println("Exception : " + e.getMessage());
			System.exit(0);
		}
		return driver;
	
		
	}

}
