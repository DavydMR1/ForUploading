package hw2;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        for (int i = 1; i <= 5; i++) {
            tree.insert(i);
        }
        System.out.println(tree.find(5));
        System.out.println(tree.find(6));
    }
}
