package com.automationexercise.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	
	/*
	 * Same driver must be used across all methods
	 * Keeps browser session consistent
	 * This is composition, not inheritance
	 */
	WebDriver driver;  
	WebDriverWait wait;   //Added WebDriverWait variable with name 'wait'
	
	
	//Locators
	By emailField = By.xpath("//input[@data-qa='login-email']");
	By passwordField = By.xpath("//input[@placeholder='Password']");
	By loginButton = By.xpath("//button[@data-qa='login-button']");
	By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
	By errorMessage = By.xpath("//form[@action='/login']//p");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		/*
		 * This means,Driver is created elsewhere (Hooks)
		 * Driver is passed into the page
		 * Page does NOT decide how browser is created
		 * This is dependency injection
		 */
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //Wait up to 10 seconds until condition is satisfied
	}
	
	public void navigateToLoginPage() 
	{
		/*
		 * driver is WebDriver instance passed through constructor
		 * .get() → Selenium command to open a URL
		 * Because opening the login page is a page action and Step definitions should not know URLs
		 */
		driver.get("https://automationexercise.com/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
	}
	
	public void enterEmail(String email) 
	{
		driver.findElement(emailField).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
	}
	
	public void enterPassword(String password) 
	{
		driver.findElement(passwordField).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
	}
	
	public void clickLogin()
	{
		WebElement loginBtn = wait.until(
		        ExpectedConditions.presenceOfElementLocated(loginButton)
		    );

		    wait.until(ExpectedConditions.visibilityOf(loginBtn));

		    // Scroll into view (important)
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView(true);", loginBtn
		    );

		    // JS click (most reliable)
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].click();", loginBtn
		    );
		/*
		 * Because below code is throwing error on Standard click as 'org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //button[@data-qa='login-button'] (tried for 10 second(s) with 500 milliseconds interval)
		 * ❌ Do NOT use JS click everywhere
		 * 
		 * 
		 * uncomment below code to run without JS:
		 * driver.findElement(loginButton).click();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		 * driver.findElement(loginButton).click();
		*/
	}
	
	public boolean isLoginSuccessful() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInText))
	               .isDisplayed();
	}
	
	public boolean isErrorMessageDisplayed()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
	               .isDisplayed();
	}
	
}
