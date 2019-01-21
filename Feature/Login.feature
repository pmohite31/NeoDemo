#Author: Prashant Mohite

Feature: Login

  @Smoke
  Scenario: Login Successfully
    Given I launch app
    When I enter correct credentials
    Then I should be on ProductSummary Screen
    Then I close the app
