package hw4;

public class Pairs {
    private int[] keys;
    private Object[] objects;
    public Pairs(Object[] object) {
        if (object != null) {
            this.keys = new int[object.length];
            for (int i = 0; i < keys.length; i++) {
                keys[i] = i;
            }
            this.objects = object;
        }
    }

    public String combine() {
        StringBuilder builder = new StringBuilder();
        for (Object i : objects) {
            builder.append(i).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

        public Integer combineNumbers() {
        Integer a = 0;
        for (Object i : objects) {
            try {
                a += Integer.parseInt(i.toString());
            }
            catch (NumberFormatException ignored) {}
        }
        return a;
    }
}
