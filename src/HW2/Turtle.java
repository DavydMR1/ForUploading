package HW2;

public class Turtle extends Animal{
    public Turtle(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.printf("%s can't fly\n", type);
    }
}
