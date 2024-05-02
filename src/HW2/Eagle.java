package HW2;

public class Eagle extends Animal implements Flyable, Goable{
    public Eagle(String name, String illness) {
        super(name, illness);
    }

    @Override
    public double run() {
        return 10;
    }

    @Override
    public double fly() {
        return 150;
    }
}