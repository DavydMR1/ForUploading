package hw6;

import java.util.Arrays;

public class Util {
    public int min(int[] data) {
        int a = Integer.MAX_VALUE;
        for (int datum : data) {
            if (a > datum) {
                a = datum;
            }
        }
        return a;
    }

    private int max(int[] data) {
        int a = Integer.MIN_VALUE;
        for (int datum : data) {
            if (a < datum) {
                a = datum;
            }
        }
        return a;
    }

    public int[] sort(int[] data) {
        int[] a = new int[data.length];
        Arrays.fill(a, -1);
        for (int i = min(data); i <= max(data); i++) {
            for (int j = 0; j < data.length; j++) {
                if (i == data[j]) {
                    for (int k = 0; k < a.length; k++) {
                        if (a[k] == -1) {
                            a[k] = j;
                            break;
                        }
                    }
                }
            }
        }
        return a;
    }

    public boolean allEquals(int[] data, int target) {
        boolean a = true;
        for (int i : data) {
            if (i < target) {
                a = false;
                break;
            }
        }
        return a;
    }

    public int getNext(int number, int total) {
        if (number + 1 > total - 1) {
            return number - total + 1;
        }
        else {
            return number + 1;
        }
    }

    public int getPrevious(int number, int total) {
        if (number == 0) {
            return total - 1;
        }
        else {
            return number - 1;
        }
    }
}
