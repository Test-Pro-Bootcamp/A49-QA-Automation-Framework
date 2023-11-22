Feature: Login feature

  Scenario Outline: Login Success
    Given I open Login page
    When I cast email <email>
    And I cast password <password>
    And I cast submit
    Then I am logged in
    Examples:
      | email             | password     |
      | "dirzo@gmail.com" | "Te$ter1234" |