import java.util.HashMap;
import java.util.Iterator;

public class MyLinkedListCode <S extends Comparable<S>> implements MyLinkedList<S>{
    private S[] values;
    private Integer[] id1;
    private Integer[] id2;
    private int size;
    private int capacity;
    private int firstid;
    private int lastid;
//    public HashMap pineapple(Integer[] i, Integer[] j, S[] k, Integer[] l) {
//        return null;
//    }
    @SuppressWarnings("unchecked")
    public MyLinkedListCode() {
        this.size = 0;
        this.capacity = 10;
        int firstid;
        int lastid;
        try {
            this.values = (S[]) new Comparable[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        try {
            this.id1 = new Integer[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        try {
            this.id2 = new Integer[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        //this.pineapple(id, id1, values, id2);
    }
    private void addCapacity () {
        S[] temp = (S[]) new Comparable[capacity + capacity / 2];
        System.arraycopy(values, 0, temp, 0, values.length);
        Integer[] idtemp1 = new Integer[capacity + capacity / 2];
        System.arraycopy(id1, 0, idtemp1, 0, id1.length);
        Integer[] idtemp2 = new Integer[capacity + capacity / 2];
        System.arraycopy(id2, 0, idtemp2, 0, id2.length);
        values = temp;
        id1 = idtemp1;
        id2 = idtemp2;
    }
    @Override
    public void addtofront(S element) {
        if (size == capacity) {
            addCapacity();
        }
        values[size] = element;
        if (size == 0) {
            lastid = size;
        }
        else {
            id1[firstid] = size;
            id2[size] = firstid;
        }
        firstid = size;
        size++;
    }
    @Override
    public void addtoback(S element) {
        if (size == capacity) {
            addCapacity();
        }
        values[size] = element;
        if (size == 0) {
            firstid = size;
        }
        else {
            id2[lastid] = size;
            id1[size] = lastid;
        }
        lastid = size;
        System.out.println(lastid);
        size++;
    }
    @Override
    public void delete(int index) {
        int currentid = -1;
        if (index > size / 2) {
            currentid = lastid;
            for (int i = size; i > index; i--) {
                currentid = id1[currentid];
            }
        }
        else {
            currentid = firstid;
            for (int i = 0; i < index; i--) {
                currentid = id2[currentid];
            }
        }
        S[] temp = (S[]) new Comparable[capacity - 1];
        Integer[] idtemp1 = new Integer[capacity - 1];
        Integer[] idtemp2 = new Integer[capacity - 1];
        System.arraycopy(values, 0, temp, 0, currentid);
        System.arraycopy(id1, 0, idtemp1, 0, currentid);
        System.arraycopy(id2, 0, idtemp2, 0, currentid);
        int aeai = temp.length - index - 1;
        System.arraycopy(values, currentid + 1, temp, currentid, aeai);
        System.arraycopy(id1, currentid + 1, idtemp1, currentid, aeai);
        System.arraycopy(id2, currentid + 1, idtemp2, currentid, aeai);
        values = temp;
        id1 = idtemp1;
        id2 = idtemp2;
    }

    @Override
    public void delete(S element) {

    }

    @Override
    public S get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(values[i]).append(", ");
        }
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        builder.append("\n");
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(id1[i]).append(", ");
        }
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        builder.append("\n");
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(id2[i]).append(", ");
        }
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        builder.append("\n");
        builder.append("[");
        builder.append(firstid).append(", ").append(lastid);
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
