package HW2;

public class Animal {
    protected String type;
    protected String name;
    protected String illness;
    public Animal (String name, String illness) {
        this.name = name;
        this.type = getClass().getSimpleName();
        this.illness = illness;
    }

    @Override
    public String toString() {
        return String.format("%s name = %s, %s", type, name, illness);

    }
}
