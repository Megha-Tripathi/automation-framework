package com.automationexercise.stepdefinitions;

//import static org.testng.AssertJUnit.assertTrue;
import static org.junit.Assert.assertTrue;
import com.automationexercise.hooks.Hooks;
import com.automationexercise.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginSteps {

	
	/*
	 * LoginSteps needs to use LoginPage
	 * This variable will hold a reference to the page object
	 */
	LoginPage loginpage;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() 
	{
		// Hooks.driver -> This is the same browser session which is already created in @Before hook
		// new LoginPage(Hooks.driver) -> Creating a LoginPage object and passing the browser into it
		loginpage = new LoginPage(Hooks.driver);  
		loginpage.navigateToLoginPage();
	}
	
	@When ("user enters email {string} and password {string}")
	public void user_enter_email_and_password(String email, String password) 
	{
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);	
		
	}
	
	/*@When ("user enters invalid email and password")
	public void user_enters_invalid_email_and_password() 
	{
		loginpage.enterEmail("invalid@test.com");
		loginpage.enterPassword("wrong123");
	}
	*/
	
	@Then ("clicks on login button")
	public void clicks_on_login_button() 
	{
		loginpage.clickLogin();
	}
	
	@Then("login result should be {string}")
	public void login_result_should_be(String result) 
	{
	    if(result.equalsIgnoreCase("success"))
	    {
	    	assertTrue("Expected login to succeed",loginpage.isLoginSuccessful());
	    }
	    else if(result.equalsIgnoreCase("failure"))
	    {
	    	assertTrue("Expected login to fail",loginpage.isErrorMessageDisplayed());
	    }
	}
	
	@Then("user should not be logged in successfully")
	public void user_should_not_be_logged_in_successfully()
	{
		//TODO
	}
	
	@Then ("error message should be displayed")
	public void error_message_should_be_displayed() 
	{
	
	}
	
}
