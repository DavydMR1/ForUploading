package hw7;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));
        int b = 0;
        for (Object i : Arrays.stream(numbers).filter(a -> a % 2 == 0).toArray()) {
            b += Integer.parseInt(i.toString());
        }
        System.out.println(Double.parseDouble(String.valueOf(b)) / Arrays.stream(numbers).filter(a -> a % 2 == 0).count());
    }
}
