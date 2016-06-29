package web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalConstants;

public class ProfilePage implements GlobalConstants {

	WebDriver driver;
	String winHandleBefore;

	int monthVal = 0;
	int yearVal = 0;

	By startBtn = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[1]/div/div/div/button");
	By laterBtn = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[1]/div/div/div/a");

	// Section : who are you
	By whoAreYouSection = By.xpath("//*[@id='heading-ac1']");
	By userName = By.xpath("//*[@id='af_name']");
	By genderDropDown = By.xpath(
			"/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[1]/p[2]/select");
	By calender = By.xpath(
			"/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[1]/p[2]/input");
	By monthDropDown = By.xpath("/html/body/div[7]/div/div/select[1]");
	By monthPicker = By.className("ui-datepicker-month");
	By yearPicker = By.className("ui-datepicker-year");
	By date = By.xpath("/html/body/div[7]/table/tbody/tr[3]/td[2]");
	By saveAndProceed1 = By.xpath(
			"/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[2]/button");
	By populatedIcon = By.xpath("//*[@id='heading-ac1']/a/i[1]");

	// Section : Where are you studying
	By collegeNameField = By.xpath("//*[@id='af_course']");
	By universityField = By.xpath("//*[@id='af_college']");
	By collegeEndDateField = By.xpath("//*[@id='af_date']");
	By annualFeeDropDown = By.xpath("//*[@id='af_fees']");
	By hasScollershipDropDown = By.xpath("//*[@id='af_scholarship']");
	By previousInSec2Btn = By.xpath("//*[@id='previous-button-ac2']");
	By saveAndProceed2 = By.xpath("//*[@id='next-button-ac2']");
	// if receives scholarship these field will be visible
	By typeOfScholarshipDropDown = By.xpath("//*[@id='af_scholarship_program']");
	By receiveMoneyField = By.xpath("//*[@id='af_scholarship_amount']");

	// Section : a few more details about you
	By gpaTypeDropDown = By.xpath("//*[@id='af_gpatype']");
	By gpaField = By.xpath("//*[@id='af_gpa']");
	By spendingDropDown = By.xpath("//*[@id='af_spending']");
	By studentLoanDropDown = By.xpath("//*[@id='af_loan']");
	By panAdharDD = By.xpath("//*[@id='af_pan_aadhar']");
	By cardNumberField = By.xpath("//*[@id='af_pan']");
	By previousInSec3 = By.xpath("//*[@id='previous-button-ac3']");
	By saveAndProceed3 = By.xpath("//*[@id='next-button-ac3']");

	// Section : where do you stay
	By currentStayDD = By.xpath("//*[@id='af_stay']");
	By addressCurrentDD = By.xpath("//*[@id='af_paddress']");
	By addressPermanentDD = By.xpath("//*[@id='af_taddress1']");
	By vehicalDD = By.xpath("//*[@id='af_vehicle']");
	By saveAndProceed4 = By.xpath("//*[@id='next-button-ac4']");
	By previousInSec4 = By.xpath("//*[@id='previous-button-ac4']");

	// Section : details about your family
	By familyMemberDD = By.xpath("//*[@id='af_familymem']");
	By familyJobDD = By.xpath("//*[@id='af_familyjob']");
	By familyPostField = By.xpath("//*[@id='af_familypost']");
	By familyPhoneField = By.xpath("//*[@id='af_familyphone']");
	By previousInSec5 = By.xpath("//*[@id='previous-button-ac5']");
	By saveAndProceed5 = By.xpath("//*[@id='next-button-ac5']");

	// Section : how well are you connected
	By facebookBtn = By.xpath("//*[@id='link-facebook']");
	By userNameFB = By.xpath("//*[@id='email']");
	By passwordFB = By.xpath("//*[@id='pass']");
	By loginSubmitBtn = By.xpath("//*[@id='u_0_2']");
	By previousInSec6 = By.xpath("//*[@id='previous-button-ac5']");
	By saveAndSubmit6 = By.xpath("//*[@id='next-button-ac5']");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLaterButton() {
		driver.findElement(laterBtn).click();
	}

	public void clickOnStartButton() {
		driver.findElement(startBtn).click();
	}

	// Section 1
	public void enterName(String name) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(userName));
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(name);
	}

	public void selectGender(String dropDownVal) {
		Select dropdown = new Select(driver.findElement(By.id("af_sex")));
		dropdown.selectByVisibleText(dropDownVal);
	}

	public void selectDOB(int month, int year) {

		monthVal = month;
		yearVal = year;

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(calender));
		driver.findElement(calender).click();

		// these should be declared in separate methods
		Select monthList = new Select(driver.findElement(monthPicker));
		monthList.selectByIndex(month);

		Select yearList = new Select(driver.findElement(yearPicker));
		yearList.selectByIndex(year);

		driver.findElement(date).click();
	}

	public void openSection1() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(whoAreYouSection));
		driver.findElement(whoAreYouSection).click();
	}

	public void proceedSection1() {
		driver.findElement(saveAndProceed1).click();
	}

	public void proceedSection2() {
		driver.findElement(saveAndProceed2).click();
	}

	public void proceedSection3() {
		driver.findElement(saveAndProceed3).click();
	}

	public void proceedSection4() {
		driver.findElement(saveAndProceed4).click();
	}

	public void proceedSection5() {
		driver.findElement(saveAndProceed5).click();
	}

	public void proceedAndSubmit6() {
		driver.findElement(saveAndSubmit6).click();
	}

	public void previousToSec1() {
		driver.findElement(previousInSec2Btn);
	}

	public void previoustoSec2() {
		driver.findElement(previousInSec3);
	}

	public void previoustoSec3() {
		driver.findElement(previousInSec4);
	}

	public void previoustoSec4() {
		driver.findElement(previousInSec5);
	}

	public void previoustoSec5() {
		driver.findElement(previousInSec6);
	}

	// Section 2
	public void selectCollegeName(String college) {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(collegeNameField));

		driver.findElement(collegeNameField).clear();
		driver.findElement(collegeNameField).sendKeys(college);

		// List<WebElement> optionsToSelect =
		// driver.findElements(collegeNameField);
		//
		// for(WebElement option : optionsToSelect){
		// System.out.println(option.getText());
		// if(option.getText().contains(college)) {
		// option.click();
		// break;
		// }
		// }
	}

	public void selectUniversity(String university) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(universityField));
		driver.findElement(universityField).clear();
		driver.findElement(universityField).sendKeys(university);
	}

	public void collegeEndDate(int mm, int yyyy) {
		driver.findElement(collegeEndDateField).clear();
		driver.findElement(collegeEndDateField).sendKeys(mm + "-" + yyyy);
	}

	public void selectAnnualFee(int val) {
		Select list = new Select(driver.findElement(annualFeeDropDown));
		list.selectByIndex(val);
	}

	public void havingScholarship(boolean isHaving) {
		Select list = new Select(driver.findElement(hasScollershipDropDown));

		if (isHaving) {
			list.selectByVisibleText("do");
		} else {
			list.selectByVisibleText("don't");
		}
	}

	public void selectTypeOfScholarship(int type) {
		Select list = new Select(driver.findElement(typeOfScholarshipDropDown));
		list.selectByIndex(type);
	}

	public void enterAnnualreceived(int rupee) {
		driver.findElement(receiveMoneyField).sendKeys("" + rupee);
	}

	// Section 3
	public void gpaType(String gpatype) {
		Select list = new Select(driver.findElement(gpaTypeDropDown));
		list.selectByVisibleText(gpatype);
	}

	public void gpa(String percentage) {
		driver.findElement(gpaField).clear();
		driver.findElement(gpaField).sendKeys(percentage);
	}

	public void spending(String spending) {
		Select list = new Select(driver.findElement(spendingDropDown));
		list.selectByVisibleText(spending);
	}

	public void selectIsTakenLoanBefore(boolean b) {
		Select list = new Select(driver.findElement(studentLoanDropDown));
		if (b) {
			list.selectByVisibleText(HAVE);
		} else {
			list.selectByVisibleText(HAVE_NOT);
		}
	}

	public void selectID(String id) {
		Select list = new Select(driver.findElement(panAdharDD));
		list.selectByVisibleText(id);
	}

	public void enterIdNumber(String cardNumber) {
		driver.findElement(cardNumberField).clear();
		driver.findElement(cardNumberField).sendKeys(cardNumber);
	}

	// Sectoin 4
	public void enterCurrentlyStayingWith(String s) {
		Select list = new Select(driver.findElement(currentStayDD));
		list.selectByVisibleText(s);
	}

	public void enterCurrentAddress() {
		driver.findElement(addressCurrentDD).clear();
		driver.findElement(addressCurrentDD).sendKeys("silk board");
	}

	public void enterPermanentAddress() {
		driver.findElement(addressPermanentDD).clear();
		driver.findElement(addressPermanentDD).sendKeys("Indore");
	}

	public void doOwnVehicle(boolean b) {
		Select list = new Select(driver.findElement(vehicalDD));
		if (b) {
			list.selectByVisibleText(HAVE_VEHICLE);
		} else {
			list.selectByVisibleText(DO_NOT_HAVE_VEHICLE);
		}
	}

	// Section 5
	public void selectFamilyMember(String member) {
		Select list = new Select(driver.findElement(familyMemberDD));
		list.selectByVisibleText(member);
	}

	public void selectFamilyJob(String jobtype) {
		Select list = new Select(driver.findElement(familyJobDD));
		list.selectByVisibleText(jobtype);
	}

	public void enterFamilyPost(String post) {
		driver.findElement(familyPostField).clear();
		driver.findElement(familyPostField).sendKeys(post);
	}

	public void enterFamilyPhone(String phone) {
		driver.findElement(familyPhoneField).clear();
		driver.findElement(familyPhoneField).sendKeys(phone);
	}

	// Section 6
	public void clickOnConnectFB() {
		driver.findElement(facebookBtn).click();
	}

	public void moveToTheTopWindow() {
		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void moveToTheMainWindow() {
		if (winHandleBefore != null) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
		}
	}

	public void loginToFacebook(String usernm, String pass) {
		setUsernameFb(usernm);
		setPasswordFb(pass);
		clickSubmitBtn();
	}

	private void setUsernameFb(String username) {
		driver.findElement(userNameFB).sendKeys(username);
	}

	private void setPasswordFb(String password) {
		driver.findElement(passwordFB).sendKeys(password);
	}

	public void clickSubmitBtn() {
		driver.findElement(loginSubmitBtn).click();
	}

	public void enterClassMateName() {
		driver.findElement(By.xpath("//*[@id='af_friend_name']")).sendKeys(NAME);
	}

	public void enterClassMatePhone() {
		driver.findElement(By.xpath("//*[@id='af_friend_number']")).sendKeys(FAMILY_PHONE);
	}
	
	public void cancleFbLogin(){
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='u_0_3']")));
		driver.findElement(By.xpath("//*[@id='u_0_3']"));
	}
}
