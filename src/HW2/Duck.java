package HW2;

public class Duck extends Animal implements Goable, Swimmable, Flyable{
    public Duck(String name, String illness) {
        super(name, illness);
    }

    @Override
    public double fly() {
        return 100;
    }

    @Override
    public double run() {
        return 15;
    }

    @Override
    public double Acceleration() {
        return Goable.super.Acceleration();
    }

    @Override
    public double swim() {
        return 5;
    }
}
