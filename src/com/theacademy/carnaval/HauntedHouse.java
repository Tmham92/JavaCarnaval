package com.theacademy.carnaval;

public class HauntedHouse extends Attraction {
    double prize = 3.20;
    double earnings = 0;
    int ticketsSold;
    double area;

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

    public void run() {
        setTicketsSold(getTicketsSold() +1);
        setEarnings(getEarnings() + getPrize());
    }

    @Override
    public String toString() {
        return "HauntedHouse{" +
                "prize=" + prize +
                ", earnings=" + earnings +
                ", tickets=" + ticketsSold +
                '}';
    }
}
