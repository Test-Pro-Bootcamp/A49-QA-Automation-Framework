Feature: Login Feature

  Scenario: Login success
    Given I open Login Page
    When I enter email "svitlana.shkribliak@testpro.io"
    And I enter password "te$t$tudent49"
    And I click Submit
    Then I am logged in