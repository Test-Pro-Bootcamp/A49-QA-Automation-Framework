Feature: Login Feature

  Background:
    Given I open Login Page

  Scenario: Login success
    Given I open Login Page
    When I enter email "svitlana.shkribliak@testpro.io"
    And I enter password "te$t$tudent49"
    And I click Submit
    Then I am logged in

  Scenario: Login incorrect password
    When I enter email "svitlana.shkribliak@testpro.io"
    And I enter incorrect password "incorrectPass"
    And I click Submit
    Then I still Login page

  Scenario: Login Not existing email
    When I enter Not existing email "svitlana@class.com"
    And I enter password "te$t$tudent49"
    And I click Submit
    Then I still Login page

  Scenario: Empty Login and Password
    When I enter Empty email " "
    And I enter Empty password " "
    And I click Submit
    Then I still Login page