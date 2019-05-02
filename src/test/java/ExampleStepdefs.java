import com.chikli.demo.Flight;
import cucumber.api.java8.En;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleStepdefs implements En {

    private Example example;

    private Flight flight;

    List<Flight> testFlights = new ArrayList();
    Flight flight1 = new Flight("CAK", "CLE", "2019-05-01", "8:00 AM", "8:15 AM", 29.00, 100, 00001);
    Flight flight2 = new Flight("CMH", "MIA", "2019-05-01", "9:00 AM", "12:05 PM", 149.00, 150, 00002);
    Flight flight3 = new Flight("PIT", "TPA", "2019-05-01", "2:15 PM", "4:55 PM", 99.00, 100, 00003);


    public ExampleStepdefs() {

        After( () -> {
            testFlights.clear();
        });

        Given("flights are available", () -> {
            Flight.addFlights(flight1);
            Flight.addFlights(flight2);
            Flight.addFlights(flight3);
        });

        When("I search for flights", () -> {
            testFlights = Flight.getFlights();
        });

        Then("I see the available flights", () -> {
            assertThat(testFlights).containsExactly(flight1, flight2, flight3);
        });

        Given("I have no flights", () -> {
            assertThat(testFlights).isEmpty();
        });

        When("I add a flight", () -> {
            Flight.addFlights(flight1);
        });

        Then("A flight is added to the flight list", () -> {
            assertThat(Flight.getFlights()).containsExactly(flight1);
        });

    }
}
