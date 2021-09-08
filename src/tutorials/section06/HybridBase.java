package tutorials.section06;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridBase {

	public static  AndroidDriver<AndroidElement> capabitities(String device) throws MalformedURLException {
		System.out.println("Start Emulator");
		
		AndroidDriver<AndroidElement> driver;
		DesiredCapabilities cap= new DesiredCapabilities();
		File appDir = new File("libs");
		File app = new File(appDir, "ApiDemos-debug.apk");
		if(device.equals("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		}else if(device.equals("real")){
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Real Device");
		}
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		System.out.println(app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
		
	}

	private static void elif() {
		// TODO Auto-generated method stub
		
	}

}
