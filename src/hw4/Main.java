package hw4;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        String b = "banana";
        int c = 105;
        Pairs pairs = new Pairs(new Object[]{a, b, c});
        System.out.println(pairs.getFirst(1));
        System.out.println(pairs.getLast(2));
    }
}
