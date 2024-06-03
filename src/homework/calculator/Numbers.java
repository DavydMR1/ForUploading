package homework.calculator;

public class Numbers {
    private long a;
    private long ai;
    private long b;
    private long bi;

    public Numbers(long x, long xi, long y, long yi) {
        this.a = x;
        this.ai = xi;
        this.b = y;
        this.bi = yi;
    }

    public Long Geta() {
        return a;
    }
    public Long Getai() {
        return ai;
    }
    public Long Getb() {
        return b;
    }
    public Long Getbi() {
        return bi;
    }
    public String toString() {
        return String.format("First number: %s + %si; Last number %s + %si", a, ai, b, bi);
    }
}
