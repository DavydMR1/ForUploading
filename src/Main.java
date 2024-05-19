import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("10");
        list.add("100");
        list.add("50");
        System.out.println(list);
        System.out.println(list.get(0));
        list.delete(1);
        System.out.println(list);
        MyLinkedList<String> newlist = new MyLinkedListCode<>();
        newlist.addtofront("31");
        System.out.println(newlist);
        newlist.addtoback("32");
        System.out.println(newlist);
        newlist.addtoback("33");
        System.out.println(newlist);
        newlist.addtofront("34");
        System.out.println(newlist);
        newlist.delete(1);
    }
}