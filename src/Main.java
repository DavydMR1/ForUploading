import java.util.ArrayList;
import java.util.HashMap;


class BookOfNumbers {
    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<String> b = new ArrayList<>();
    int c;
    String d;
    int e;

    // Метод для добавления имени в HashMap
    public void addNumber(String name, Integer number) {
        a = new ArrayList<>();
        if (phoneBook.containsKey(name))
        {
            a = phoneBook.get(name);
            a.add(number);
        }
        else {
            a.add(number);
            phoneBook.put(name, a);
            b.add(name);
        }
    }

    public void Printer() {
        for (int i = 0; i < phoneBook.size(); i++) {
            c = 0;
            for (int j = 0; j < phoneBook.size() - i; j++) {
                d = b.get(j);
                a = phoneBook.get(d);
                if (a.size() > c) {
                    c = a.size();
                    e = j;
                }
            }
            System.out.println(b.get(e) + " " + phoneBook.get(b.get(e)));
            b.remove(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String name1 = "AAA";
        String name2 = "BBB";
        String name3 = "CCC";
        Integer number1 = 2909;
        Integer number2 = 2022;
        Integer number3 = 2349;
        Integer number4 = 6342;
        Integer number5 = 2989;
        Integer number6 = 3112;
        BookOfNumbers a = new BookOfNumbers();
        a.addNumber(name1, number1);
        a.addNumber(name1, number2);
        a.addNumber(name1, number3);
        a.addNumber(name2, number4);
        a.addNumber(name3, number5);
        a.addNumber(name3, number6);
        a.Printer();
    }
}
