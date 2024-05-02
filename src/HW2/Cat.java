package HW2;

public class Cat extends Animal implements Goable {
    public Cat(String name, String illness) {
        super(name, illness);
    }

    @Override
    public double run() {
        return 20;
    }

    @Override
    public double Acceleration() {
        return Goable.super.Acceleration();
    }
}
