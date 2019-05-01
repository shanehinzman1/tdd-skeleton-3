package com.chikli.demo;

import com.chikli.demo.Main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String departureCity;
    private String arrivalCity;
    private String departDate;
    private String departTime;
    private String arrivalTime;
    private String duration;
    private double price;
    private int numOfPeople;
    private int flightNumber;

    public static List<Flight> flights = new ArrayList();

    public Flight(String departureCity, String arrivalCity, String departDate, String departTime, String arrivalTime, String duration, double price, int numOfPeople, int flightNumber) {

        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
        this.numOfPeople = numOfPeople;
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public static void addFlights(Flight flight){
        flights.add(flight);
    }

    public static List<Flight> getFlights(){
        return flights;
    }
}
