package com.chikli.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;

        System.out.println("Welcome to Debbie's Unbelievable Hellicopters Flight Reservation Software");
        System.out.println("=========================================================================");
        System.out.println();

        while (run == true) {
            System.out.println();
            System.out.println("Please select an option");
            System.out.println("1. Show flights");
            System.out.println("2. Import flight data");
            System.out.println("3. Add a flight");
            System.out.println("0. Exit");

            int input = Integer.parseInt(reader.readLine());

            if (input == 0){
                run = false;
            }

            else{
                userActions.numberAction(input);
            }

        }
    }
}
