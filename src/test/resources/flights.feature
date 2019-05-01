Feature: Flights
  Scenario: Search to see a flight
    Given flights are available
    When I search for flights
    Then I see the available flights

  Scenario: Add a flight
    Given I have no flights
    When I add a flight
    Then A flight is added to the flight list
