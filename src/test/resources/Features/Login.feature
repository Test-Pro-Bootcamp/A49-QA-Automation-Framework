Feature: Login feature

  Scenario: Login Success
    Given I open Login page
    When I enter email "dagebeyehu@gmail.com"
    And I enter password "yozca5uQiLxb!"
    And I submit
    Then I am logged in