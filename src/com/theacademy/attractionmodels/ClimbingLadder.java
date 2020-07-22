package com.theacademy.attractionmodels;

import com.theacademy.TaxInspector;

public class ClimbingLadder extends Attraction implements GamblingAttraction {
    double prize = 5.00;
    double earnings = 0;
    int ticketsSold;
    double area;
    final double gamblingTaxes = 0.30;


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

    public double getGamblingTaxes() {
        return gamblingTaxes;
    }

    @Override
    public void run() {
        setTicketsSold(getTicketsSold() + 1);
        setEarnings(getEarnings() + getPrize());
    }

    @Override
    public String toString() {
        return "ClimbingLadder{" +
                "prize=" + prize +
                ", earnings=" + earnings +
                ", ticketsSold=" + ticketsSold +
                ", gamblingTaxes=" + gamblingTaxes +
                '}';
    }

    @Override
    public boolean hasToPayTaxes() {
        return true;
    }
}
