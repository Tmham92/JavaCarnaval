package designpatterns.strategy;

public class Car implements Commute {
    private int travelTime = 10;
    private boolean isGoodForHealth = false;

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public boolean getIsGoodForHealth() {
        return isGoodForHealth;
    }

    public void setGoodForHealth(boolean goodForHealth) {
        isGoodForHealth = goodForHealth;
    }

    @Override
    public int travelTime() {
        System.out.println("Travel time is: " + travelTime + " minutes.");
        return travelTime;
    }

    @Override
    public boolean isGoodForHealth() {
        return false;
    }

}
