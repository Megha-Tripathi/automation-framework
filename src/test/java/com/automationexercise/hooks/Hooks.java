package com.automationexercise.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	
	public static WebDriver driver;
	
	/*
	 * Runs before each scenario
	 * Browser starts here
	 * Fresh session per test 
	 * A new browser instance is created
	 * Clean session (no cookies, no login state)
	 */
	@Before
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");     // CI compatible
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	/*
	 * Runs after each scenario
	 * Browser closes
	 * Prevents memory leaks
	 */
	@After
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
}
