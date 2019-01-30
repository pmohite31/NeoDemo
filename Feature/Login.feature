#Author: Prashant Mohite

Feature: Login

  @Smoke
  Scenario Outline: Verify that User is able to login
    Given User is on login screen
    When User enters "<username>" and "<passwordd>"
    Then User should be on ProductSummary Screen
   
  Examples:
    | username   | passwordd |
    | sara | password |
    | testuser_2456 | Test@153 |