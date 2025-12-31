#Author: https://github.com/Megha-Tripathi

@tag
Feature: Login functionality for AutomationExcercise
  
  Background: 
  Given user navigates to login page

  @smoke
  Scenario: Login with valid credentials
    When user enters valid email and password
    And clicks on login button
    Then user should be logged in successfully

  @smoke
  Scenario: Login with invalid credentials
    When user enters invalid email and password
    And clicks on login button
    Then user should not be logged in successfully
    
 
