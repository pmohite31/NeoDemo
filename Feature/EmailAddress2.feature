#Author: Prashant Mohite

Feature: Email Adress

  @Story 
  
  Scenario: Email Validation and Submit email
  
   
    Given User is on launch screen
    When User taps Sign Up button
    Then User should be on EmailAddress screen
    
    When User enters invalid email address "test.com"
    And User taps Next Button
    Then User should get error message "Please enter a valid email address"
    
    
    When User enters valid email address "abc@test.com"
    And User taps Next Button
    Then User email should get saved
    
   
