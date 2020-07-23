package com.theacademy.carnaval;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cashier {
    double moneyEarned = 0;
    int ticketsSold = 0;
    double taxesPaid = 0;
    int timesTaxesPaid = 0;

    List<Double> moneyPerAttraction = new ArrayList<Double>(Collections.nCopies(7, 0.0));
    List<Integer> ticketsPerAttraction = new ArrayList<>(Collections.nCopies(7, 0));


    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public double getTaxesPaid() {
        return taxesPaid;
    }

    public void setTaxesPaid(double taxesPaid) {
        this.taxesPaid = taxesPaid;
    }

    public int getTimesTaxesPaid() {
        return timesTaxesPaid;
    }

    public void setTimesTaxesPaid(int timesTaxesPaid) {
        this.timesTaxesPaid = timesTaxesPaid;
    }

    public void updateTotalEarnings() {
        double zero = 0;
        for (int i = 0; i < moneyPerAttraction.size() - 1; i++) {
            zero += moneyPerAttraction.get(i);
        }
        moneyPerAttraction.set(moneyPerAttraction.size() - 1, zero);
        setMoneyEarned(zero);
    }

    public void updateTotalTicketsSold() {
        int zero = 0;
        for (int i = 0; i < ticketsPerAttraction.size() - 1; i++) {
            zero += ticketsPerAttraction.get(i);
        }
        ticketsPerAttraction.set(ticketsPerAttraction.size() - 1, zero);
        setTicketsSold(zero);
    }

    public void payTaxes(double earnings, double taxPercentage) {
        setTimesTaxesPaid(getTimesTaxesPaid() + 1);
        double taxesToPay = earnings * taxPercentage;
        setTaxesPaid(getTimesTaxesPaid() + taxesToPay);
        moneyPerAttraction.set(5, moneyPerAttraction.get(5) - taxesToPay);
    }


}
