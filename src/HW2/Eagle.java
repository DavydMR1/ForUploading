package HW2;

public class Eagle extends Animal {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("Eagle can't swim");
    }
}