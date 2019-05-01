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
                    System.out.println("Index Number: " + (i + 1));
                    System.out.println("Departure City: " + allFlights.get(i).getDepartureCity());
                    System.out.println("Arrival City: " + allFlights.get(i).getArrivalCity());
                    System.out.println("Departure Date: " + allFlights.get(i).getDepartDate());
                    System.out.println("Departure Time: " + allFlights.get(i).getDepartTime());
                    System.out.println("Arrival Time: " + allFlights.get(i).getArrivalTime());
                    System.out.println("Duration Time: " + allFlights.get(i).getDuration());
                    System.out.println("Price: " + allFlights.get(i).getPrice());
                    System.out.println("Number Of People: " + allFlights.get(i).getNumOfPeople());
                    System.out.println("Flight Number: " + allFlights.get(i).getFlightNumber());
                    System.out.println();
                }
            }
            else if (input == 2){

                Flight flight1 = new Flight("CAK Akron, OH", "CLE Cleveland, OH", "05/01/2019", "8:00 AM", "8:15 AM", "0h 15m", 29.00, 100, 00001);
                Flight flight2 = new Flight("CMH Columbus, OH", "MIA Miami, FL", "05/01/2019", "9:00 AM", "12:05 PM", "3h 15m", 149.00, 150, 00002);
                Flight flight3 = new Flight("PIT Pittsburgh, PA", "TPA Tampa, FL", "05/01/2019", "2:15 PM", "4:55 PM", "2h 40m", 99.00, 100, 00003);
                Flight.addFlights(flight1);
                Flight.addFlights(flight2);
                Flight.addFlights(flight3);
                System.out.println("Flights successfully imported");
            }

            else if (input == 3){
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
                System.out.println("Flight successfully created");
            }
            else{
                System.out.println("Issue processing input: " + input);
            }

    }
}
