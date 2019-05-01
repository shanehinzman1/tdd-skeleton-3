Feature: Search for flights
  Scenario: Search to see a flight
    Given flights are available
    When I search for flights
    Then I see the available flights