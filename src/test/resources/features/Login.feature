Feature: Login feature

  Background:
    Given I open Login Page

  Scenario: Successful login - Enter valid email and password
    When I enter email "alina.nikolaienko@testpro.io"
    And I enter password "OPJKDUhA"
    And I submit
    Then I am logged in

  Scenario: Unsuccessful login -  Enter incorrect password
    When I enter email "alina.nikolaienko@testpro.io"
    And I enter incorrect password "te1t9tudent"
    And I submit
    Then I am still on Login page