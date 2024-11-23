public class hw1extra {
    public void fun1(int m, int n) {
        System.out.println(m);
        if (m < n) {
            fun1(m + 1, n);
        }
        System.out.println(" ");
    }

    public int fun2(int m, int n) {
        System.out.println(m + " " + n);
        if (m == 0) {
            return n + 1;
        }
        if (m > 0) {
            if (n == 0) {
                fun2(m - 1, 1);
            }
            if (n > 0) {
                fun2(m - 1, fun2(m, n - 1));
            }
        }
        System.out.println(" ");
        return 0;
    }

    public void fun3(int[] a) {
        System.out.println(a[a.length - 1]);
        int[] b = new int[a.length - 1];
        System.arraycopy(a, 0, b, 0, a.length - 1);
        if (b.length > 0) {
            fun3(b);
        }
        System.out.println(" ");
    }
}
