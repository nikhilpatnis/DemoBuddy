package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalConstants;
import web.HomePage;
import web.ProfilePage;

public class DemoTest implements GlobalConstants {

	WebDriver driver;
	Properties obj;

	@BeforeClass
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

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver(capability);
		driver.manage().window().maximize();
		driver.get(HOME_URL);

		// FirefoxProfile profile = new FirefoxProfile();
		// profile.setPreference("xpinstall.signatures.required", false);
		// profile.setPreference("startup.homepage_welcome_url", "about:blank");
		//// profile.setPreference("browser.startup.homepage",HOME_URL);
		//
		// driver = new FirefoxDriver(profile);
		// driver.manage().window().maximize();
		// driver.get(HOME_URL);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeFireFox() {
		// driver.quit();
//		driver.get("\\test-output\\index.html");
	}

	@Test(description = "simple login")
	public void LoginTest() {

		HomePage homepage = new HomePage(driver);
		homepage.clickLoginLink();
		homepage.login(obj.getProperty("phone"), obj.getProperty("pass"));

	}

	@Test (description = "Open profile page")
	public void OpenProfilePage() {

		HomePage homepage = new HomePage(driver);
		try {
			homepage.waitForUserName();
			homepage.openProfilePage();

		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}
	
	@Test (description = "who are you?")
	public void fillSection1(){
		ProfilePage profilePage = new ProfilePage(driver);

		// this method should be called dynamically because its visibility is dependent
		// profilePage.clickOnStartButton();

		profilePage.openSection1();
		
		// Section 1
		profilePage.enterName(NAME);
		profilePage.selectGender(GUY);
		profilePage.selectDOB(MAY, SUN_1990);
		profilePage.proceedSection1();
	}
	
	@Test (description = "where are you studying?")
	public void fillSection2(){
		ProfilePage profilePage = new ProfilePage(driver);
		
		// Section 2
		profilePage.selectCollegeName("pre");
		profilePage.selectUniversity("rgpv");
		profilePage.collegeEndDate(10, 2017);
		profilePage.selectAnnualFee(from_25_to_50);
		profilePage.havingScholarship(true);
		profilePage.selectTypeOfScholarship(MERIT_TYPE);
		profilePage.enterAnnualreceived(1000);
		profilePage.proceedSection2();
	}
	
	@Test (description = "A few more details about you")
	public void fillSection3(){
		ProfilePage profilePage = new ProfilePage(driver);
		
		// Section 3
		profilePage.gpaType(GPA_OUT_OF_5);
		profilePage.gpa(GPA);
		profilePage.selectIsTakenLoanBefore(true);
		profilePage.selectID(PAN);
		profilePage.enterIdNumber(CARD_NUMBER);
		profilePage.proceedSection3();
		
	}
	@Test (description = "Where do you stay")
			
	public void fillSection4(){
		ProfilePage profilePage = new ProfilePage(driver);
		
		// Section 4
		profilePage.enterCurrentlyStayingWith(STAYING_IN_CLG);
		profilePage.enterCurrentAddress();// static
		profilePage.enterPermanentAddress();// static
		profilePage.doOwnVehicle(true);
		profilePage.proceedSection4();
		
	}
	
	@Test (description = "Details about your family")
	public void fillSection5(){
		ProfilePage profilePage = new ProfilePage(driver);
		
		// Section 5
		profilePage.selectFamilyMember(FAMILY_FATHER);
		profilePage.selectFamilyJob(FAMILY_JOB_GOV_EMP);
		profilePage.enterFamilyPost(FAMILY_POST);
		profilePage.enterFamilyPhone(FAMILY_PHONE);
		profilePage.proceedSection5();
		
	}
	
	@Test (description = "How well are you connected")
	public void fillSection6(){
		ProfilePage profilePage = new ProfilePage(driver);
		
		// Section 6
		profilePage.clickOnConnectFB();
		
		profilePage.moveToTheTopWindow();
		
		profilePage.loginToFacebook(obj.getProperty("fb_username"), obj.getProperty("fb_password"));
		profilePage.cancleFbLogin();
		
		profilePage.moveToTheMainWindow();
		
		profilePage.enterClassMateName();
		profilePage.enterClassMatePhone();
		
		profilePage.proceedAndSubmit6();
		
	}
	
}
