package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalConstants;
import web.WebPage;

public class DemoTest implements GlobalConstants {

	WebDriver driver;
	Properties obj;

	@BeforeTest
	public void openFireFox() {

		obj = new Properties();

		FileInputStream objfile;

		try {
			objfile = new FileInputStream(System.getProperty("user.dir") + PROPERTIES_FILE_PATH);
			obj.load(objfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(HOME_URL);
	}

	@AfterTest
	public void closeFireFox() {
		// driver.quit();
	}

	@Test(description = "simple login")
	public void LoginTest() {

		WebPage demoTest = new WebPage(driver);
		demoTest.clickLoginLink();
		demoTest.login(obj.getProperty("phone"), obj.getProperty("pass"));

		// Assert.assertEquals(demoTest.getUserName(), "Nikhil");
	}

	@Test
	public void OpenAndEditProfilePage() {

		WebPage demoTest = new WebPage(driver);
		demoTest.openProfilePage();
		demoTest.clickOnStartButton();
		demoTest.selectGender(GUY);
		demoTest.selectDOB(MAY,SUN_1990);
		demoTest.proceedFirstBlock();
		
	}
}
