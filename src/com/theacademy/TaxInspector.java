package com.theacademy;

import java.util.Random;

public class TaxInspector {
    double taxReceived = 0;
    boolean hasArrived = false;

    public double getTaxReceived() {
        return taxReceived;
    }

    public void setTaxReceived(double taxReceived) {
        this.taxReceived = taxReceived;
    }

    public boolean isHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public boolean isComing() {
        Random rng = new Random();
        if (rng.nextInt(3) == 1) {
            setHasArrived(true);
        } else {
            setHasArrived(false);
        }
        return hasArrived;
    }

    public double receiveTaxes(double taxPayed, double taxAlreadyCollected) {
        double totalTax = taxPayed + taxAlreadyCollected;
        System.out.println("Inspected has collected: " + totalTax);
        return totalTax;
    }
}
