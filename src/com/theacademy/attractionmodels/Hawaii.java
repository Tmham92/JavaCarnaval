package com.theacademy.attractionmodels;

import java.util.Scanner;

public class Hawaii extends Attraction implements HighRiskAttraction {
    double prize = 2.90;
    double earnings = 0;
    int ticketsSold;
    double area;
    int spinningLimit = 10;

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

    public Hawaii() {
        attractionCheck();
    }

    @Override
    public void run() {
        setSpinningLimit(getSpinningLimit() - 1);
        ticketsSold += 1;
        if (getSpinningLimit() == 0) {
            maintainAttraction();
        }
        earnings += prize;
        totalEarnings += prize;
        System.out.println("Spins Left " + getSpinningLimit());
    }

    @Override
    public String toString() {
        return "Hawaii{" +
                "prize=" + prize +
                ", earnings=" + earnings +
                ", ticketsSold=" + ticketsSold +
                '}';
    }

    @Override
    public void attractionCheck() {
        System.out.println("Hawaii is checked! Spin limit is: " + spinningLimit);
    }

    @Override
    public void maintainAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hawaii must be maintained.");
        System.out.println("Type 'maintain'.");
        if (!scanner.next().equals("maintain")) {
            System.out.println("Please maintain attraction");
            maintainAttraction();
        }
        else {
            setSpinningLimit(10);
        }
    }
}
