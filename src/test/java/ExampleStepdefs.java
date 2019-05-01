import com.chikli.demo.Flight;
import cucumber.api.java8.En;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleStepdefs implements En {

    private Example example;

    private Flight flight;

    List<Flight> testFlights = new ArrayList();
    Flight flight1 = new Flight("CAK Akron, OH", "CLE Cleveland, OH", "05/01/2019", "8:00 AM", "8:15 AM", "0h 15m", 29.00);
    Flight flight2 = new Flight("CMH Columbus, OH", "MIA Miami, FL", "05/01/2019", "9:00 AM", "12:05 PM", "3h 15m", 149.00);
    Flight flight3 = new Flight("PIT Pittsburgh, PA", "TPA Tampa, FL", "05/01/2019", "2:15 PM", "4:55 PM", "2h 40m", 99.00);


    public ExampleStepdefs() {

        Given("flights are available", () -> {
            Flight.addFlights(flight1);
            Flight.addFlights(flight2);
            Flight.addFlights(flight3);
        });

        When("I search for flights", () -> {
            testFlights = Flight.getFlights();
        });

        Then("I see the available flights", () -> {
            assertThat(testFlights).contains(flight1);
            assertThat(testFlights).contains(flight2);
            assertThat(testFlights).contains(flight3);
        });
    }
}
