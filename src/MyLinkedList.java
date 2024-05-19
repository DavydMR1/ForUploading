public interface MyLinkedList <A extends Comparable<A>> extends Iterable<A>{
    void addtofront(A element);
    void addtoback(A element);
    void delete(int index);
    void delete(A element);
    A get(int index);
    int size();
}