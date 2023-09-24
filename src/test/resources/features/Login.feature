
Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login page
    When I enter email "eric.stetson@testpro.io"
    And I enter password "Testpro@2023"
    And I submit
    Then I am logged in
