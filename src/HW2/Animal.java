package HW2;

public class Animal {
    protected String type;
    protected String name;

    public Animal (String name) {
        this.name = name;
        this.type = getClass().getSimpleName();
    }

    protected void fly() {
        System.out.printf("%s %s is flying\n", type, name);
    }

    protected void walk() {
        System.out.printf("%s %s is walking\n", type, name);
    }

    protected void swim() {
        System.out.printf("%s %s is swimming\n", type, name);
    }

    @Override
    public String toString() {
        return String.format("%s name = %s \n");

    }
}
