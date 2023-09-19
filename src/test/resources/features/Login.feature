Feature: Login Feature

  Scenario: Login success
    Given I open Login
    When I enter email "emiliano.castillo@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I aam logged in