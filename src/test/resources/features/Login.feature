Feature: Login Feature
  Scenario: Login Success
    Given I open login page
    When I enter email "anna.dudnik@testpro.io"
    And I enter password "GulyalaKorova4milk!"
    And I click submit button
    Then I am logged in