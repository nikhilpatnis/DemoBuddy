package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPage {
	WebDriver driver;
	WebDriverWait wait;

	int monthVal = 0;
	int yearVal = 0;

	By loginLink = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[2]/a");
	By phoneLoginField = By.xpath("/html/body/div[3]/div[1]/div/div/form[1]/div[1]/input");
	By passwordLoginField = By.xpath("/html/body/div[3]/div[1]/div/div/form[1]/div[2]/input");
	By loginBtn = By.xpath("/html/body/div[3]/div[1]/div/div/form[1]/div[5]/div/button");
	By userName = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[3]/a/span");
	By profileLink = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[3]/ul/li[1]/a");
	By laterBtn = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[1]/div/div/div/a");
	By container = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[3]/ul");
	By startBtn = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[1]/div/div/div/button");

	By genderDropDown = By.xpath(
			"/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[1]/p[2]/select");
	
	By calender = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[1]/p[2]/input");
	
	By monthDropDown = By.xpath("/html/body/div[7]/div/div/select[1]");
	
	By monthValDD = By.xpath("/html/body/div[7]/div/div/select[1]/option["+monthVal+"]");
	
	By yearDropDown = By.xpath("/html/body/div[7]/div/div/select[2]");
	By yearValDD = By.xpath("/html/body/div[7]/div/div/select[2]/option["+yearVal+"]");
	
	By date = By.xpath("/html/body/div[7]/table/tbody/tr[3]/td[2]");
	
	By saveAndProceed1 = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/form/div[2]/button");
	

	public WebPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}

	public void login(String phone, String password) {
		setPhoneNumber(phone);
		setPassword(password);
		clickOnLogin();
	}

	public void setPhoneNumber(String phone) {
		driver.findElement(phoneLoginField).sendKeys(phone);
	}

	public void setPassword(String password) {
		driver.findElement(passwordLoginField).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginBtn).click();
	}

	public String getUserName() {
		return driver.findElement(userName).getText();
	}

	public void openProfilePage() {

		Actions action = new Actions(driver);
		WebElement w = driver.findElement(userName);

		wait = new WebDriverWait(driver, 5);

		action.moveToElement(w).click().build().perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(container));

		action.moveToElement(driver.findElement(profileLink)).click().build().perform();
		;
	}

	public void clickOnLaterButton() {
		driver.findElement(laterBtn).click();
	}

	public void clickOnStartButton() {
		driver.findElement(startBtn).click();
	}

	public void selectGender(String dropDownVal) {
		Select dropdown = new Select(driver.findElement(By.id("af_sex")));
		dropdown.selectByVisibleText(dropDownVal);
	}
	
	public void selectDOB(int month,int year){
		
		monthVal = month;
		yearVal = year;
		
		driver.findElement(calender).click();
		
		// these should be declared in separate methods
		Select monthList = new Select(driver.findElement(By.className("ui-datepicker-month")));
		monthList.selectByIndex(month);
		
		Select yearList = new Select(driver.findElement(By.className("ui-datepicker-year")));
		yearList.selectByIndex(year);
		
		driver.findElement(date).click();
	
	}
	
	public void proceedFirstBlock(){
		driver.findElement(saveAndProceed1).click();
	}
	
	
}
