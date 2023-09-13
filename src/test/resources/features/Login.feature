Feature: Login feature


  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email
    And I enter password
    And I submit
    Then I am logged in
