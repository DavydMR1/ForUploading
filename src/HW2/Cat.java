package HW2;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.printf("%s can't fly\n", type);
    }

    @Override
    public void swim() {
        System.out.println("Cats are afraid of water\n");
    }


}
