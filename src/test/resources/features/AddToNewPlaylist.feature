Feature: Add Song to New Playlist

  Scenario: Add Song to new playlist
    Given I have entered the portal
    When I search for the song BossStatus
    And I view all the songs with BossStatus
    And I select BossStatus
    And I click add to...
    Then I create a new Playlist

