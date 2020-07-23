package designpatterns.strategy;

public class Context {
    public Commute commute;

    public Context(Commute commute) {
        this.commute = commute;
    }

    public int commuteTravelTime() {
        return commute.travelTime();
    }

    public boolean isGoodForHealth() {
        return commute.isGoodForHealth();
    }
}
