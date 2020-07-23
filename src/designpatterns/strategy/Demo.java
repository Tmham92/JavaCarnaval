package designpatterns.strategy;

public class Demo {
    public static void main(String[] args) {
        Context context = new Context(new Bike());
        System.out.println("Traveling by " + context.commute.getClass().getSimpleName());
        context.commuteTravelTime();
        System.out.println("Is this a good way? " + context.isGoodForHealth());
        System.out.println("");

        Context context2 = new Context(new Car());
        System.out.println("Traveling by " + context2.commute.getClass().getSimpleName());
        context2.commuteTravelTime();
        System.out.println("Is this a good way? " + context2.isGoodForHealth());
        System.out.println("");

        Context context3 = new Context(new Walking());
        System.out.println("Traveling by " + context3.commute.getClass().getSimpleName());
        context3.commuteTravelTime();
        System.out.println("Is this a good way? " + context3.isGoodForHealth());
        System.out.println("");

    }
}
