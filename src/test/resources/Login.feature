Feature: Login feature

  Scenario: Login
    Given I open Login page
    When I enter email "pchelka240386@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in