package com.chikli.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class userActions {

        public static void numberAction(int input) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            if (input == 1){
                List<Flight> allFlights = Flight.getFlights();

                if (allFlights.size() == 0){
                    System.out.println("There are no flights in the flight list. Maybe try importing flights");
                }
                else{
                    Flight.printflights();
                }
            }
            else if (input == 2){

                Flight flight1 = new Flight("CAK", "CLE", "2019-05-01", "8:00 AM", "8:15 AM", 29.00, 100, 00001);
                Flight flight2 = new Flight("CMH", "MIA", "2019-05-01", "9:00 AM", "12:05 PM", 149.00, 150, 00002);
                Flight flight3 = new Flight("PIT", "TPA", "2019-05-01", "2:15 PM", "4:55 PM", 99.00, 100, 00003);
                Flight.addFlights(flight1);
                Flight.addFlights(flight2);
                Flight.addFlights(flight3);
                System.out.println("Flights successfully imported");
            }

            else if (input == 3){
                System.out.println("Please enter the flight departure city (ex. 'CAK'): ");
                String departCity = reader.readLine();
                System.out.println("Please enter the flight destination city (ex. 'CAK'): ");
                String arrivalCity = reader.readLine();
                System.out.println("Please enter the flight departure date (ex. '2019-05-01'): ");
                String departDate = reader.readLine();
                System.out.println("Please enter the flight departure time (ex. '4:00 AM'): ");
                String departTime = reader.readLine();
                System.out.println("Please enter the flight arrival time (ex. '5:00 AM'): ");
                String arrivalTime = reader.readLine();
                System.out.println("Please enter the flight price (ex. '120.00'): ");
                double price = Double.parseDouble(reader.readLine());
                System.out.println("Please enter the amount of people (ex. '40'): ");
                int numOfPeople = Integer.parseInt(reader.readLine());
                System.out.println("Please enter the flight number (ex. '00007'): ");
                int flightNumber = Integer.parseInt(reader.readLine());

                Flight userFlight = new Flight(departCity,arrivalCity,departDate,departTime,arrivalTime,price,numOfPeople,flightNumber);
                Flight.addFlights(userFlight);
                System.out.println("Flight successfully created");
            }

            else if (input == 4) {
                Flight.printflights();
                System.out.println();
                System.out.println("Please enter the index of the flight you would like to delete: ");
                int index = Integer.parseInt(reader.readLine());

                Flight.deleteFlights(index - 1);
            }

            else{
                System.out.println("Issue processing input: " + input);
            }

    }
}
