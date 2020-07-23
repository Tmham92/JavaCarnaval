package designpatterns.strategy;

public class Walking implements Commute {
    private int travelTIme = 60;
    private boolean isGoodForHealth = true;

    public int getTravelTIme() {
        return travelTIme;
    }

    public void setTravelTIme(int travelTIme) {
        this.travelTIme = travelTIme;
    }

    public boolean getIsGoodForHealth() {
        return isGoodForHealth;
    }

    public void setGoodForHealth(boolean goodForHealth) {
        isGoodForHealth = goodForHealth;
    }

    @Override
    public int travelTime() {
        System.out.println("Travel time is: " + getTravelTIme() + " minutes.");
        return getTravelTIme();
    }

    @Override
    public boolean isGoodForHealth() {
        return isGoodForHealth;
    }

}
