package com.theacademy.attractionmodels;

public class MirrorPalace extends Attraction {
    double prize = 2.75;
    double earnings = 0;
    int tickets;
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

    @Override
    public void run() {
        tickets += 1;
        earnings += getPrize();
        System.out.println("Mirror Palace is Working!");
    }

    @Override
    public String toString() {
        return "MirrorPalace{" +
                "prize=" + prize +
                ", earnings=" + earnings +
                ", tickets=" + tickets +
                '}';
    }
}
