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

                for(int i = 0; i < allFlights.size(); i++){
                    System.out.println("Departure city: " + allFlights.get(i).getDepartureCity());
                }
            }

            else if (input == 2){
                System.out.println("Please enter the flight departure city (ex. 'CAK Akron, OH'): ");
                String departCity = reader.readLine();
                System.out.println("Please enter the flight destination city (ex. 'CAK Akron, OH'): ");
                String arrivalCity = reader.readLine();
                System.out.println("Please enter the flight departure date (ex. '05/01/2019'): ");
                String departDate = reader.readLine();
                System.out.println("Please enter the flight departure time (ex. '4:00 AM'): ");
                String departTime = reader.readLine();
                System.out.println("Please enter the flight arrival time (ex. '5:00 AM'): ");
                String arrivalTime = reader.readLine();
                System.out.println("Please enter the flight duration (ex. '1hr 00m'): ");
                String duration = reader.readLine();
                System.out.println("Please enter the flight price (ex. '120.00'): ");
                double price = Integer.parseInt(reader.readLine());
                System.out.println("Please enter the amount of people (ex. '40'): ");
                int numOfPeople = Integer.parseInt(reader.readLine());
                System.out.println("Please enter the flight number (ex. '00007'): ");
                int flightNumber = Integer.parseInt(reader.readLine());

                Flight userFlight = new Flight(departCity,arrivalCity,departDate,departTime,arrivalTime,duration,price,numOfPeople,flightNumber);
                Flight.addFlights(userFlight);
            }

            else{
                System.out.println("Issue processing input: " + input);
            }

    }
}
