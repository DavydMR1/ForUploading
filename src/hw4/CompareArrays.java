package hw4;

public class CompareArrays {
    public boolean compareArrays(Object[] a, Object[] b) {
        if (a.length == b.length) {
            boolean n = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    n = false;
                    break;
                }
            }
            return n;
        }
        return false;
    }
}
