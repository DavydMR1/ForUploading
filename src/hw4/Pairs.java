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

    public String getFirst(int id) {
        return String.valueOf(keys[id]);
    }

    public String getLast(int id) {
        return String.valueOf(objects[id]);
    }
}
