import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;;

public class AppiumTest {

	AppiumDriver<WebElement> driver;

	@BeforeClass
	public void setUp() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apk");
		File app = new File(appDir, "app-release.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "CQZ5ZSPRSG49CQ4H");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "indwin.c3.shareapp");
		capabilities.setCapability("appActivity", ".MainActivity");
		capabilities.setCapability("appWaitActivity", ".MainActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void test1() {
		driver.findElement(By.className("android.widget.ImageButton")).click();
	}
}
