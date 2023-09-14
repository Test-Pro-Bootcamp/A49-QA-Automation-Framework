Feature: Login feature

  Scenario: Login
    Given I open Login page
    When I enter email "alina.nikolaienko@testpro.io"
    And I enter password "OPJKDUhA"
    And I submit
    Then I am logged in
