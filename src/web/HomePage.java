package web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalConstants;

public class HomePage implements GlobalConstants{
	WebDriver driver;

	By loginLink = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[2]/a");
	By phoneLoginField = By.xpath("/html/body/div[3]/div[1]/div/div/form[1]/div[1]/input");
	By passwordLoginField = By.xpath("/html/body/div[3]/div[1]/div/div/form[1]/div[2]/input");
	By loginBtn = By.xpath("/html/body/div[3]/div[1]/div/div/form[1]/div[5]/div/button");
	By userName = By.xpath("//span[text()='"+NAME+"']");
//	By userMenu = By.xpath("//*[@id='user-menu']");
	By userMenu = By.cssSelector("#user-menu > a");
	By profileLink = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[3]/ul/li[1]/a");
	By container = By.xpath("/html/body/div[1]/header[2]/div/div/div/div[1]/nav/ul/li[3]/ul");
	
	

	public HomePage(WebDriver driver) {
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
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(userName));
		WebElement element = driver.findElement(userName);
		
		if(element.isDisplayed()){
			action.moveToElement(element).build().perform();
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(container));
			WebElement element1 = driver.findElement(container);
			if(element1.isDisplayed()){
				action.moveToElement(driver.findElement(profileLink)).click().build().perform();
			}
		}else{
			System.out.println("_____User name not visible______");
		}	
	}
	
	public void waitForUserName(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='user-menu']")));
	}
	
	public void displayMenu(WebElement element) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block'", element);
	}
	
}
