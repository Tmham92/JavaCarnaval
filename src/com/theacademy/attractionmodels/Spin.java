package com.theacademy.attractionmodels;

import java.util.Scanner;

public class Spin extends Attraction implements HighRiskAttraction {
    double prize = 2.25;
    double area;
    double earnings = 0;
    int ticketsSold;
    int spinningLimit = 5;

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public int getSpinningLimit() {
        return spinningLimit;
    }

    public void setSpinningLimit(int spinningLimit) {
        this.spinningLimit = spinningLimit;
    }

    public Spin() {
        attractionCheck();
    }

    @Override
    public void run() {
        setSpinningLimit(getSpinningLimit() - 1);
        if (getSpinningLimit() == 0) {
            maintainAttraction();
        }
        setTicketsSold(getTicketsSold() + 1);
        setEarnings(getEarnings() + getPrize());
        System.out.println("Spins Left " + getSpinningLimit());
    }

    @Override
    public String toString() {
        return "Spin{" +
                "prize=" + prize +
                ", earnings=" + earnings +
                ", tickets=" + ticketsSold +
                '}';
    }

    @Override
    public void attractionCheck() {
        System.out.println("Spin is checked! Spin limit is: " + getSpinningLimit());
    }

    @Override
    public void maintainAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spin must be maintained.");
        System.out.println("Type 'maintain'.");
        if (!scanner.next().equals("maintain")) {
            System.out.println("Please maintain attraction");
            maintainAttraction();
        }
        else {
            setSpinningLimit(5);
        }
    }
}
