package com.chikli.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mainUserInput(reader, System.out);
    }

    public static void mainUserInput(BufferedReader reader, PrintStream out) throws IOException {
        boolean run = true;
        out.println("Welcome to Debbie's Unbelievable Hellicopters Flight Reservation Software");
        out.println("=========================================================================");
        out.println();

        while (run == true) {
            out.println();
            out.println("Please select an option");
            out.println("1. Show current flights");
            out.println("2. Import flight data from file");
            out.println("3. Add a flight");
            out.println("4. Delete a flight");
            out.println("0. Exit");

            String input = reader.readLine();
            int stringInt;

            try {
                stringInt = Integer.parseInt(input);
            }
            catch(Exception e){
                stringInt = 9;
            }

            if (stringInt == 0){
                run = false;
            }

            else{
                userActions.numberAction(stringInt);
            }

        }
    }
}
