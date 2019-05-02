import com.chikli.demo.Flight;
import com.chikli.demo.Main;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleMicroTest {

    @After
    public void cleanupFlights(){
        Flight.flights.clear();
    }

    @Test
    public void examplesWork() {
        Example example = new Example();

        assertThat(example.message()).isEqualTo("Hello");
    }

    @Test
    public void addFlight() {
        Flight flight1 = new Flight("CAK", "CLE", "2019-05-01", "8:00 AM", "8:15 AM", 29.00, 100, 00001);
        Flight.addFlights(flight1);

        assertThat(Flight.flights).containsExactly(flight1);
    }

    @Test
    public void deleteFlight() {
        Flight flight1 = new Flight("CAK", "CLE", "2019-05-01", "8:00 AM", "8:15 AM", 29.00, 100, 00001);
        Flight flight2 = new Flight("CMH", "MIA", "2019-05-01", "9:00 AM", "12:05 PM", 149.00, 150, 00002);
        Flight flight3 = new Flight("PIT", "TPA", "2019-05-01", "2:15 PM", "4:55 PM", 99.00, 100, 00003);
        Flight.addFlights(flight1);
        Flight.addFlights(flight2);
        Flight.addFlights(flight3);
        assertThat(Flight.deleteFlights(1)).isEqualTo("Flight successfully deleted");
        assertThat(Flight.flights).containsExactly(flight1,flight3);
    }

    @Test
    public void deleteFlightThatIsNotThere() {
        assertThat(Flight.deleteFlights(1)).isEqualTo("Error deleting flight");
    }

    @Test
    public void userSelectOneThenZero() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("1\n0\n"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Main.mainUserInput(reader, new PrintStream(outputStream));
        assertThat(outputStream.toString()).contains("Welcome");
    }

    @Test
    @Ignore
    public void noUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(""));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Main.mainUserInput(reader, new PrintStream(outputStream));
        assertThat(outputStream.toString()).contains("Welcome");
    }
}
