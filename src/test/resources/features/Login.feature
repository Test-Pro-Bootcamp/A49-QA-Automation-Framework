Feature: Login feature

  Scenario: Login Success
    Given I open Login page
    When I cast email "dirzo@gmail.com"
    And I cast password "Te$ter1234"
    And I cast submit
    Then I am logged in