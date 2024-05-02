package HW2;

public class Turtle extends Animal implements Goable, Swimmable{
    public Turtle(String name, String illness) {
        super(name, illness);
    }

    @Override
    public double run() {
        return 5;
    }

    @Override
    public double Acceleration() {
        return Goable.super.Acceleration();
    }

    @Override
    public double swim() {
        return 15;
    }
}
