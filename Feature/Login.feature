#Author: Prashant Mohite

Feature: Login

  @Smoke
  Scenario Outline: Login Successfully
    Given User is on login screen
    When User enters "<username>" and "<passwordd>"
    Then User should be on ProductSummary Screen
    And User closes the app
  Examples:
    | username   | passwordd |
    | sara | password |
    | testuser_2 | Test@153 |