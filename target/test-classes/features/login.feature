#Author: https://github.com/Megha-Tripathi

@tag
Feature: Login functionality for AutomationExcercise
  
  Background: 
  Given user navigates to login page

  @smoke
  Scenario Outline: Login with different credentials
    When user enters email "<email>" and password "<password>"
    And clicks on login button
    Then login result should be "<result>"
    
    Examples:
    |email|password|result|
    |wabebe6908@hudisk.com|test|success|
    |invalid@test.com|wrong123|fail|

  #@smoke
  #Scenario: Login with invalid credentials
    #When user enters invalid email and password
    #And clicks on login button
    #Then user should not be logged in successfully
    
 
