package com.theacademy.carnaval.attractionmodels;

public class BumperCarts extends Attraction {
    double prize = 2.50;
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

    public int getTickets() {
        return ticketsSold;
    }

    public void setTickets(int tickets) {
        this.ticketsSold = tickets;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    @Override
    public void run() {
        setTicketsSold(getTicketsSold() + 1);
        setEarnings(getEarnings() + getPrize());
    }

    @Override
    public String toString() {
        return "BumperCarts{" +
                "prize=" + prize +
                ", earnings=" + earnings +
                ", tickets=" + ticketsSold +
                '}';
    }
}
