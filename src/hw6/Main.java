package hw6;

import java.util.Arrays;

public class Main {
    //философ1, вилка1, философ2, вилка2, философ3, вилка3, философ4, вилка4, философ5, вилка5, вернуться в начало
    //рядом сидящие философы не едят одновременно
    //[1, 0, 1, 0, 0]
    //[0, 1, 0, 1, 0]
    //[0, 0, 1, 0, 1]
    //[1, 0, 0, 1, 0]
    //[0, 1, 0, 0, 1]
    //за 5 циклов все 5 философов могут поесть 2 раза
    //в любом случае одновременно поесть погут только двое
    //в любом случае 1 философ поест 4 раза
    //список доступных вилок не нужен
    //при нечетном числе после 2х циклов остается 1 нетронутое значение
    //значения нужно обрабатывать в порядке возрастания

    public static void main(String[] args) {
        int total = 5;
        int[] eat = new int[total];
        Arrays.fill(eat, 0);
        boolean[] ate1 = new boolean[total];
        Arrays.fill(ate1, false);
        boolean[] ate2 = new boolean[total];
        Arrays.fill(ate2, false);
        Util util = new Util();
        while (!util.allEquals(eat, 3)) {
            ate1 = new boolean[ate2.length];
            System.arraycopy(ate2, 0, ate1, 0, ate2.length);
            Arrays.fill(ate2, false);
            int[] a = util.sort(eat);
            int b = 0;
            for (int i = 0; i < a.length; i++) {
                if (i == 0) {
                    eat[a[i]]++;
                    ate2[a[i]] = true;
                } else {
                    if (!ate2[util.getPrevious(a[i], total)] && !ate2[util.getNext(a[i], total)]) {
                        if (!ate1[a[i]]) {
                            eat[a[i]]++;
                            ate2[a[i]] = true;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(eat));
        }
    }
}
