package HW2;

public interface Goable {
    public final static int i = 0;
    double run();
    default double Acceleration() {
        return 9.8;
    }
}
