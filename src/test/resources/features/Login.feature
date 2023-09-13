Feature: Login feature
  Scenario: Login success
    Given I open Login page
    When I enter email "gia.mitchell@testpro.io"
    And I enter password "Lovenoelle25"
    And I submit
    Then I am logged in
