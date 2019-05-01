package com.chikli.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws IOException {
        Flight flight1 = new Flight("CAK Akron, OH", "CLE Cleveland, OH", "05/01/2019", "8:00 AM", "8:15 AM", "0h 15m", 29.00, 100, 00001);
        Flight flight2 = new Flight("CMH Columbus, OH", "MIA Miami, FL", "05/01/2019", "9:00 AM", "12:05 PM", "3h 15m", 149.00, 150, 00002);
        Flight flight3 = new Flight("PIT Pittsburgh, PA", "TPA Tampa, FL", "05/01/2019", "2:15 PM", "4:55 PM", "2h 40m", 99.00, 100, 00003);

        Flight.addFlights(flight1);
        Flight.addFlights(flight2);
        Flight.addFlights(flight3);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;

        System.out.println("Welcome to Debbie's Unbelievable Hellicopters com.chikli.demo.Flight Reservation Software");
        System.out.println("=========================================================================");
        System.out.println();

        while (run == true) {
            System.out.println();
            System.out.println("Please select an option");
            System.out.println("1. Show flights");
            System.out.println("0. Exit");

            int input = Integer.parseInt(reader.readLine());

            if (input == 0){
                run = false;
            }

            else if (input == 1){
                List<Flight> allFlights = Flight.getFlights();

                for(int i = 0; i < allFlights.size(); i++){
                    System.out.println("Departure city: " + allFlights.get(i).getDepartureCity());
                }
            }

            else{
                System.out.println("We good. Input is: " + input);
            }

        }
    }
}
