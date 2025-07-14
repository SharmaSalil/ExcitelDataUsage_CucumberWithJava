Feature: Monthly Internet Usage Tracking

  As an Excitel user,
  I want to view my internet usage for a specific month
  So that I can monitor my data consumption effectively

  Scenario Outline: io: View and calculate internet usage for a selected month
    Given I log in to the Excitel portal with the following credentials
      | username   | password          |
      | 229988422   | TypeYourPassword  |
    When I navigate to the session usage page
    And I select "<month>" to retrieve usage details
    Then I should see the total internet usage calculated for that month
    Examples:
      | month    |
      | july 2025 |