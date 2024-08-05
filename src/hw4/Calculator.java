package hw4;

public class Calculator {
    public static Double sum(Object a, Object b) {
        return Double.parseDouble(a.toString()) + Double.parseDouble(b.toString());
    }

    public static Double subtract(Object a, Object b) {
        return Double.parseDouble(a.toString()) - Double.parseDouble(b.toString());
    }

    public static Double multiply(Object a, Object b) {
        return Double.parseDouble(a.toString()) * Double.parseDouble(b.toString());
    }

    public static Double divide(Object a, Object b) {
        return Double.parseDouble(a.toString()) / Double.parseDouble(b.toString());
    }
}
